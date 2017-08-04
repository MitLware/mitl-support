package org.mitlware.support.lang;

import java.io.*;
import java.util.*;

//////////////////////////////////////////////////////////////////////

public class SerialCloner {

	@SuppressWarnings("unchecked")
	public static < T > T deepClone( T o ) {
		try {
			ByteArrayOutputStream bOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream( bOut );

			out.writeObject( o );

			ByteArrayInputStream bIn = new ByteArrayInputStream( bOut.toByteArray() );
			ObjectInputStream in = new ObjectInputStream( bIn );
			return (T)in.readObject();
		}
		catch( IOException e ) {
			throw new UncheckedException( e );
		}
		catch( ClassNotFoundException e ) {
			throw new UncheckedException( e );
		}
	}
/*  
public static void main( String args[] ) throws Exception { 

Vector<StringBuffer> v = new Vector<StringBuffer>();
v.addElement( new StringBuffer("Hello") );
Vector<StringBuffer> vClone = SerialCloner.deepClone( v );

// Changing the StringBuffer int the cloned vector has no
// effect on the original StringBuffer object --
// demonstrating that we have indeed done a deep copy

((StringBuffer)vClone.elementAt(0)).append(" world" );
StringBuffer sb = (StringBuffer)v.elementAt( 0 );
System.out.println( sb.toString() );
sb = (StringBuffer)vClone.elementAt(0);
System.out.println(sb.toString());
int array[] = { 1, 2, 3, 4, 5 };
int arrayClone[] = (int [])SerialCloner.deepClone( array );

// Again, changes to an element in the cloned array do not
// have any effect on the original

arrayClone[0]++;
System.out.println(array[0]);
System.out.println(arrayClone[0]);
}*/

}

//////////////////////////////////////////////////////////////////////
