package org.mitlware.support.lang;

public class UnsupportedFormatException extends RuntimeException {

	private static final long serialVersionUID = 2006476152887824752L;

	public UnsupportedFormatException() { super(""); }

	public UnsupportedFormatException( String message ) {
		super( message );
	}

	public UnsupportedFormatException( String expected, String found ) {
		super( "Expected: " + expected + ", found: " + found );
	}
}

// End ///////////////////////////////////////////////////////////////
