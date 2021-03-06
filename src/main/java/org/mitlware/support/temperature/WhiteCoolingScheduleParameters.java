package org.mitlware.support.temperature;

import org.mitlware.support.math.ClosedInterval;

import org.apache.commons.math3.stat.StatUtils;

//////////////////////////////////////////////////////////////////////

/**
	@see:
	@inproceedings{white:1984,
    	address = {Port Chester, NY},
    	author = {White, S. R.},
    	booktitle = {Proceeedings of the IEEE International Conference on Computer Design (ICCD) '84},
    	pages = {646--651},
    	title = {Concepts of Scale in Simulated Annealing},
    	year = {1984}
	}
*/

public final class WhiteCoolingScheduleParameters {

	public static ClosedInterval
	WhiteTemperatureRangeForSA( double [] fitnessTrajectory ) {
		if( fitnessTrajectory.length == 0 )
			throw new IllegalArgumentException();

		Double minDifference = null;
		for( int i=1; i<fitnessTrajectory.length; ++i ) {
			final double delta = Math.abs( fitnessTrajectory[ i ]
					- fitnessTrajectory[ i - 1 ] );
			if( minDifference == null || delta < minDifference )
				minDifference = delta;
		}

		final double variance = StatUtils.variance( fitnessTrajectory );
		ClosedInterval result = ClosedInterval.create(minDifference,Math.sqrt( variance ) );
		return result.isEmpty() 
			?  ClosedInterval.create(fitnessTrajectory[0],fitnessTrajectory[0] + (fitnessTrajectory.length * Double.MIN_VALUE ) ) 
			: result;
	}
}

// End ///////////////////////////////////////////////////////////////
