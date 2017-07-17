package org.mitlware.support.math;

import org.mitlware.support.lang.HashCode;

//////////////////////////////////////////////////////////////////////

public final class UnitInterval
implements Comparable< UnitInterval > {

	private final double value;

	///////////////////////////////

	public UnitInterval( double value ) {
		if( !inUnitInterval( value ) )
			throw new IllegalArgumentException( "expected value in [0,1], found " + value );

		this.value = value;

		assert invariant();
	}

	///////////////////////////////

	public double getValue() { return value; }

	@Override
	public int compareTo( UnitInterval x ) {
		return value < x.value ? -1 : value > x.value ? 1 : 0;
	}

	///////////////////////////////

	public boolean equals( Object o ) {
		if( !( o instanceof UnitInterval ) )
			return false;

		UnitInterval rhs = (UnitInterval)o;
		return value == rhs.value;
	}

	public int hashCode() {
		return HashCode.apply( value );
	}

	///////////////////////////////

	public static boolean inUnitInterval( double x ) {
		return x >= 0.0 && x <= 1.0;
	}

	public boolean invariant() { return inUnitInterval( value ); }
}

// End ///////////////////////////////////////////////////////////////

