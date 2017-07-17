package org.mitlware.support.math;

import java.util.Iterator;

public final class EuclidianDistanceSquared
{
	public static double apply( double [] a, double [] b ) {
        if( a.length != b.length )
            throw new IllegalArgumentException( "Arrays of equal size expected, found :" + a.length + ", " + b.length );

        double result = 0;
        for( int i=0; i<a.length; ++i ) {
            double d = Math.abs( a[ i ] - b[ i ] );
            result += d * d;
        }

        return result;
	}

	///////////////////////////////

	public static < T1 extends Number, T2 extends Number >
	double apply( Iterator< T1 > a, Iterator< T2 > b ) {
		double result = 0;
		while( a.hasNext() ) {
			double d = ((Number)a.next()).doubleValue() - ((Number)b.next()).doubleValue();
			result += d * d;
		}

		return result;
	}
}

// End ///////////////////////////////////////////////////////////////
