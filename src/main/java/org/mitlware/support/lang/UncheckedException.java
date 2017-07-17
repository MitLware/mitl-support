package org.mitlware.support.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

//////////////////////////////////////////////////////////////////////

public class UncheckedException extends RuntimeException {

	private static final long serialVersionUID = -7830847634333020213L;
	private final String	stackTrace;
	public Exception		originalException;

	///////////////////////////////

	public UncheckedException( Exception e ) {
	    super( e.toString() );
	    originalException = e;
	    StringWriter sw = new StringWriter();
	    e.printStackTrace( new PrintWriter(sw) );
	    stackTrace = sw.toString();
	}

	public void printStackTrace() {
		printStackTrace(System.err);
	}

	public void printStackTrace( PrintStream s ) {
		synchronized(s) {
	      s.print(getClass().getName() + ": ");
	      s.print(stackTrace);
		}
	}

	public void printStackTrace( PrintWriter s ) {
		synchronized(s) {
	      s.print(getClass().getName() + ": ");
	      s.print(stackTrace);
	    }
	}

	public void rethrow() throws Exception { throw originalException; }
}

// End ///////////////////////////////////////////////////////////////