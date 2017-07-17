package org.mitlware.support.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.mitlware.support.tuple.Tuple;
import org.mitlware.support.tuple.Tuple3;

//////////////////////////////////////////////////////////////////////

/**
 * Typed version of Observable, based on the original JDK code.
 */

public class TypedObservable<
	DerivedObservable extends TypedObservable< DerivedObservable, Update >,
	Update >
{
	private List< TypedObserver< DerivedObservable, Update >
		> observers = new ArrayList< TypedObserver< DerivedObservable, Update > >();
	private boolean changed = false;
	private Function<Tuple3< TypedObserver< DerivedObservable, Update >, DerivedObservable, Update >, Update
		> observerFilter = new Function< Tuple3< TypedObserver< DerivedObservable, Update >, DerivedObservable, Update >, Update >()
		{
			public Update apply( Tuple3< TypedObserver< DerivedObservable, Update >, DerivedObservable, Update > t )
			{
				return t.getThird();
			}
		};

	///////////////////////////////

	public TypedObservable()	{}

	public TypedObservable( Function<
			Tuple3< TypedObserver< DerivedObservable, Update >,
			DerivedObservable,
			Update>,
			Update
			> observerFilter ) {
		setObserverFilter( observerFilter );
	}

	///////////////////////////////

	public void setObserverFilter( Function< Tuple3< TypedObserver< DerivedObservable, Update >,
				DerivedObservable,
				Update>,
				Update > observerFilter ) {
		this.observerFilter = observerFilter;
	}

	///////////////////////////////

    /**
     * Tests if this object has changed.
     */
	public boolean hasChanged() { return changed; }

    /**
     * Adds an observer to the set of observers for this object,
     * provided that it is not the same as some observer already in the set.
     */
	public void addObserver( TypedObserver< DerivedObservable, Update > o ) {
    	if( !observers.contains( o ) )
            observers.add( o );
    }

    /**
     * Returns the number of observers of this Observable object.
     */
	public int countObservers() { return observers.size(); }

    /**
     * Deletes an observer from the set of observers of this object.
     */
	public void deleteObserver( TypedObserver< DerivedObservable, Update > o ) {
    	observers.remove( o );
    }

    /**
     * Clears the observer list so that this object no longer has any observers.
     */

	public void deleteObservers() {
        observers.clear();
    }

    /**
     * If this object has changed, as indicated by the hasChanged method,
     * then notify all of its observers and then call the clearChanged method
     * to indicate that this object has no longer changed.
     */
	@SuppressWarnings("unchecked")
	public void notifyObservers( Update arg ) {
        if( hasChanged() ) {
        	for( int i=0; i<observers.size(); ++i ) {
        		DerivedObservable downcastThis = ( DerivedObservable ) this;
        		Update transformedUpdate = observerFilter.apply( Tuple.cons(observers.get( i ), downcastThis, arg) );
        		if( transformedUpdate != null )
        			observers.get( i ).doUpdate( downcastThis, transformedUpdate );
            }

            clearChanged();
        }
    }

    ///////////////////////////////

    /**
     * Marks this observable object as having been changed;
     * the has_changed method will now return true.
     */

    public void setChanged() { changed = true; }

    /**
     * Indicates that this object has no longer changed,
     * or that it has already notified all of its observers of its most
     * recent change, so that the has_changed method will now return false.
     */
    void clearChanged() { changed = false; }
}

// End ///////////////////////////////////////////////////////////////
