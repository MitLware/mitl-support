package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public class GreaterNumber
implements java.util.Comparator< Number > {

	@Override
	public int compare( Number a, Number b ) {
		double d = b.doubleValue() - a.doubleValue();
		return d < 0 ? -1 : d > 0 ? 1 : 0;
	}
}

// End ///////////////////////////////////////////////////////////////
