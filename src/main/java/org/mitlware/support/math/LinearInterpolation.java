package org.mitlware.support.math;

import org.mitlware.support.lang.Logic;

public final class LinearInterpolation {

	public static double apply( double inputValue,
			double inputLimit1,
			double inputLimit2,
			double outputLimit1,
			double outputLimit2 )
	{
		if( !Logic.implies( inputLimit1 <= inputLimit2,
				inputLimit1 <= inputValue
                && inputValue <= inputLimit2 ) )
			throw new IllegalArgumentException( "Bad parameter : " + inputLimit1 + " " + inputLimit2 + " " + inputValue );

		if( !Logic.implies( inputLimit1 >= inputLimit2,
				inputLimit2 <= inputValue
                && inputValue <= inputLimit1 ) )
			throw new IllegalArgumentException( "Bad parameter : " + inputLimit1 + " " + inputLimit2 + " " + inputValue );

		if( !Logic.implies( inputLimit1 == inputLimit2,
				outputLimit1 == outputLimit2 ) )
			throw new IllegalArgumentException( "Bad parameter : " + inputLimit1 + " " + inputLimit2 + " " + inputValue );

		if( !Logic.implies( inputLimit1 == inputLimit2,
				inputValue == inputLimit1 ) )
			throw new IllegalArgumentException( "Bad parameter : " + inputLimit1 + " " + inputLimit2 + " " + inputValue );

		double t = ( inputValue - inputLimit1 ) / ( inputLimit2 - inputLimit1 );

		assert 0.0f <= t;
		assert t <= 1.0f;

		// The following uses the minimum number of operators:
		double result = outputLimit2;
		result *= t;

		double r1 = outputLimit1;
		r1 *= ( 1 - t );
		result += r1;

		assert Logic.implies( outputLimit1 <= outputLimit2,
				outputLimit1 - Epsilon.getValue() <= result
				&& result <= outputLimit2 + Epsilon.getValue() );

		assert Logic.implies( outputLimit1 >= outputLimit2,
				outputLimit2 - Epsilon.getValue() <= result &&
				result <= outputLimit1 + Epsilon.getValue() );
		return result;
	}

    ///////////////////////////////

	private LinearInterpolation() {}
}

// End ///////////////////////////////////////////////////////////////
