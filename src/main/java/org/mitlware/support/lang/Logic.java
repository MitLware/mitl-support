package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public final class Logic {
	public static boolean implies( boolean a, boolean b ) {
		return a ? b : true;
	}

	public static boolean iff( boolean a, boolean b ) {
		return a == b;
	}

	///////////////////////////////

	private Logic() {}
}

// End ///////////////////////////////////////////////////////////////
