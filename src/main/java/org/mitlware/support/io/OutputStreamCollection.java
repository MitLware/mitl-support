package org.mitlware.support.io;

import java.io.IOException;
import java.io.OutputStream;

//////////////////////////////////////////////////////////////////////

public final class OutputStreamCollection extends OutputStream {

	private OutputStream [] streams;

	//////////////////////////////

	public OutputStreamCollection( OutputStream ... streams ) {
		this.streams = streams;
	}

	@Override
	public void write(int b) throws IOException {
		for( OutputStream s : streams )
			s.write( b );
	}
}

// End ///////////////////////////////////////////////////////////////

