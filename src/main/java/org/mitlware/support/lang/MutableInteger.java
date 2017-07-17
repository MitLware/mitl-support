package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public class MutableInteger {
	private int value_;

	///////////////////////////////

	public MutableInteger( int value ) {
		value_ = value;
	}

	public MutableInteger( String s ) throws NumberFormatException {
		value_ = Integer.parseInt( s, 10 );
	}

	public void set( int value ) { value_ = value; }

	public byte byteValue() { return (byte)value_; }
	public double doubleValue()	{ return (double)value_; }
	public float floatValue() { return (float)value_; }
	public int intValue() {	return value_; 	}
	public long longValue() { return (long)value_; };
	public short shortValue() {	return (short)value_; }

	public boolean equals( Object obj ) {
		if( ( obj != null ) && ( obj instanceof MutableInteger ) )
			return value_ == ((MutableInteger)obj).intValue();

		return false;
	}

	public int hashCode() {	return value_; }

	public String toString() { return String.valueOf( value_ );	}
}

// End ///////////////////////////////////////////////////////////////

