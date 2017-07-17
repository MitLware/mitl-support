package org.mitlware.support.tuple;

import java.io.Serializable;
import java.util.Collection;

import org.mitlware.support.lang.Immutable;
import org.mitlware.support.lang.PubliclyCloneable;

//////////////////////////////////////////////////////////////////////

public interface AbstractTuple
extends Collection< Object >, Immutable, PubliclyCloneable< AbstractTuple >, Serializable {
	public Object get( int i )
	throws IndexOutOfBoundsException;
}

// End ///////////////////////////////////////////////////////////////
