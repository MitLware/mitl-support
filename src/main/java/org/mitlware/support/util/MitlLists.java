package org.mitlware.support.util;

import java.util.List;

public final class MitlLists {

	public static < T extends Comparable< T > > int
	lexicographicalCompare( List< T > a, List< T> b ) {
	    return 	lexicographicalCompare(
	    		a, 0, a.size(),
	    		b, 0, b.size() );
	}

	///////////////////////////////

	public static < T extends Comparable< T > > int
	lexicographicalCompare(
			List< T > a,
			int first1, int last1,
			List< T> b,
			int first2, int last2 ) {
	    for( ; first1 != last1 && first2 != last2; ++first1, ++first2 ) {
	        final int cmp = a.get( first1 ).compareTo( b.get( first2 ) );
	        if( cmp != 0 )
	            return cmp;
	    }

	    if( first2 == last2 )
	    	return first1 == last1 ? 0 : 1;

	    return -1;
	}
}

// End ///////////////////////////////////////////////////////////////

