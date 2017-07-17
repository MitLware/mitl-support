package org.mitlware.support.tuple;

public class Tuple6<T1, T2, T3, T4, T5, T6>
extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple<T6, Tuple0>>>>>> {

	private static final long serialVersionUID = -2198489733606813313L;

	public Tuple6(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5, T6 m6) {
		super(m1, cons(m2, m3, m4, m5, m6));
	}
}

// End ///////////////////////////////////////////////////////////////
