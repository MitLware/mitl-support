package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public class MutableDouble {
	private double value_;

	///////////////////////////////

	public MutableDouble( double value ) {
		value_ = value;
	}

	public MutableDouble( String s )
	throws NumberFormatException {
		value_ = Double.parseDouble( s );
	}

	public void set( double value ) { value_ = value; }

	public byte byteValue() { return (byte)value_; }
	public double doubleValue()	{ return (double)value_; }
	public float floatValue() { return (float)value_; }
	public int intValue() {	return (int)value_; 	}
	public long longValue() { return (long)value_; };
	public short shortValue() {	return (short)value_; }

	public boolean equals( Object obj ) {
		if( ( obj != null ) && ( obj instanceof MutableDouble ) )
			return value_ == ((MutableDouble)obj).doubleValue();

		return false;
	}

	public int hashCode() { return hashCode( value_ ); }	

	public static int hashCode( double x ) {
		long bits = Double.doubleToLongBits( x );
		return (int)(bits ^ (bits >> 32));
	}	

	public String toString() {
		return String.valueOf( value_ );
	}
}

// End ///////////////////////////////////////////////////////////////

