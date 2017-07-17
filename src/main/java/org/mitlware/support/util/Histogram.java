package org.mitlware.support.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mitlware.support.math.ClosedOpenInterval;
import org.mitlware.support.math.LinearInterpolation;

//////////////////////////////////////////////////////////////////////

public final class Histogram {

    private ArrayList< Bin >	bins_;
    private Bin					leftOutliers_;
    private Bin					rightOutliers_;

    ///////////////////////////////

	public static List<ClosedOpenInterval< Double >>
	equalIntervals( int numBins, ClosedOpenInterval< Double > minMax ) {
    	final double min = minMax.getLower();
    	final double max = minMax.getUpper();

        final double binWidth = ( max - min ) / numBins;
		assert binWidth > 0;

		List< ClosedOpenInterval< Double > > result = new ArrayList<ClosedOpenInterval<Double>>();
		for( int i=0; i<numBins; ++i ) {
			double lower = LinearInterpolation.apply( i, 0, numBins - 1, min, max - binWidth );
			double upper = LinearInterpolation.apply( i, 0, numBins - 1, min + binWidth, max );
            result.add( new ClosedOpenInterval< Double >( lower, upper ) );
		}

		return result;
	}

    public Histogram( int numBins, ClosedOpenInterval< Double > minMax )
    {
    	this( equalIntervals( numBins, minMax ) );
    }

    public Histogram( List< ClosedOpenInterval< Double > > bins ) {
    	final double min = bins.get( 0 ).getLower();
    	final double max = bins.get( bins.size() - 1 ).getUpper();

    	if( min != Double.MIN_VALUE )
    		leftOutliers_ = new Bin( new ClosedOpenInterval< Double >( -Double.MAX_VALUE, min ) );
    	if( max != Double.MAX_VALUE )
  	  		rightOutliers_ = new Bin( new ClosedOpenInterval< Double >( max, Double.MAX_VALUE ) );

		bins_ = new ArrayList< Bin >( bins.size() );
		for( int i=0; i<bins.size(); ++i )
			bins_.add( new Bin( bins.get( i ) ) );
    }

    ///////////////////////////////

    public void add( double x ) {
    	ClosedOpenInterval< Double > range = getRange();
    	if( range.contains( x ) )
			bins_.get( getBinIndex( x ) ).insert( x );
    	else if( leftOutliers_ != null && leftOutliers_.contains( x ) )
			leftOutliers_.insert( x );
		else if( rightOutliers_ != null && rightOutliers_.contains( x ) )
			rightOutliers_.insert( x );
		else
			throw new InternalError();
    }

    public void addAll( Iterator< Double > it ) {
        while( it.hasNext() )
			add( it.next() );
    }

    ///////////////////////////////

    public ClosedOpenInterval< Double > getRange() {
    	return new ClosedOpenInterval< Double >( bins_.get( 0 ).getLower(),
    			bins_.get( bins_.size() - 1 ).getUpper() );
    }

    public int getNumBins() { return bins_.size(); }

    public int getCount( int x ) {
        assert x >= 0 && x < getNumBins();

        return bins_.get( x ).count();
    }

    public ClosedOpenInterval< Double >
    getRange( int x ) {
        assert x >= 0 && x < getNumBins();
        return bins_.get( x ).getRange();
    }

    public double sum() {
        double result = 0;
        if( leftOutliers_ != null )
        	result += leftOutliers_.sum();
        if( rightOutliers_ != null )
        	result += rightOutliers_.sum();

        for( int i=0; i<bins_.size(); ++i )
            result += bins_.get( i ).sum();

        return result;
    }

    ///////////////////////////////

    public Bin getLeftOutliers() { return leftOutliers_; }
    public Bin getRightOutliers() { return rightOutliers_; }

    ///////////////////////////////

    public String toGnuplotString() {
    	StringBuffer s = new StringBuffer();
        s.append( "set style data histeps\n" );
        // s.append( "set xlabel \"x-label\"\n" ).append( "set ylabel \"y-label\"\n" );

        s.append( "plot \"-\"\n" );
        for( int i=0; i<getNumBins(); ++i ) {
            s.append( '\t' ).append( getRange( i ).toString() );
            s.append( '\t' ).append( getCount( i ) ).append( '\n' );
        }
        s.append( "e\n" );

        return s.toString();
    }

    ///////////////////////////////

    public int getBinIndex( double x ) {
    	for( int i=0; i<bins_.size(); ++i )
    		if( bins_.get( i ).contains( x ) )
    			return i;

    	return -1;
    }

    ///////////////////////////////

    public static class Bin {

    	private ClosedOpenInterval< Double	> range_;
    	private double	sum_;
    	private int		count_;

    	///////////////////////////

    	public Bin() {
            range_ = new ClosedOpenInterval< Double >( Double.MIN_VALUE,
            		Double.MAX_VALUE );
    	}

    	public Bin( ClosedOpenInterval< Double > x ) {
        	range_ = x;
        }

    	///////////////////////////////

    	public boolean contains( double x ) {
    		return range_.contains( x );
    	}

        public double sum() { return sum_; }

        public void insert( double x ) {
        	sum_ += x;
        	++count_;
        }

        public void insert( Iterator< Double > it ) {
        	while( it.hasNext() )
        		insert( it.next() );
        }

        public double getLower() { return range_.getLower(); }
        public double getUpper() { return range_.getUpper(); }

        public ClosedOpenInterval< Double > getRange() { return range_;}

        public String toString() {
        	StringBuffer s = new StringBuffer();
        	s.append( range_ );
        	s.append( ' ' );
        	s.append( count_ );
        	return s.toString();
        }

    	public int count() { return count_; }
    }
}

// End ///////////////////////////////////////////////////////////////
