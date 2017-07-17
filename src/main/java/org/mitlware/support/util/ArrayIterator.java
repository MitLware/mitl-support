package org.mitlware.support.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;

//////////////////////////////////////////////////////////////////////

public final class ArrayIterator< T >
implements ListIterator< T > {

    private T []	array_;
    private int     index_;

    ///////////////////////////////

    public ArrayIterator( T [] array ) {
        array_ = array;
    }

    public ArrayIterator( T [] array, int index ) {
    	if( index < index || index > array.length )
    		throw new IndexOutOfBoundsException();

        array_ = array;
        index_ = index;
    }

    ///////////////////////////////

	@Override
    public boolean hasNext() {
        return array_ != null && index_ < array_.length;
    }

	@Override
    public T next() {
		if( index_ == array_.length )
			throw new NoSuchElementException();

        return array_[ index_++ ];
    }

	@Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void add(T arg0) {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		return index_ > 0 && array_.length > 0;
	}

	@Override
	public int nextIndex() { return index_ + 1; }

	@Override
	public T previous() {
		if( index_ == 0 )
			throw new NoSuchElementException();

        return array_[ --index_ ];
	}

	@Override
	public int previousIndex() { return index_ - 1;	}

	@Override
	public void set(T arg0)	{
        throw new UnsupportedOperationException();
	}
}

// End ///////////////////////////////////////////////////////////////

