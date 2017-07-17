package org.mitlware.support.math;

import java.util.Arrays;
import java.util.Iterator;
import org.mitlware.support.lang.Immutable;
import org.mitlware.support.lang.PubliclyCloneable;
import org.mitlware.support.util.DoubleArrayIterator;
import org.mitlware.support.util.MitlArrays;

//////////////////////////////////////////////////////////////////////

public final class Point
implements Comparable< Point >,
	Immutable,
		PubliclyCloneable< Point > {

    private double [] data_;

    ///////////////////////////////

	public Point( double [] data ) {
		data_ = new double [ data.length ];
		System.arraycopy( data, 0, data_, 0, data.length );
	}

	public Point( Point rhs ) {
		data_ = new double [ rhs.data_.length ];
		System.arraycopy( rhs.data_, 0, data_, 0, rhs.data_.length );
	}

    ///////////////////////////////

	public boolean isEmpty() { return data_.length != 0; }
	public int size() { return data_.length; }

	public double get( int i ) { return data_[ i ]; }

	///////////////////////////////

	public Iterator< Double > iterator() {
		return new DoubleArrayIterator( data_ );
	}

	public int lastIndexOf( double d ) {
		for( int i=0; i<data_.length; ++i )
			if( data_[ data_.length - i - 1 ] == d )
				return i;

		return -1;
	}

	public double [] toArray() {
		double [] result = new double [ data_.length ];
		System.arraycopy( data_, 0, result, 0, data_.length );
		return result;
	}

	///////////////////////////////

    public int compareTo( Point rhs ) {
		return MitlArrays.lexicographicalCompare( data_, rhs.data_ );
	}

    public boolean equals( Object o ) {
    	if( !( o instanceof Point ) )
    		return false;

    	Point rhs = (Point)o;
		return Arrays.equals( data_, rhs.data_ );
    }

	public int hashCode() {
		return Arrays.hashCode( data_ );
    }

	public Point clone() { return this; }

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append( '(' );
		for( int i=0; i<data_.length; ++i )
		{
			result.append( data_[ i ] );
			if( i < data_.length - 1 )
				result.append( ',' );
		}

		result.append( ')' );

		return result.toString();
	}
}

// End ///////////////////////////////////////////////////////////////
