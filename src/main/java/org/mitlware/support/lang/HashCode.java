package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public final class HashCode {
    public final static int HASH_MULT = 1000003;

    ///////////////////////////////

    public static int apply( int [] array ) {
        int result = 0;
        for( int i=0; i<array.length; ++i )
            result = ( HASH_MULT * result ) + array[ i ];

        return result;
    }

    public static int apply( long [] array ) {
        int result = 0;
        for( int i=0; i<array.length; ++i )
            result = ( HASH_MULT * result ) + apply( array[ i ] );

        return result;
    }

    public static int apply( double [] array ) {
        int result = 0;
        for( int i=0; i<array.length; ++i )
            result = ( HASH_MULT * result ) + apply( array[ i ] );

        return result;
    }

    public static int apply( Object [] a ) {
    	int result = 0;
        for( Object o : a )
            result = ( HASH_MULT * result ) + o.hashCode();

        return result;
    }

    ///////////////////////////////

    public static int apply( int p1, int p2 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        return result;
    }

    public static int apply( int p1, int p2, int p3 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5, int p6 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        result = ( HASH_MULT * result ) + p6;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5, int p6, int p7 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        result = ( HASH_MULT * result ) + p6;
        result = ( HASH_MULT * result ) + p7;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        result = ( HASH_MULT * result ) + p6;
        result = ( HASH_MULT * result ) + p7;
        result = ( HASH_MULT * result ) + p8;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        result = ( HASH_MULT * result ) + p6;
        result = ( HASH_MULT * result ) + p7;
        result = ( HASH_MULT * result ) + p8;
        result = ( HASH_MULT * result ) + p9;
        return result;
    }

    public static int apply( int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10 ) {
        int result = p1;
        result = ( HASH_MULT * result ) + p2;
        result = ( HASH_MULT * result ) + p3;
        result = ( HASH_MULT * result ) + p4;
        result = ( HASH_MULT * result ) + p5;
        result = ( HASH_MULT * result ) + p6;
        result = ( HASH_MULT * result ) + p7;
        result = ( HASH_MULT * result ) + p8;
        result = ( HASH_MULT * result ) + p9;
        result = ( HASH_MULT * result ) + p10;
        return result;
    }

    ///////////////////////////////

    public static int apply( long p1 ) {
        // return (int)( p1 ^ ( p1 >>> 32 ) );
        return (int)(p1 >>> 32) * HASH_MULT
         + (int)(p1 & 0xFFFFFFFF);
    }

    public static int apply( long p1, long p2 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        return result;
    }

    public static int apply( long p1, long p2, long p3 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5, long p6 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5, long p6, long p7 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5, long p6, long p7, long p8 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5, long p6, long p7, long p8, long p9 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        result = ( HASH_MULT * result ) + apply( p9 );
        return result;
    }

    public static int apply( long p1, long p2, long p3, long p4, long p5, long p6, long p7, long p8, long p9, long p10 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        result = ( HASH_MULT * result ) + apply( p9 );
        result = ( HASH_MULT * result ) + apply( p10 );
        return result;
    }

    ///////////////////////////////

    public static int apply( double p1 ) {
    	long v = ( p1 == 0.0 ) ? 0L : Double.doubleToLongBits( p1 );
    	// ^ if p1 is NaN, conditional test guards against
    	// issue with hashCode "compatability with equals"
    	// @see http://macchiato.com/columns/Durable6.html
        return apply( v );
    }

    public static int apply( double p1, double p2 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        return result;
    }

    public static int apply( double p1, double p2, double p3 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5, double p6 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5, double p6, double p7 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5, double p6, double p7, double p8 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5, double p6, double p7, double p8, double p9 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        result = ( HASH_MULT * result ) + apply( p9 );
        return result;
    }

    public static int apply( double p1, double p2, double p3, double p4, double p5, double p6, double p7, double p8, double p9, double p10 ) {
        int result = apply( p1 );
        result = ( HASH_MULT * result ) + apply( p2 );
        result = ( HASH_MULT * result ) + apply( p3 );
        result = ( HASH_MULT * result ) + apply( p4 );
        result = ( HASH_MULT * result ) + apply( p5 );
        result = ( HASH_MULT * result ) + apply( p6 );
        result = ( HASH_MULT * result ) + apply( p7 );
        result = ( HASH_MULT * result ) + apply( p8 );
        result = ( HASH_MULT * result ) + apply( p9 );
        result = ( HASH_MULT * result ) + apply( p10 );
        return result;
    }

    ///////////////////////////////

    public static int apply( Object p1, Object p2 ) {
    	return apply( p1.hashCode(), p2.hashCode() );
    }

    public static int apply( Object p1, Object p2, Object p3 ) {
    	return apply( p1.hashCode(), p2.hashCode(), p3.hashCode() );
    }

    public static int apply( Object p1, Object p2, Object p3, Object p4 ) {
    	return apply( p1.hashCode(), p2.hashCode(), p3.hashCode(), p4.hashCode() );
    }

    public static int apply( Object p1, Object p2, Object p3, Object p4, Object p5 ) {
    	return apply( p1.hashCode(), p2.hashCode(), p3.hashCode(), p4.hashCode(), p5.hashCode() );
    }

    ///////////////////////////////

    private HashCode() {}
}

// End ///////////////////////////////////////////////////////////////
