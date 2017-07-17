package org.mitlware.support.math;

import org.mitlware.support.lang.PubliclyCloneable;

//////////////////////////////////////////////////////////////////////

public class ClosedOpenInterval< Value extends Comparable< Value > >
implements Comparable< ClosedOpenInterval< Value > >,
	PubliclyCloneable< ClosedOpenInterval< Value > > {
	private Value lower;
	private Value upper;

	///////////////////////////////

    public ClosedOpenInterval( Value lower, Value upper ) {
    	if( !isClosedOpenInterval( lower, upper ) )
    		throw new IllegalArgumentException(
    				"Valid closed-open interval expected, found [ "
    					+ lower + ", " + upper + " )" );

    	this.lower = lower;
    	this.upper = upper;
    }

    public static <V extends Comparable<V>>
    boolean isClosedOpenInterval( V lower, V upper ) {
	    return lower.compareTo( upper ) <= 0;
    }

    public boolean contains( Value x ) {
	    return getLower().compareTo( x ) <= 0 && x.compareTo( getUpper() ) < 0;
    }

    public boolean overlaps( ClosedOpenInterval< Value > other ) {
	    return contains( other.getLower() )
                || ( !other.getUpper().equals( getLower() )
                        && contains( other.getUpper() ) );
    }

    public boolean contains( ClosedOpenInterval< Value > other ) {
	    return contains( other.getLower() )
	    	&& other.getUpper().compareTo( getUpper() ) <= 0;
    }

    public Value getLower() { return lower; }
    public Value getUpper() { return upper; }

    @Override
    public int hashCode() {
    	return getLower().hashCode() ^ getUpper().hashCode();
    }

    @Override
	public boolean equals( Object o ) {
        return o instanceof ClosedOpenInterval
                && getLower() == ((ClosedOpenInterval<?>)o).getLower()
                    && getUpper() == ((ClosedOpenInterval<?>)o).getUpper();
    }

    public String toString() {
        return "[ " + getLower() + ", " + getUpper() + " )";
    }

    public int compareTo( ClosedOpenInterval< Value > rhs ) {
        if( getLower().compareTo( rhs.getLower() ) < 0 )
            return -1;
        else if( getLower().equals( rhs.getLower() ) )
        {
            if( getUpper().compareTo( rhs.getUpper() ) < 0 )
                return -1;
            else if( getUpper().equals( rhs.getUpper() ) )
                return 0;

            return 1;
        }

        return 1;
    }

    public ClosedOpenInterval< Value > clone() {
        return this;
    }
}

// End ///////////////////////////////////////////////////////////////

