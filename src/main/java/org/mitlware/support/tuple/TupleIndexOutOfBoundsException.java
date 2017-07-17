package org.mitlware.support.tuple;

public class TupleIndexOutOfBoundsException
extends IndexOutOfBoundsException {

	private static final long serialVersionUID = -3420163966147190493L;

	public TupleIndexOutOfBoundsException( int index, int size ) {
		super( "expected index in range [0," + size + ") , found " + index );
	}
}

// End ///////////////////////////////////////////////////////////////

