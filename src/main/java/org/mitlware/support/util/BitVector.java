package org.mitlware.support.util;

import java.util.Arrays;
import java.util.Random;

import org.mitlware.support.lang.PubliclyCloneable;

//////////////////////////////////////////////////////////////////////

public class BitVector
implements PubliclyCloneable< BitVector > {

	private final static int LOG2_BITS_PER_UNIT = 6;
	private final static int BITS_PER_UNIT = 1 << LOG2_BITS_PER_UNIT; // 2^6=64
	private final static int BIT_INDEX_MASK = BITS_PER_UNIT - 1;

	private static final long [] masks = mostSignificantUnitMasks();

	///////////////////////////////

	private static long [] mostSignificantUnitMasks()
	{
		long [] masks = new long[ BITS_PER_UNIT + 1 ];
		long value = ~0L;
		masks[ 0 ] = -1L;
		for( int i=BITS_PER_UNIT + 1; --i >= 1; )
			masks[ i ] = value >>> ( BITS_PER_UNIT - i );

		return masks;
	};

	///////////////////////////////


	protected long		bits [];
	protected int		numBits;

	///////////////////////////////

	public BitVector( int size ) {
		if( size < 0 )
			throw new IllegalArgumentException();

		this.bits = new long [ numUnitsRequired( size ) ];
		this.numBits = size;

		assert invariant();
	}

	public BitVector( long [] data, int size ) {
		if( size < 0 || size > data.length * BITS_PER_UNIT )
			throw new IllegalArgumentException();

		this.numBits = size;
		this.bits = Arrays.copyOf( data, numUnitsRequired( size ) );
		bits[ bits.length - 1 ] &= masks[ size & BIT_INDEX_MASK ];

		assert invariant();
	}

	public BitVector( String str ) {
		this.numBits = str.length();
		this.bits = new long [ numUnitsRequired( str.length() ) ];
		for( int i=0; i<str.length(); ++i ) {
			char ch = str.charAt( i );
			if( ch == '1' ) {
				bits[ i >> LOG2_BITS_PER_UNIT ] |= 1L << ( i & BIT_INDEX_MASK );
			}
			else if( ch != '0' ) {
				throw new IllegalArgumentException();
			}
		}

		assert this.toString().equals( str );
	}

	public BitVector( BitVector rhs ) {
		this.numBits = rhs.numBits;
		this.bits = Arrays.copyOf( rhs.bits, rhs.bits.length );

		assert this.equals( rhs );
		assert invariant();
	}

	public BitVector( int size, Random random )	{
		if( size < 0 )
			throw new IllegalArgumentException();

		this.numBits = size;
		this.bits = new long [ ( size / BITS_PER_UNIT ) + ( ( size % BITS_PER_UNIT == 0 ) ? 0 : 1 ) ];
		for( int i=0; i<bits.length; ++i )
			this.bits[ i ] = random.nextLong();

		this.bits[ this.bits.length - 1 ] &= masks[ size & BIT_INDEX_MASK ];

		assert invariant();
	}

	///////////////////////////////

	public void and( BitVector rhs ) {
		if( numBits > rhs.numBits )
			throw new IllegalArgumentException();

		if( this == rhs )
			return;

		for( int i=0; i<bits.length; ++i )
			bits[ i ] &= rhs.bits[ i ];

		bits[ bits.length - 1 ] &= masks[ numBits & BIT_INDEX_MASK ];

		assert invariant();
	}

	public void andNot( BitVector rhs )	{
		if( numBits > rhs.numBits )
			throw new IllegalArgumentException();

		if( this == rhs )
			return;

		for( int i=0; i<bits.length; ++i )
			bits[ i ] &= ~rhs.bits[ i ];

		bits[ bits.length - 1 ] &= masks[ numBits & BIT_INDEX_MASK ];

		assert invariant();
	}

	public int cardinality() {
		int result = 0;
		for( int i=0; i<bits.length; ++i )
			result += Long.bitCount( bits[ i ] );

		return result;
	}

	public void clear() {
		Arrays.fill( bits, 0 );
		assert invariant();
	}

	public void clear( int bitIndex ) {
		if( bitIndex < 0 || bitIndex >= numBits )
			throw new IndexOutOfBoundsException( String.valueOf( bitIndex ) );

		bits[ bitIndex >> LOG2_BITS_PER_UNIT ] &= ~( 1L << ( bitIndex & BIT_INDEX_MASK ) );

		assert invariant();
	}

	public BitVector clone() {
		return new BitVector( this );
	}

	public boolean equals( Object obj )	{
		if( obj == null || !( obj instanceof BitVector ) )
			return false;

		if( this == obj )
			return true;

		BitVector other = (BitVector)obj;
		return size() == other.size() && Arrays.equals( bits, other.bits );
	}

	public void flip( int bitIndex ) {
		if( bitIndex<0 || bitIndex >= numBits )
			throw new IndexOutOfBoundsException( String.valueOf( bitIndex ) );

		bits[ bitIndex >> LOG2_BITS_PER_UNIT ] ^= 1L << ( bitIndex & BIT_INDEX_MASK );
	}

	public boolean get( int bitIndex ) {
		if( bitIndex<0 || bitIndex >= numBits )
			throw new IndexOutOfBoundsException( String.valueOf( bitIndex ) );

		return ( bits[ bitIndex >> LOG2_BITS_PER_UNIT ]
		    			& ( 1L << ( bitIndex & BIT_INDEX_MASK ) ) ) != 0;
	}

	public int hashCode() {
		return Arrays.hashCode( bits );
	}

	public void not() {
		for( int i=0; i<bits.length; ++i )
			bits[ i ] = ~bits[ i ];

		bits[ bits.length - 1 ] &= masks[ numBits & BIT_INDEX_MASK ];

		assert invariant();
	}

	public void or( BitVector rhs )	{
		if( numBits > rhs.numBits )
			throw new IllegalArgumentException();

		if( this == rhs )
			return;

		for( int i=0; i<bits.length; ++i )
			bits[ i ] |= rhs.bits[ i ];

		bits[ bits.length - 1 ] &= masks[ numBits & BIT_INDEX_MASK ];

		assert invariant();
	}

	public void set( int bitIndex )	{
		if( bitIndex<0 || bitIndex >= numBits )
			throw new IndexOutOfBoundsException( String.valueOf( bitIndex ) );

		bits[ bitIndex >> LOG2_BITS_PER_UNIT ] |= 1L << ( bitIndex & BIT_INDEX_MASK );

		assert invariant();
	}

	public void set( int bitIndex, boolean value ) {
		if( bitIndex<0 || bitIndex >= numBits )
			throw new IndexOutOfBoundsException( String.valueOf( bitIndex ) );

		if( value )
			bits[ bitIndex >> LOG2_BITS_PER_UNIT] |= 1L << ( bitIndex & BIT_INDEX_MASK );
		else
			bits[ bitIndex >> LOG2_BITS_PER_UNIT ] &= ~(1L << ( bitIndex & BIT_INDEX_MASK ) );

		assert invariant();
	}

	public int size() { return numBits; }

	public String toString() {
		StringBuffer result = new StringBuffer( size() );
		for( int i=0; i<size(); ++i )
			result.append( get( i ) ? "1" : "0" );

		return result.toString();
	}

	public void xor( BitVector rhs ) {
		if( numBits > rhs.numBits )
			throw new IllegalArgumentException();

		for( int i=0; i<bits.length; ++i )
			bits[ i ] ^= rhs.bits[ i ];

		bits[ bits.length - 1 ] &= masks[ numBits & BIT_INDEX_MASK ];

		assert invariant();
	}

	///////////////////////////////

	/**
	 * True iff there all bits higher then the most
	 * significant are zero
	 */
	private boolean isMostSignificantUnitNormalized() {
		return ( numBits & BIT_INDEX_MASK ) == 0 ||
			( ( bits[ bits.length - 1 ]
			          & ~masks[ numBits & BIT_INDEX_MASK ] ) == 0 );
	}

	public boolean invariant() {
		return bits != null
			&& numBits >= 0
			&& bits.length == numUnitsRequired( numBits )
			&& isMostSignificantUnitNormalized();
	}

	///////////////////////////////

	private static int numUnitsRequired( int numBits ) {
		return ( numBits >> LOG2_BITS_PER_UNIT )
			+ ( ( numBits & BIT_INDEX_MASK ) == 0 ? 0 : 1 );
	}

	///////////////////////////////

	public static void main( String [] args ) {
		BitVector v = new BitVector( 10, new Random() );
		for( int i=0; i<v.size(); ++i ) {
			System.out.print( "before:" + v );
			v.flip( i );
			System.out.println( ", after:" + v );
		}
	}
}

// End ///////////////////////////////////////////////////////////////
