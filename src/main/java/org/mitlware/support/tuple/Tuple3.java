package org.mitlware.support.tuple;

public class Tuple3<T1, T2, T3>
extends Tuple< T1, Tuple<T2, Tuple<T3, Tuple0>>>  {
	private static final long serialVersionUID = -4787357825185957620L;

	public Tuple3(T1 m1, T2 m2, T3 m3) {
		super( m1, cons( m2, m3 ) );
	}

	///////////////////////////////

	public T1 getFirst() { return getHead(); }
	public T2 getSecond() { return getTail().getHead(); }
	public T3 getThird() { return getTail().getTail().getHead(); }

	///////////////////////////////
}

// End ///////////////////////////////////////////////////////////////
