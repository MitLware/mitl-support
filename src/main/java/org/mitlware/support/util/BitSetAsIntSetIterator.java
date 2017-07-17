package org.mitlware.support.util;

import java.util.*;

//////////////////////////////////////////////////////////////////////

public class BitSetAsIntSetIterator
implements Iterator< Integer > {

    private final BitSet bitset_;
    private int index_ = -1;

    ///////////////////////////////

    public BitSetAsIntSetIterator( BitSet bitset ) {
        bitset_ = bitset;
        index_ = bitset.nextSetBit( 0 );
    }

    public boolean hasNext() {
    	return index_ != -1;
    }

    public Integer next() {
        if( !hasNext() )
            throw new NoSuchElementException();

        int result = index_;
        index_ = bitset_.nextSetBit( ++index_ );
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

// End ///////////////////////////////////////////////////////////////


