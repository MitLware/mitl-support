package org.mitlware.support.lang;

//////////////////////////////////////////////////////////////////////

public class LessNumber
implements java.util.Comparator< Number > {
	@Override
	public int compare( Number a, Number b ) {
		double d = a.doubleValue() - b.doubleValue();
		return d < 0 ? -1 : d > 0 ? 1 : 0;
	}
}

// End ///////////////////////////////////////////////////////////////
