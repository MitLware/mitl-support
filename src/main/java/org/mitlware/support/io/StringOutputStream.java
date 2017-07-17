package org.mitlware.support.io;

import java.io.IOException;

//////////////////////////////////////////////////////////////////////

public class StringOutputStream
extends java.io.OutputStream  {

	private StringBuffer buf = new StringBuffer();

	///////////////////////////////

	public StringOutputStream() {
		buf = new StringBuffer();
	}

	public StringOutputStream( StringBuffer b )	{
		buf = b;
	}

	public void write( byte[] b ) throws IOException {
		buf.append( new String( b ) );
	}

	public void write( byte[] b, int off, int len ) throws IOException {
		buf.append( new String( b, off, len ) );
	}

	public void write( int b ) throws IOException {
		byte[] bytes = new byte[1];
		bytes[0] = (byte)b;
		buf.append( new String( bytes ) );
	}

	public String toString() {
		return buf.toString();
	}
}

// End ///////////////////////////////////////////////////////////////
