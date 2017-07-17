package org.mitlware.support.util;

import java.util.Iterator;
import java.util.function.Function;

//////////////////////////////////////////////////////////////////////

public final class TransformIterator< T, U >
implements Iterator< U > {
	private Iterator< T > iterator;
	private Function< T, U > f;

	///////////////////////////////

	public TransformIterator( Iterator< T > iterator, Function< T, U > func ) {
		this.iterator = iterator;
		this.f = func;
	}

	public boolean hasNext() { return iterator.hasNext(); }

	public U next() { return f.apply( iterator.next() ); }

	public void remove() { iterator.remove();  }
}

// End ///////////////////////////////////////////////////////////////


