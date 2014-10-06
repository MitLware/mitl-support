package metaxa.random;

import java.util.Random;

public final class RNG {

	private static Random instance = new MTRandom( 0 );
	public static Random get() { return instance; }
}

// End ///////////////////////////////////////////////////////////////

