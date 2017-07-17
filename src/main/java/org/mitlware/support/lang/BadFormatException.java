package org.mitlware.support.lang;

public class BadFormatException extends Exception {

	private static final long serialVersionUID = 2006476152887824752L;

	public BadFormatException( String message )	{
		super( message );
	}

	public BadFormatException( String expected, String found )	{
		super( "Expected: " + expected + ", found: " + found );
	}
}

// End ///////////////////////////////////////////////////////////////
