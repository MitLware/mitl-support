package org.mitlware.support.util;

import java.util.Iterator;

//////////////////////////////////////////////////////////////////////

public final class DoubleArrayIterator
implements Iterator< Double >
{
    private double []	array_;
    private int     	index_;

    ///////////////////////////////

    public DoubleArrayIterator( double [] array )
    {
        array_ = array;
    }

    public boolean hasNext()
    {
        return array_ != null && index_ < array_.length;
    }

    public Double next()
    {
        return array_[ index_++ ];
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

//////////////////////////////////////////////////////////////////////

/* End **************************************************************/