package org.mitlware.support.math;

//////////////////////////////////////////////////////////////////////

class Epsilon {
	private static final double DEFAULT_VALUE = 0.001;
	private static double value_ = DEFAULT_VALUE;

	public static double getValue() { return value_; }
	public static void setValue( double x ) { value_ = x; }
}

// End ///////////////////////////////////////////////////////////////


