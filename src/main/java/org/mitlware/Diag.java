package org.mitlware;

//////////////////////////////////////////////////////////////////////

public final class Diag {

	public static boolean DEBUG_OUTPUT_ENABLED = true;

	///////////////////////////////

	public static String where() {
		return ' ' + whereImpl( 2 );
	}

	public static void print( Object s ) {
		if( DEBUG_OUTPUT_ENABLED )
			System.out.print( s + " : " + whereImpl( 2 ) );
	}

	public static void println() {
		if( DEBUG_OUTPUT_ENABLED )
			System.out.println( whereImpl( 2 ) );
	}

	public static void println( Object s ) {
		if( DEBUG_OUTPUT_ENABLED )
			System.out.println( s + " : " + whereImpl( 2 ) );
	}

	///////////////////////////////

	public static boolean assertEnabled() {
		boolean result = true;

		try {
			assert false;
		}
		catch( AssertionError e ) {
			result = false;
		}

		return result;
	}

	///////////////////////////////

	private static class WhereException extends Exception {
		private static final long serialVersionUID = -8086778336879357263L;
	}

	private static String whereImpl( int stackFrameOffset )	{
		String result = "Diag.where: (Unknown Source)";

		try {
			throw new WhereException();
		}
		catch( WhereException ex ) {
			StackTraceElement [] st = ex.getStackTrace();
			if( st.length > stackFrameOffset )
				result = st[ stackFrameOffset ].toString();
		}

		return result;
	}

	private Diag() {}
}

// End ///////////////////////////////////////////////////////////////