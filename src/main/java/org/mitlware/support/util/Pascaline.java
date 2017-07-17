package org.mitlware.support.util;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;

import org.mitlware.support.math.ClosedOpenInterval;

//////////////////////////////////////////////////////////////////////

public final class Pascaline {
	private int []	sequence;
	private boolean	isFinished;
	private IntFunction<ClosedOpenInterval< Integer >> boundsFn;

    ///////////////////////////////

    public final static class ConstantBoundsFn
    implements IntFunction< ClosedOpenInterval< Integer > > {

    	private ClosedOpenInterval< Integer > bounds;

    	///////////////////////////

    	public ConstantBoundsFn( int lower, int upper ) {
    		bounds = new ClosedOpenInterval< Integer >( lower, upper );
    	}

    	@Override
    	public ClosedOpenInterval< Integer > apply( int index ) {
			return bounds;
		}
	}

	///////////////////////////////

	public Pascaline( int size, int lower, int upper ) {
		sequence = new int [ size ];
		boundsFn = new ConstantBoundsFn( lower, upper );
        restart();
	}

	public Pascaline( int size, IntFunction< ClosedOpenInterval< Integer > > boundsFn )	{
		sequence = new int [ size ];
		this.boundsFn = boundsFn;
        restart();
	}

    ///////////////////////////////

	public int size() { return sequence.length; }

	public int get( int index )	{ return sequence[ index ];	}

	public ClosedOpenInterval< Integer > getBounds( int index )	{
		return boundsFn.apply( index );
	}

	public boolean hasNext() { return !isFinished; }

    ///////////////////////////////

	public void restart() {
		for( int i=0; i<sequence.length; ++i )
			sequence[ i ] = boundsFn.apply( i ).getLower();

		isFinished = checkFinished();
	}

    ///////////////////////////////

	public void next() {
		if( !hasNext() )
			throw new NoSuchElementException();

		boolean carry = true;
		for( int i=0; carry && i<sequence.length; ++i ) {
            ClosedOpenInterval< Integer > bounds = boundsFn.apply( i );
			carry = ++sequence[ i ] == bounds.getUpper();
			if( carry )
				sequence[ i ] = bounds.getLower();
		}

		isFinished = carry;
	}

	private	boolean checkFinished() {
        for( int i=0; i<sequence.length; ++i )
            if( sequence[ i ] != boundsFn.apply( i ).getUpper() )
                return false;

        return true;
    }
}

// End ///////////////////////////////////////////////////////////////

