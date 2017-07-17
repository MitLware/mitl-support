package org.mitlware.support.tuple;

public class Tuple2<T1, T2>
extends Tuple< T1, Tuple< T2, Tuple0 > > {
	private static final long serialVersionUID = -6338054402879902098L;

	public Tuple2(T1 m1, T2 m2 ) {
		super( m1, cons( m2 ) );
	}

	///////////////////////////////

	public T1 getFirst() { return getHead(); }
	public T2 getSecond() { return getTail().getHead(); }
}

// End ///////////////////////////////////////////////////////////////