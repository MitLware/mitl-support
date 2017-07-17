package org.mitlware.support.util;

public final class MitlArrays
{
	///////////////////////////////

	public static int lexicographicalCompare( int [] a, int [] b )
	{
	    return lexicographicalCompare( a, 0, a.length, b, 0, b.length );
	}

	public static int lexicographicalCompare( int [] a, int first1,  int last1,
            int [] b, int first2, int last2 )
	{
		for ( ; first1 != last1 && first2 != last2; ++first1, ++first2 )
		{
			if ( a[ first1 ] < b[ first2 ] )
				return -1;
			if ( b[ first2 ] < a[ first1 ] )
				return 1;
		}

		if( first2 == last2 )
			return first1 == last1 ? 0 : 1;
		else
			return -1;
	}

	///////////////////////////////

	public static int lexicographicalCompare( double [] a, double [] b )
	{
	    return lexicographicalCompare( a, 0, a.length, b, 0, b.length );
	}

	public static int lexicographicalCompare( double [] a, int first1, int last1, double [] b, int first2, int last2 )
	{
	    for( ; first1 != last1 && first2 != last2; ++first1, ++first2 )
	    {
	        if( a[ first1 ] < b[ first2 ] )
	            return -1;
	        if( b[ first2 ] < a[ first1 ] )
	            return 1;
	    }

	    if( first2 == last2 )
	    	return first1 == last1 ? 0 : 1;

	    return -1;
	}

	///////////////////////////////

	public static < T extends Comparable< T > >
	int lexicographicalCompare( T [] a, T [] b )
	{
	    return lexicographicalCompare( a, 0, a.length, b, 0, b.length );
	}

	public static < T extends Comparable< T > >
	int lexicographicalCompare( T [] a, int first1, int last1, T [] b, int first2, int last2 )
	{
	    for( ; first1 != last1 && first2 != last2; ++first1, ++first2 )
	    {
	        if( a[ first1 ].compareTo( b[ first2 ] ) < 0 )
	            return -1;
	        if( b[ first2 ].compareTo( a[ first1 ] ) < 0 )
	            return 1;
	    }

	    if( first2 == last2 )
	        return first1 != last1 ? 1 : 0;

	    return -1;
	}

	///////////////////////////////

	public static String toCommaString( final double [] a )
	{
		StringBuffer buffer = new StringBuffer();
		if( a != null )
		{
			for( int i=0; i<a.length; ++i )
			{
				buffer.append( a[ i ] );
				if( i < a.length - 1 )
					buffer.append( ',' );
			}
		}

	    return new String( buffer );
	}

	public static <T> String toCommaString( final T[] a )
	{
		StringBuffer buffer = new StringBuffer();
		if( a != null )
		{
			for( int i=0; i<a.length; ++i )
			{
				buffer.append( a[ i ] );
				if( i < a.length - 1 )
					buffer.append( ',' );
			}
		}

	    return new String( buffer );
	}

	///////////////////////////////

	private MitlArrays() {}
}
