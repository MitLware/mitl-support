package org.mitlware.support.tuple;

import java.lang.reflect.Array;

import java.util.Collection;
import java.util.Iterator;

import org.mitlware.support.lang.ReflectionUtils;

//////////////////////////////////////////////////////////////////////

public class Tuple< Head, Tail extends AbstractTuple >
implements AbstractTuple, Comparable< Tuple< Head, Tail > > {

	private static final long serialVersionUID = 4929141476723026357L;

	private Head head;
	private Tail tail;

	///////////////////////////////

	public static <T1>
    Tuple1< T1 >
	cons( T1 m1 ) {
    	return new Tuple1< T1 >( m1 );
    }

	public static <T1, T2>
	Tuple2<T1, T2>
	cons(T1 m1, T2 m2) {
		return new Tuple2<T1, T2>(m1, m2);
	}

	public static <T1, T2, T3>
	Tuple3<T1, T2, T3>
	cons( T1 m1, T2 m2, T3 m3 ) {
		return new Tuple3<T1, T2, T3>(m1, m2, m3);
	}

	public static <T1, T2, T3, T4>
	Tuple4<T1, T2, T3, T4>
	cons( T1 m1, T2 m2, T3 m3, T4 m4 ) {
		return new Tuple4<T1, T2, T3, T4>(m1, m2, m3, m4);
	}

	public static <T1, T2, T3, T4, T5>
	Tuple5<T1, T2, T3, T4, T5>
	cons( T1 m1, T2 m2, T3 m3, T4 m4, T5 m5) {
		return new Tuple5<T1, T2, T3, T4, T5>(m1, m2, m3, m4, m5);
	}

	public static <T1, T2, T3, T4, T5, T6>
	Tuple6<T1, T2, T3, T4, T5, T6>
	cons(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6) {
		return new Tuple6<T1, T2, T3, T4, T5, T6>(m1, m2, m3, m4, m5, m6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7>
	Tuple7<T1, T2, T3, T4, T5, T6, T7>
	cons(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6, T7 m7) {
		return new Tuple7<T1, T2, T3, T4, T5, T6, T7>(m1, m2, m3, m4, m5, m6, m7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8>
	Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>
	cons(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6, T7 m7, T8 m8) {
		return new Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(m1, m2, m3, m4, m5, m6, m7, m8);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9>
	Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
	cons( T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6, T7 m7, T8 m8, T9 m9 ) {
		return new Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(m1, m2, m3, m4, m5, m6, m7, m8, m9);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
	Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
	cons(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6, T7 m7, T8 m8, T9 m9, T10 m10) {
		return new Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10);
	}

	public static < T1, T2, T3 extends AbstractTuple >
	Tuple< T1, Tuple< T2, T3 > >
	cons( T1 x, Tuple< T2, T3 > t )	{
		return new Tuple< T1, Tuple< T2, T3 > >( x, t );
	}

	///////////////////////////////

	public Head getHead() { return head; }
	public Tail getTail() { return tail; }

	///////////////////////////////

	public boolean add( Object o ) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll( Collection< ? > c ) {
		throw new UnsupportedOperationException();
	}

	public void clear()	{
		throw new UnsupportedOperationException();
	}

	///////////////////////////////

	public Tuple< Head, Tail >	clone()	{
		return this;
	}

	///////////////////////////////

	public boolean contains( Object o ) {
		return head.equals( o ) || tail.contains( o );
	}

	public boolean containsAll( Collection< ? > c )
	{
		for( Object e : c )
			if( !contains( e ) )
				return false;

		return true;
	}

	///////////////////////////////

	public boolean equals( Object obj ) {
        if( !( obj instanceof Tuple ) )
            return false;

        Tuple<?,?> that = (Tuple<?,?>)obj;
        return ( head == null ? that.head == null : head.equals(that.head)) &&
        	tail.equals(that.tail);
    }

    @Override
    public int hashCode() {
    	return ( head == null ? 0 : head.hashCode() )
    		+ tail.hashCode() * 37;
    }

    ///////////////////////////////

    public Object get( int i ) {
    	final int sz = size();
    	if( i < 0 || i >= sz )
    		throw new TupleIndexOutOfBoundsException( i, sz );

    	if( i == 0 )
    		return head;
    	else
    		return tail.get( i - 1 );
    }

	///////////////////////////////

    private static class TupleIterator
    implements Iterator< Object > {
    	private int index_ = 0;
    	private AbstractTuple tuple_;

    	///////////////////////////

    	public TupleIterator( AbstractTuple tuple ) {
    		tuple_ = tuple;
    	}

    	public boolean hasNext() { return index_ > tuple_.size(); }
    	public Object next() { return tuple_.get( index_++ ); }

    	public void remove() { throw new UnsupportedOperationException(); }
    }

	///////////////////////////////

	public boolean isEmpty() { return false; }

	public Iterator< Object > iterator() {
		return new TupleIterator( this );
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll( Collection< ? > c) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll( Collection< ? > c) {
		throw new UnsupportedOperationException();
	}

	public int size() { return 1 + tail.size(); }

	///////////////////////////////

	public Object [] toArray() {
		Object [] result = new Object [ size() ];
		final int sz = size();

		for( int i=0; i<sz; ++i )
			result[ i ] = get( i );

		return result;
	}

	@SuppressWarnings("unchecked")
	public Object [] toArray( Object [] a )	{
		final int sz = size();
		Class<?> componentType = a.getClass().getComponentType();
		Object [] result = (Object [])Array.newInstance( componentType, sz );
		for( int i=0; i<sz; ++i )
			result[ i ] = get( i );

		return result;
	}

    ///////////////////////////////

	public String toString() {
		final int sz = size();
		StringBuffer buffer = new StringBuffer();
		buffer.append( ReflectionUtils.className( getClass() ) );
		buffer.append( '(' );
		for( int i=0; i<sz; ++i ) {
				buffer.append( get( i ) );
				if( i < sz - 1 )
					buffer.append( ',' );
		}

		buffer.append( ')' );
	    return new String( buffer );
	}

	// Order by the most significant element head.
    // The tuples must agree in size and type.
	@SuppressWarnings("unchecked")
	public int compareTo( Tuple<Head, Tail> that ) {
        final int compare = ((Comparable<Head>)this.head).compareTo( that.head );
        if( compare != 0 )
        	return compare;
        else
        	return ((Comparable<Tail>)this.tail).compareTo( that.tail );
    }

    ///////////////////////////////

	protected Tuple( Head hd, Tail tl )	{
		assert tl != null;

		head = hd;
		tail = tl;
	}

	protected Tuple( Tuple< Head, Tail > rhs ) {
		head = rhs.head;
		tail = rhs.tail;
	}
}

// End ///////////////////////////////////////////////////////////////

