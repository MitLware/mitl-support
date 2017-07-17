package org.mitlware.support.math;

import java.util.BitSet;

//////////////////////////////////////////////////////////////////////

public final class Utils {

	public static boolean isPermutation( int [] perm ) {

		BitSet check = new BitSet( perm.length );
		for( int i=0; i<perm.length; ++i ) {
			if( perm[ i ] < 0 || perm[ i ] >= perm.length )
				return false;

			check.set( perm[ i ] );
		}

		return check.cardinality() == perm.length;
	}

	///////////////////////////////

	public static boolean compareRelativeDifference( float a, float b ) {
		return Math.abs( a/b - 1 ) < Epsilon.getValue();
	}

	public static boolean compareRelativeDifference( double a, double b ) {
		return Math.abs( a/b - 1 ) < Epsilon.getValue();
	}

	public static int pow( int base, int exp ) {
		if( exp < 0 )
			throw new IllegalArgumentException( "non-negative exponent expected, found " + exp );

		int result = 1;
	    while( exp != 0 )
	    {
	        if( ( exp & 1 ) != 0 )
	        	result *= base;
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}

	///////////////////////////////

	private Utils() {}
}

// End ///////////////////////////////////////////////////////////////

