package org.mitlware.support.temperature;

import java.util.Random;

public final class MetropolisHastings {

	public static
	boolean apply( double incumbentValue, double incomingValue, double temperature, boolean isMinimizing, Random random ) {

		if( Double.isNaN( temperature ) || temperature < 0 )
			throw new IllegalArgumentException( "Expected non-negative temperature, found:" + temperature );

		if( temperature == 0.0 )
			return isMinimizing ? incomingValue < incumbentValue : incomingValue > incumbentValue;		
		else {
			final double delta = isMinimizing ? incomingValue - incumbentValue : incumbentValue - incomingValue;
			final double acceptProb = 1.0 / ( 1.0 + Math.exp( delta / temperature ) );
			return random.nextDouble() < acceptProb;
		}
	}
}

// End ///////////////////////////////////////////////////////////////
