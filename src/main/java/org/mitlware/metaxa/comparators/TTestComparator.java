package org.mitlware.metaxa.comparators;

import java.util.Comparator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.inference.TTest;

// import com.google.common.primitives.Doubles;

//////////////////////////////////////////////////////////////////////

public final class TTestComparator 
implements Comparator< double [] >
{
	private final double significanceLevel;
	private boolean isPaired;
	private TTest tTest = new TTest();		
	
	///////////////////////////////
	
	public TTestComparator( double significanceLevel, boolean isPaired )
	{
		this.significanceLevel = significanceLevel;
		this.isPaired = isPaired;
	}
	
	///////////////////////////////
	
	/**
	 * From http://commons.apache.org/math/apidocs/org/apache/commons/math3/stat/inference/TTest.html#tTest(double[], double[], double)
	 * To test the (2-sided) hypothesis sample mean = mu at the 95% level, use 
	 * tTest(mu, sample, 0.05) 
	 * To test the (one-sided) hypothesis sample mean < mu at the 99% level, 
	 * first verify that the measured sample mean is less than mu and then use 
	 * tTest(mu, sample, 0.02)
	 */
	
	@Override
	public int compare( double [] a, double [] b ) {

		// tTest returns true iff the null hypothesis that 
		// the means are equal can be rejected with 
		// confidence 1 - significanceLevel.
		
		//final boolean meansWithinConfidenceInterval = isPaired 
		//	? !tTest.pairedTTest( a, b, significanceLevel )
		//	: !tTest.tTest( a, b, significanceLevel );
		final double pValue = isPaired 
				? tTest.pairedTTest( a, b )
				: tTest.tTest( a, b );

		if( pValue > significanceLevel )	
			return 0;
		else
		{
			DescriptiveStatistics aStats = new DescriptiveStatistics( a );
			DescriptiveStatistics bStats = new DescriptiveStatistics( b );
			final int cmp = (int)Math.signum( aStats.getMean() - bStats.getMean() );
			assert( cmp > 0 );
			
			if( cmp < 0 )
			{
				if( pValue <= 2 * significanceLevel )
					return -1;
				else
					return 1;
			}
			else 
			{
				if( pValue < 2 * significanceLevel )
					return 1;
				else
					return -1;
			}
		}
	}
	
	public static void main( String [] args )
	{
		final double significanceLevel = 0.05;
		final boolean isPaired = false;
		
		Comparator< double [] > cmp = new TTestComparator( 
			significanceLevel, isPaired );	
	
		double [] a = new double [] { 30.02, 29.99, 30.11, 29.97, 30.01, 29.99 };
		double [] b = new double [] { 29.89, 29.93, 29.72, 29.98, 30.02, 29.98 }; 
		System.out.println( cmp.compare( a, b ) );
	}
}

// End ///////////////////////////////////////////////////////////////

