package org.mitlware.support.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//////////////////////////////////////////////////////////////////////

public final class MitlCollections {

	public static < T > boolean isSet( List< T > c ) {
		for( int i=0; i<c.size(); ++i )
			for( int j=i+1; j<c.size(); ++j )
				if( c.get( i ).equals( c.get( j ) ) )
					return false;

		return true;
	}

	public static < T extends Comparable< T > >
	boolean isSorted( Collection< T > c ) {
		boolean ascending = true;
		return isSorted( c, ascending );
	}

	public static < T extends Comparable< T > >
	boolean isSorted( final Collection< T > c, boolean ascending ) {
		Iterator< T > i = c.iterator();
		if( !i.hasNext() )
			return false;

		T prev = i.next();
		while( i.hasNext() ) {
			T current = i.next();

			int cmp = prev.compareTo(current);
			if( ( ascending && cmp > 0 ) || ( !ascending && cmp < 0 ) )
					return false;

			prev = current;
		}

		return true;
	}

	public static < T > int HammingDistance( List< T > a, List< T > b ) {

		final int minSize = Math.min( a.size(), b.size() );
		final int maxSize = Math.max( a.size(), b.size() );

		int result = maxSize - minSize;

		for( int i=0; i<minSize; ++i )
			if( a.get( i ) != b.get( i ) )
				++result;

		return result;
	}

	///////////////////////////////

	public static < T extends Comparable< T > > boolean isSorted( List< T > l ) {
		for( int i=1; i<l.size(); ++i )
			if( l.get( i - 1 ).compareTo( l.get( i ) ) > 0 )
				return false;
		return true;
	}

	public static < T > boolean isSorted( List< T > l, Comparator< T > cmp ) {
		for( int i=1; i<l.size(); ++i )
			if( cmp.compare( l.get( i - 1 ), l.get( i ) ) > 0 )
				return false;
		return true;
	}

	///////////////////////////////

	public static < T > String toString( Collection< T > c ) {
		return toString( c, "," );
	}

	public static < T > String toString( Collection< T > c, String separator ) {
		final int size = c.size();
		StringBuffer s = new StringBuffer();
		Iterator< T > it = c.iterator();
		for( int i=0; i<size; ++i ) {
			s.append( it.next().toString() );
			if( i < c.size() - 1 )
				s.append( separator );
		}

		return s.toString();
	}

	///////////////////////////////

	public static int [] toPrimitiveArray( List< Integer > c ) {
		int [] result = new int [ c.size() ];
		for( int i=0; i<c.size(); ++i )
			result[ i ] = c.get( i );

		return result;
	}

	///////////////////////////////

	private MitlCollections() {}
}

// End ///////////////////////////////////////////////////////////////

