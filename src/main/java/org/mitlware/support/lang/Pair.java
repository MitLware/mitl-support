package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public final class Pair< T1 extends Comparable< T1 >, T2 extends Comparable< T2 > >
implements Comparable< Pair< T1, T2 > > {
	private T1 first;
	private T2 second;

	///////////////////////////////

	public Pair( T1 a1, T2 a2 ) {
		first  = a1;
		second = a2;
	}

	public Pair( Pair< T1, T2 > rhs ) {
		first  = rhs.first;
		second = rhs.second;
	}

	///////////////////////////////

	public T1 getFirst()  { return first; }
	public T2 getSecond() { return second; }

	public int compareTo( Pair< T1, T2 > rhs ) {
		if( first.compareTo( rhs.first ) < 0 )
			return -1;
		else if( first.compareTo( rhs.first ) > 0 )
			return 1;
		else if( second.compareTo( second ) < 0 )
			return -1;
		else if( second.compareTo( second ) > 0 )
			return 1;

		return 0;
	}

	///////////////////////////////

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append( '(' );
		result.append( first );
		result.append( ',' );
		result.append( second );
		result.append( ')' );
		return result.toString();
	}

	public boolean equals( Pair< T1, T2 > rhs ) {
		if ( rhs == null )
			return false;

		return first.equals( rhs.first )
			&& second.equals( rhs.second );
	}

	///////////////////////////////

	public int hashCode() {
		return HashCode.apply( first, second );
    }
}

// End ///////////////////////////////////////////////////////////////
