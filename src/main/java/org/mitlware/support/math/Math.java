package org.mitlware.support.math;

import java.util.BitSet;

//////////////////////////////////////////////////////////////////////

public final class Math {

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
		return java.lang.Math.abs( a/b - 1.0 ) < Epsilon.getValue();
	}

	public static boolean compareRelativeDifference( double a, double b ) {
		return java.lang.Math.abs( a/b - 1.0 ) < Epsilon.getValue();
	}

	public static boolean compareRelativeDifference( float a, float b, float epsilon ) {
		return java.lang.Math.abs( a/b - 1.0 ) < epsilon;
	}

	public static boolean compareRelativeDifference( double a, double b, double epsilon ) {
		return java.lang.Math.abs( a/b - 1.0 ) < epsilon;
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

	public static int gcd( int a, int b) {     
		while( b > 0 ) {         
			int temp = b;         
			b = a % b; 
			a = temp;     
		}     
		return a; 
	}  
	
	public static int gcd( int [] input ) {     
		int result = input[0];
		for( int i=1; i<input.length; ++i ) 
			result = gcd(result, input[i]);     
		return result; 
	} 

	public static int lcm( int a, int b ) {     
		return a * ( b / gcd( a, b ) ); 
	}  
	
	public static int lcm( int [] input ) {     
		int result = input[0];
		for( int i = 1; i<input.length; ++i ) 
			result = lcm( result, input[i] );
		return result; 
	}

	///////////////////////////////

	private Math() {}
}

// End ///////////////////////////////////////////////////////////////

