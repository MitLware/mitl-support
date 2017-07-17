package org.mitlware.support.util;

import org.mitlware.support.lang.HashCode;

//////////////////////////////////////////////////////////////////////

public final class Quota {

	private enum Type { FIXED, PERCENTAGE };
	private final Type type;
	private final double value;

	///////////////////////////////

	public static Quota
	Fixed( double value ) {
		return new Quota( value, Type.FIXED );
	}

	public static Quota
	Percentage( double value ) {
		return new Quota( value, Type.PERCENTAGE );
	}

	///////////////////////////////

	public double of( double amount ) {
        if( type == Type.PERCENTAGE )
            return ( amount * value ) / 100.0;
        else
            return Math.min( amount, value );
    }

	///////////////////////////////

	@Override
	public int hashCode() {
		return HashCode.apply( value, type.hashCode() );
	}

	@Override
	public boolean equals( Object o ) {
		if( ! ( o instanceof Quota ) )
			return false;

		Quota rhs = (Quota)o;
		return type == rhs.type && value == rhs.value;
	}

	@Override
	public String toString() {
		String result = Double.toString( value );
        if( type == Type.PERCENTAGE )
            result += '%';
		return result;
	}

    ///////////////////////////////

	private Quota( double value, Type type ) {
		if( value < 0 || type == Type.PERCENTAGE && value > 100.0 )
			throw new IllegalArgumentException();

		this.value = value;
		this.type = type;
	}
}

// End ///////////////////////////////////////////////////////////////
