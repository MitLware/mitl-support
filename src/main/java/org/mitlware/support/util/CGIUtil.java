package org.mitlware.support.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/////////////////////////////////////////////////////////////////////

public class CGIUtil
{
    public static String toCGIString( Map< String, String > kvp ) {
        StringBuffer result = new StringBuffer();

        Iterator<Entry<String, String>> i = kvp.entrySet().iterator();
        while( i.hasNext() ) {
            Entry<String, String> entry = i.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            result.append( key );
            result.append( '=' );
            result.append( value );
            if( i.hasNext() )
                result.append( '&' );
        }

        return result.toString();
    }

    ///////////////////////////////

    private CGIUtil() {}
}

// End ///////////////////////////////////////////////////////////////

