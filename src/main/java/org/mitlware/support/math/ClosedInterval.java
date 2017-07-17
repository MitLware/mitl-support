
package org.mitlware.support.math;

import org.mitlware.support.lang.HashCode;

public final class ClosedInterval implements Comparable< ClosedInterval > {

	private final double lower, upper;

	///////////////////////////////

	public ClosedInterval() {
		this.lower = Double.NEGATIVE_INFINITY;
		this.upper = Double.POSITIVE_INFINITY;
		assert( isFull() );
		assert( invariant() );
	}

	public ClosedInterval( ClosedInterval other ) {
		this.lower = other.lower;
		this.upper = other.upper;
		assert( invariant() );
	}

	public static ClosedInterval create( double lower, double upper ) {
		if( lower >= upper )
			return empty();
		else
			return new ClosedInterval( lower, upper );
	}

	public static ClosedInterval full() {
		return new ClosedInterval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	public static ClosedInterval empty() {
		ClosedInterval result = new ClosedInterval(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		assert( result.isEmpty() );
		return result;
	}

	public static ClosedInterval
	union(ClosedInterval a, ClosedInterval b ) {
		return ClosedInterval.create( Math.min(a.lower,b.lower), Math.max(a.upper,b.upper) );
	}

	public static ClosedInterval
	intersection(ClosedInterval a, ClosedInterval b ) {
		return ClosedInterval.create( Math.max(a.lower,b.lower), Math.min(a.upper,b.upper) );
	}

	///////////////////////////////

	private ClosedInterval(double lo, double hi) {
		this.lower = lo;
		this.upper = hi;

		assert( invariant() );
	}

	///////////////////////////////

	public boolean isEmpty() { return lower == Double.POSITIVE_INFINITY && upper == Double.NEGATIVE_INFINITY; }
	public boolean isFull() { return lower == Double.NEGATIVE_INFINITY && upper == Double.POSITIVE_INFINITY; }

	public double getLower() { return lower; }
	public double getUpper() { return upper; }

    public boolean contains( double x ) {
	    return lower <= x && x <= upper;
    }

    public boolean overlaps( ClosedInterval other ) {
	    return contains( other.getLower() ) || contains( other.getUpper() );
    }

    public boolean contains( ClosedInterval other ) {
	    return contains( other.getLower() ) && contains( other.getUpper() );
    }

    public double getLength() { return isEmpty() ? 0.0 : upper - lower; }

	///////////////////////////////

	@Override
	public ClosedInterval clone() {
		return new ClosedInterval(lower,upper);
	}

	@Override
	public int hashCode() { return HashCode.apply(lower, upper); }

	@Override
	public boolean equals(Object other) {

	  if( ! ( other instanceof ClosedInterval ) )
		  return false;

	  ClosedInterval rhs = (ClosedInterval)other;
	  return lower == rhs.lower && upper == rhs.upper;
	}

	@Override
	public String toString() {
		return "[" + lower + "," + upper + "]";
	}

	@Override
    public int compareTo( ClosedInterval rhs )
    {
        if( getLower() < rhs.getLower() )
            return -1;
        else if( getLower() == rhs.getLower() ) {
            if( getUpper() < rhs.getUpper() )
                return -1;
            else if( getUpper() == rhs.getUpper() )
                return 0;
            else
            	return 1;
        }
        else
        	return 1;
    }

	///////////////////////////////

	public boolean invariant() {
		return isEmpty() || lower <= upper;
	}
}

// End ///////////////////////////////////////////////////////////////
