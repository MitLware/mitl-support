
package org.mitlware.support.lang;

import java.lang.reflect.*;
import java.util.Arrays;

//////////////////////////////////////////////////////////////////////

public class ReflectionUtils {

	public static boolean isStatic( Method method ) {
		return Modifier.isStatic( method.getModifiers() );
	}

	public static String className( Class<?> c ) {
		String result = c.getName();
		int lastPackageIndex = result.lastIndexOf( '.' );
		if( lastPackageIndex != -1 )
			result = result.substring( lastPackageIndex + 1, result.length() );

		return result;
	}

	//////////////////////////////

	public static Constructor<?> makeConstructor( Class<?> clazz,  Class<?> [] signature ) {
		Constructor<?> result = null;
		Constructor<?> [] cons = clazz.getConstructors();

		for( int j=0; result == null && j<cons.length; ++j ) {
			if( Arrays.equals( cons[ j ].getParameterTypes(), signature ) )
				result = cons[ j ];
        }

		return result;
	}

	public static Constructor<?> [] makeConstructors( Class<?> [] classes,  Class<?> [] signature )	{
		Constructor<?> [] result = new Constructor [ classes.length ];
		for( int i=0; i<result.length; ++i )
			result[ i ] = makeConstructor( classes[ i ], signature );

		return result;
	}
}

// End ///////////////////////////////////////////////////////////////
