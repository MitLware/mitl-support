package org.mitlware.support.math;

import java.lang.Number;
import java.util.function.ToDoubleFunction;

//////////////////////////////////////////////////////////////////////

public class R1Norm< T extends Number >
implements ToDoubleFunction< T > {

	@Override
	public double applyAsDouble( T x ) {
		return Math.abs( x.doubleValue() );
	}
}

//////////////////////////////////////////////////////////////////////
