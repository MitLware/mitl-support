package org.mitlware.support.util;

//////////////////////////////////////////////////////////////////////

/**
 * Typed version of Observer, based on the original JDK code.
 */

public interface TypedObserver<
	DerivedObservable extends TypedObservable< DerivedObservable, Update >
	, Update > {

	public abstract void doUpdate( DerivedObservable o, Update arg );
}

// End ///////////////////////////////////////////////////////////////
