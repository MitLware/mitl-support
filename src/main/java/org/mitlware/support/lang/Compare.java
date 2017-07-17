package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public final class Compare {

	public static int apply( Comparable<Object> aFirst,
		Comparable<Object> bFirst,
		Comparable<Object> aSecond,
		Comparable<Object> bSecond ) {

		final int c1 = aFirst.compareTo( bFirst );
		if( c1 < 0 )
			return -1;
		else if( c1 > 0 )
			return 1;

		final int c2 = aSecond.compareTo( bSecond );
		if( c2 < 0 )
			return -1;
		else if( c2 > 0 )
			return 1;

		return 0;
	}

	///////////////////////////////

	private Compare() {}
}

// End ////////////////////////////////////////////////////////////////

