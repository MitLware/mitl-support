package org.mitlware.metaxa.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import jeep.tuple.Tuple2;

//////////////////////////////////////////////////////////////////////

public final class TournamentSelectionUtil
{
	public static < T > Integer 
	select( List< Double > values, Random random, int tournamentSize ) {
		return select( values, 1, random, tournamentSize ).get( 0 );
	}
	
	///////////////////////////////
	
	public static < T > List< Integer > 
	select( List< Double > values, int numSelections, Random random, int tournamentSize ) {
		return select( values, numSelections, new Function< Double, Double >() {
			public Double apply(Double x) {
				return x;
			}}, random, tournamentSize );
	}
	
	///////////////////////////////
	
	public static < T > List< Integer > 
	select( List< T > values, int numSelections, Function< T, Double > f, Random random, int tournamentSize ) 
	{
		if( values.isEmpty() )
			throw new IllegalArgumentException();
		if( tournamentSize <= 0 )
			throw new IllegalArgumentException();

		///////////////////////////

		List< Integer > result = new ArrayList< Integer >();
		for( int i=0; i<numSelections; ++i )
			result.add( select( values, f, random, tournamentSize ) );
		
		///////////////////////////		
		
		assert result.size() == numSelections;
		return result;
	}	

	///////////////////////////////
	
	public static < T > Integer  
	select( List< T > values, Function< T, Double > f, Random random, int tournamentSize ) 
	{
		if( values.isEmpty() )
			throw new IllegalArgumentException();
		if( tournamentSize <= 0 )
			throw new IllegalArgumentException();

		///////////////////////////
		
		final int randomIndex1 = random.nextInt( values.size() );
		Tuple2< Integer, Double > best = Tuple2.cons( randomIndex1, f.apply( values.get( randomIndex1 ) ));
		
		for( int i=1; i<tournamentSize; ++i ) {
			final int randomIndex2 = random.nextInt( values.size() );			
			Tuple2< Integer, Double > next = Tuple2.cons( randomIndex2, f.apply( values.get( randomIndex2 ) ));
			if( next.getSecond() >= best.getSecond() )
				best = next;
		}
		
		return best.getFirst();
	}	
	
}

// End ///////////////////////////////////////////////////////////////


