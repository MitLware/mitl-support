package org.mitlware.support.lang;

/**
 * Workaround for the problem caused by Cloneable
 * lacking a public clone() method.
 * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4098033
 */

//////////////////////////////////////////////////////////////////////

public interface PubliclyCloneable< Derived >
extends Cloneable {
	public abstract Derived clone();
}

// End ///////////////////////////////////////////////////////////////
