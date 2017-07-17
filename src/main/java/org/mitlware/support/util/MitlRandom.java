package org.mitlware.support.util;

//////////////////////////////////////////////////////////////////////

public class MitlRandom {

	private static java.util.Random instance_ = new java.util.Random( System.currentTimeMillis() );

	///////////////////////////////

	private MitlRandom() {}

	public static java.util.Random getInstance() { return instance_; }

	///////////////////////////////

	public static boolean nextBoolean() { return instance_.nextBoolean(); }

	public static void nextBytes( byte[] bytes ) { instance_.nextBytes( bytes ); }

	public static double nextDouble() { return instance_.nextDouble(); }

	public static float nextFloat() { return instance_.nextFloat(); }

	public static double nextGaussian() { return instance_.nextGaussian(); }

	public static int nextInt() { return instance_.nextInt(); }

	public static int nextInt(int n) { return instance_.nextInt( n ); }

	public static long nextLong() { return instance_.nextLong(); }

	public static void setSeed(long seed) { instance_.setSeed( seed ); }
}

// End ///////////////////////////////////////////////////////////////