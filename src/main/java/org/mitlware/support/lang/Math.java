package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public final class Math {

    public static int signum( double x ) {
        return x < 0 ? -1 : ( x == 0 ? 0 : 1 );
    }

    ///////////////////////////////

    public static int compare( int a, int b ) {
        return a < b ? -1 : ( a == b ? 0 : 1 );
    }

    public static int compare( long a, long b ) {
        return a < b ? -1 : ( a == b ? 0 : 1 );
    }

    public static int compare( float a, float b ) {
        return a < b ? -1 : ( a == b ? 0 : 1 );
    }

    public static int compare( double a, double b ) {
        return a < b ? -1 : ( a == b ? 0 : 1 );
    }

    public static final double ln2 = java.lang.Math.log( 2.0 );

    public static double log2( double x ) {
        return java.lang.Math.log( x ) / ln2;
    }

	///////////////////////////////

	private Math() {}
}

// End ///////////////////////////////////////////////////////////////
