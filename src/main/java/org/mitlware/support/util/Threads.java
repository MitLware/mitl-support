package org.mitlware.support.util;

//////////////////////////////////////////////////////////////////////

public final class Threads {

	public static void sleepSeconds( int delayInSeconds ) {
		sleepMilliseconds( delayInSeconds * 1000 );
	}

	public static void sleepMilliseconds( int delayInMilliseconds )	{
		long targetTime = System.currentTimeMillis() + delayInMilliseconds;

		long sleepTime = delayInMilliseconds;
		for( ; sleepTime > 0; ) {
			try {
				Thread.sleep( sleepTime );
			}
			catch( java.lang.InterruptedException e ) {
				// Intentionally Empty
			}

			sleepTime = targetTime - System.currentTimeMillis();
		}
	}

	///////////////////////////////

	private Threads() {}
}

// End ///////////////////////////////////////////////////////////////