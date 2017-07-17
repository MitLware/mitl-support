package org.mitlware.support.tuple;

public class Tuple4<T1, T2, T3, T4>
extends Tuple< T1, Tuple<T2, Tuple<T3, Tuple< T4, Tuple0 > > > > {

	private static final long serialVersionUID = 6361322708815795416L;

	///////////////////////////////

	public Tuple4( T1 m1, T2 m2, T3 m3, T4 m4 ) {
		super( m1, cons( m2, m3, m4 ) );
	}

	///////////////////////////////

	public T1 getFirst() { return getHead(); }
	public T2 getSecond() { return getTail().getHead(); }
	public T3 getThird() { return getTail().getTail().getHead(); }
	public T4 getFourth() { return getTail().getTail().getTail().getHead(); }
}

// End ///////////////////////////////////////////////////////////////
