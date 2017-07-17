package org.mitlware.support.util;

import java.util.*;

//////////////////////////////////////////////////////////////////////

public class BitSetIterator
implements Iterator< Boolean > {

    private final BitSet bitset_;
    private int index_;

    ///////////////////////////////

    public BitSetIterator( BitSet bitset ) {
        bitset_ = bitset;
    }

    public boolean hasNext() {
        return index_ < bitset_.length();
    }

    public Boolean next() {
        if( !hasNext() )
            throw new NoSuchElementException();

        return bitset_.get( index_++ );
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

// End ///////////////////////////////////////////////////////////////


