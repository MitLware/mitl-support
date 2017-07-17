package org.mitlware.support.tuple;

public class Tuple1<T1> extends Tuple< T1, Tuple0 > {

	private static final long serialVersionUID = -8079110782900763979L;

	public Tuple1(T1 m1) {
		super( m1, Tuple0.instance() );
	}
}

//End ///////////////////////////////////////////////////////////////
