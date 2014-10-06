/**
 * (c) Jerry Swan, 2012.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

//////////////////////////////////////////////////////////////////////

package metaxa;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.Pair;

//////////////////////////////////////////////////////////////////////

public final class FitnessDistanceCorrelation {

	public static double apply( List< Pair< Double, Integer > > fitnessDistancePairs )
	{
		if( fitnessDistancePairs.isEmpty() )
			throw new IllegalArgumentException();

		DescriptiveStatistics fitnessStats = new DescriptiveStatistics();
		DescriptiveStatistics distanceStats = new DescriptiveStatistics();		
		for( Pair< Double, Integer > p : fitnessDistancePairs )
		{
			fitnessStats.addValue( p.getKey() );
			distanceStats.addValue( p.getValue() );			
		}
		
		final double meanFitness = fitnessStats.getMean();
		final double sdFitness = fitnessStats.getStandardDeviation(); 

		final double meanDistance = distanceStats.getMean();
		final double sdDistance = distanceStats.getStandardDeviation(); 
		
		double total = 0;
		for( int i=0; i<fitnessDistancePairs.size(); ++i )
		{
			final double f = fitnessDistancePairs.get( i ).getKey() - meanFitness;
			final double d = fitnessDistancePairs.get( i ).getValue() - meanDistance;
			total += f * d;
		}

		final double fitnessDistanceCovariance = total / fitnessDistancePairs.size();
		return fitnessDistanceCovariance/ ( sdFitness * sdDistance );
	}
}

// End ///////////////////////////////////////////////////////////////

