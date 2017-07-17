package org.mitlware.support.math;

import java.util.Iterator;

import org.mitlware.support.lang.Indexable;

//////////////////////////////////////////////////////////////////////

public final class EuclidianDistance {

	public static double apply( double [] a, double [] b ) {
		if( a.length != b.length )
			throw new IllegalArgumentException();

		double result = 0;
		for( int i=0; i<a.length; ++i ) {
			double d = a[ i ] - b[ i ];
			result += d * d;
		}

		return Math.sqrt( result );
	}

	///////////////////////////////

	public static < T extends Number >
	double apply( Indexable< T > a, Indexable< T > b )
	{
		if( a.size() != b.size() )
			throw new IllegalArgumentException();

		double result = 0;
		for( int i=0; i<a.size(); ++i ) {
			double d = a.get( i ).doubleValue() - b.get( i ).doubleValue();
			result += d * d;
		}

		return Math.sqrt( result );
	}

	///////////////////////////////

	public static < T1 extends Number, T2 extends Number >
	double apply( Iterator< T1 > a, Iterator< T2 > b )
	{
		double result = 0;
		while( a.hasNext() ) {
			double d = ((Number)a.next()).doubleValue() - ((Number)b.next()).doubleValue();
			result += d * d;
		}

		return Math.sqrt( result );
	}

	///////////////////////////////

	private EuclidianDistance() {}
}

// End ///////////////////////////////////////////////////////////////
