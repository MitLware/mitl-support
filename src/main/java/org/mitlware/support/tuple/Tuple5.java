package org.mitlware.support.tuple;

public class Tuple5<T1, T2, T3, T4, T5>
extends Tuple<T1, Tuple<T2, Tuple<T3, Tuple<T4, Tuple<T5, Tuple0>>>>> {

	private static final long serialVersionUID = 493916819196611631L;

	public Tuple5(T1 m1, T2 m2, T3 m3, T4 m4, T5 m5) {
		super(m1, Tuple.cons(m2, m3, m4, m5));
	}

	///////////////////////////////

	public T1 getFirst() { return getHead(); }
	public T2 getSecond() { return getTail().getHead(); }
	public T3 getThird() { return getTail().getTail().getHead(); }
	public T4 getFourth() { return getTail().getTail().getTail().getHead(); }
	public T5 getFifth() { return getTail().getTail().getTail().getTail().getHead(); }
}

// End ///////////////////////////////////////////////////////////////
