package org.mitlware.support.math;

public class DivisionByZeroException
extends ArithmeticException {
	private static final long serialVersionUID = 2572665077624428414L;

	public DivisionByZeroException() {
		super( "Attempted division by zero" );
	}
}

// End ///////////////////////////////////////////////////////////////

