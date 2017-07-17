package org.mitlware.support.temperature;

import java.util.Random;

public final class MetropolisHastings {

	/*****
	public static
	boolean apply( double lastValue, double currentValue, double temperature, boolean isMinimizing, Random random )
	{
		if( temperature < 0 )
			throw new IllegalArgumentException();

		final double delta = Math.abs( currentValue - lastValue );

		final double numerator = delta;

		double denominator = 1.0 - ( temperature );
		double value = numerator / denominator;
		assert 0 <= value && value <= 1;

		if( isMinimizing )
			value = - value;

		return random.nextDouble() < Math.exp( - value );
	}
	*****/

	public static
	boolean apply( double lastValue, double currentValue, double temperature, boolean isMinimizing, Random random )	{

		if( Double.isNaN( temperature ) || temperature < 0 )
			throw new IllegalArgumentException( "Expected non-negative temperature, found:" + temperature );

		final double delta = lastValue - currentValue;
		if( delta == 0.0 ) {
			return random.nextDouble() < 0.5;
		}
		else
		{
			final double numerator = delta;

			double denominator = 1.0 - temperature;
			double value = numerator / denominator;
			assert 0 <= value && value <= 1;

			if( isMinimizing )
				value = - value;

			return random.nextDouble() < Math.exp( - value );
		}
	}

}

// End ///////////////////////////////////////////////////////////////
