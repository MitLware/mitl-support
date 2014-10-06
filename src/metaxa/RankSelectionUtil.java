package metaxa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import jeep.tuple.Tuple2;

//////////////////////////////////////////////////////////////////////

public final class RankSelectionUtil
{
	public static < T > Integer 
	select( List< Double > values, Random random ) {
		return select( values, 1, random ).get( 0 );
	}
	
	///////////////////////////////
	
	public static < T > List< Integer > 
	select( List< Double > values, int numSelections, Random random ) {
		return select( values, numSelections, new Function< Double, Double >() {
			public Double apply(Double x) {
				return x;
			}}, random );
	}
	
	///////////////////////////////
	
	public static < T > List< Integer > 
	select( List< T > values, int numSelections, Function< T, Double > f, Random random ) 
	{
		if( values.isEmpty() )
			throw new IllegalArgumentException();

		///////////////////////////
		
		final List< Tuple2< T, Double > > valuesAndFitnesses = new ArrayList< Tuple2< T, Double > >();
		for( T t : values )
			valuesAndFitnesses.add( Tuple2.cons( t, f.apply( t ) ) );
		
		List< Integer > permutedIndices = new ArrayList< Integer >();
		for( int i=0; i<values.size(); ++i )
			permutedIndices.add( i );
		
		Collections.sort( permutedIndices, new Comparator< Integer >() {
			@Override
			public int compare( Integer a, Integer b ) {
				return - Double.compare( valuesAndFitnesses.get( a ).getSecond(), valuesAndFitnesses.get( b ).getSecond() );
			}} );
		
		///////////////////////////
		
		double [] cumulativeFitness = new double[ values.size() ];
		cumulativeFitness[ 0 ] = values.size(); // f.apply( values.get( 0 ) );		
		for( int i=1; i<cumulativeFitness.length; ++i )
		{
			final double fitness = values.size() - i; // f.apply( values.get( i ) );
			// if( fitness < 0 )
			//	throw new IllegalArgumentException();
				
			cumulativeFitness[ i ] = cumulativeFitness[ i - 1 ] + fitness;    		
		}
		
		List< Integer > unpermutedResult = ProportionalSelectionUtil.selectImpl( cumulativeFitness, numSelections, random ); 

		List< Integer > result = new ArrayList< Integer >();
		for( int i=0; i<unpermutedResult.size(); ++i )
			result.add( permutedIndices.get( unpermutedResult.get( i ) ) );
		
		assert result.size() == numSelections;
		return result;
	}	
}

// End ///////////////////////////////////////////////////////////////

