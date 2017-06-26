package org.mitlware.metaxa.random;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Taken from:
 * http://eyalsch.wordpress.com/2010/04/01/random-sample/ 
 */

//////////////////////////////////////////////////////////////////////

public final class Sampling {

	/**
	 * Assuming  that the collection to take the sample from is random access, 
	 * we can repeatedly add random items from the collection to 
	 * our result set, until the set contains m different items. 
	 * As an optimisation, when m > n/2, we can choose (n-m) items 
	 * instead of m, and then return the rest.
	 * The expected time complexity is linear in m, 
	 * which is optimal. This is a little surprising, given the 
	 * naive nature of the algorithm, and it results from the above 
	 * optimisation.
	 */
			
	public static <T> Set<T> randomSample1(List<T> items, int m, Random rnd ){
	    HashSet<T> res = new HashSet<T>();
	    int n = items.size();
	    if (m > n/2){ // The optimisation
	        Set<T> negativeSet = randomSample1(items, n-m, rnd);
	        for(T item : items){
	            if (!negativeSet.contains(item))
	                res.add(item);
	        }
	    }else{ // The main loop
	        while(res.size() < m){
	            int randPos = rnd.nextInt(n);
	            res.add(items.get(randPos));
	        }
	    }
	    return res;
	}

	///////////////////////////////
	
	/**
	 * If our collection is random access and its items 
	 * can be freely reordered, then we can efficiently 
	 * draw random items one by one from a candidates set, 
	 * containing only items not chosen so far. 
	 * By swapping items, we can guarantee that the 
	 * candidates set is always contiguous. As a matter of fact, 
	 * this algorithm is a bounded version of the Knuth Shuffle 
	 * algorithm for generating random permutations, and its 
	 * correctness is trivial.
	 */
	
	public static <T> List<T> randomSample2(List<T> items, int m, Random rnd )
	{
		for(int i=0;i<items.size();i++){
	        int pos = i + rnd.nextInt(items.size() - i);
	        T tmp = items.get(pos);
	        items.set(pos, items.get(i));
	        items.set(i, tmp);
	    }
	    return items.subList(0, m);
	}
	
	///////////////////////////////
	
	/**
	 * Sometimes our collection is not random access, 
	 * so we have no choice but to traverse it completely 
	 * in the worst case. Following is an elegant solution, 
	 * that iterates once through the items, and selects an 
	 * item with probability: 
	 * (#remaining to select)/(#remaining to scan).
	 * The running time is O(n), which is optimal given 
	 * the constraints.
	 */
		
	public static <T> List<T> randomSample3( Collection<T> items, int m, Random rnd ){
		return randomSample3( items.iterator(), items.size(), m, rnd );
	}

	public static <T> List<T> randomSample3( Iterator<T> it, int numItems, int m, Random rnd ){
	    ArrayList<T> res = new ArrayList<T>(m);
	    int visited = 0;
	    // Iterator<T> it = items.iterator();
	    while (m > 0){
	        T item = it.next();
	        if (rnd.nextDouble() < ((double)m)/( numItems - visited)){
	            res.add(item);
	            m--;
	        }
	        visited++;
	    }
	    return res;
	}
	
	///////////////////////////////
	
	/**
	 * If we have a read-only random-access collection, but 
	 * we don�t want the time complexity to be dependent on N, 
  	 * we can use Floyd�s algorithm. It iterates with variable 
  	 * i through the last m indexes of the collection, 
  	 * and on each iteration adds a single item from 
  	 * the range 0..i, with a non-uniform distribution
  	 * The time complexity is O(m) on the average, 
  	 * but we can bound the worst case time by O(m log(m)) 
  	 * if we use a balanced tree instead of a hash set.
  	 */ 
				
	public static <T> Set<T> randomSample4(List<T> items, int m, Random rnd ){   
	    HashSet<T> res = new HashSet<T>(m); 
	    int n = items.size();
	    for(int i=n-m;i<n;i++){
	        int pos = rnd.nextInt(i+1);
	        T item = items.get(pos);
	        if (res.contains(item))
	            res.add(items.get(i));
	        else
	            res.add(item);      
	    }
	    return res;
	}
	
	///////////////////////////////	
	

	/**
	 * Sometimes we don�t know the collection size in advance. 
	 * We can only iterate through it, as if it was a data stream 
	 * with unknown size. The following algorithm (known as 
	 * Reservoir sampling) performs only one pass on the input 
	 * stream. While iterating, it maintains a set of items that 
	 * represents a random subset (of size m) of the items 
	 * visited so far. It starts by selecting the first m items, 
	 * and then it selects the k-th item with probability m/k. 
	 * If the item is selected, it replaces a randomly chosen 
	 * item from the previously selected ones:	
	 */
	
	public static <T> List<T> 
	reservoirSample( Iterator<T> it, int m, Random rnd ) {   
	    ArrayList<T> res = new ArrayList<T>(m);   
	    int count = 0;
	    while( it.hasNext() )
	    {      
	    	T item = it.next();	    	
	        count++;
	        if (count <= m)           
	            res.add(item);       
	        else{  
	            int r = rnd.nextInt(count);
	            if (r < m)               
	                res.set(r, item);       
	        }   
	    }   
	    return res;
	}

	public static <T> List<T> 
	reservoirSample( Iterable<T> it, int m, Random rnd ){   
	    return reservoirSample( it.iterator(), m, rnd );
	}
	
	///////////////////////////////	
	
	public static BitSet randomSubset( int numItems, int numIndices, Random random )
	{
		BitSet result = new BitSet( numItems ); 

		final int n = numItems;
		final int m = numIndices;		

		for( int i=n-m; i<n; ++i )
		{  
			final int pos = random.nextInt( i+1 );  
			if( result.get( pos ) )  
				result.set( i );  
			else 
				result.set( pos );        
		}  

		assert result.cardinality() == numIndices;
		return result;  
	} 
	
	public static int [] randomSubsetArray( int numItems, int numIndices, Random random )
	{
		BitSet indices = randomSubset( numItems, numIndices, random );
		int [] result = new int [ numIndices ];
		for( int i=0, index = indices.nextSetBit(0); index >= 0; ++i, index = indices.nextSetBit( index+1 ) )
			result[ i ] = index;
		
		return result;
	}

	///////////////////////////////
	
	public static void main( String [] args )
	{
		Random random = new Random( 0x12345678 );
		
		final int numItems = 10;
		final int numIndices = 5;
		for( int i=0; i<1000; ++i )
		{
			BitSet b = Sampling.randomSubset( numItems, numIndices, random );
			System.out.println( b );
		}
	}
}

// End ///////////////////////////////////////////////////////////////

