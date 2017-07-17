package org.mitlware.support.tuple;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public final class Tuple0
implements AbstractTuple
{
	private static final long serialVersionUID = -7008630495917273389L;

	private static Tuple0 instance_;

	public static Tuple0 instance() {
		if( instance_ == null )
			instance_ = new Tuple0();

			return instance_;
	}

	///////////////////////////////

	public boolean add( Object o ) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public void clear()	{
		// Intentionally Empty
	}

	///////////////////////////////

	public AbstractTuple clone() { return this; }

	///////////////////////////////

	public boolean contains( Object o )	{
		return false;
	}

	public boolean containsAll( Collection< ? > c )	{
		return false;
	}

	///////////////////////////////

	public Object get( int i ) {
		throw new TupleIndexOutOfBoundsException( i, 0 );
	}

	public boolean isEmpty() { return true;	}


	public Iterator<Object> iterator() {
		return null;
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public int size() { return 0; }

	public Object [] toArray() { return new Object [ 0 ]; }

	@SuppressWarnings("unchecked")
	public Object [] toArray( Object [] a )
	{
		final int sz = size();
		Class<?> componentType = a.getClass().getComponentType();
		Object [] result = (Object [])Array.newInstance( componentType, sz );
		return result;
	}
}

// End ///////////////////////////////////////////////////////////////
