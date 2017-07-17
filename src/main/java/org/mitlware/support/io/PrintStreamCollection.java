package org.mitlware.support.io;

import java.io.PrintStream;
import java.util.Locale;

//////////////////////////////////////////////////////////////////////

public final class PrintStreamCollection extends PrintStream {

	private PrintStream [] streams;

	///////////////////////////////

	public PrintStreamCollection( PrintStream ... streams ) {
		super( new NullOutputStream() );
		this.streams = streams;
	}

	public PrintStream append(char x) {
		for( PrintStream ps : streams )
			ps.append(x);
		return this;
	}

	public PrintStream append( CharSequence x ) {
		for( PrintStream ps : streams )
			ps.append(x);
		return this;
	}

	public PrintStream append(CharSequence x, int start, int end) {
		for( PrintStream ps : streams )
			ps.append(x, start, end );
		return this;
	}

	public boolean checkError() {
		boolean result = false;
		for( PrintStream ps : streams )
			result = result || ps.checkError();
		return result;
	}

	public void close() {
		for( PrintStream ps : streams )
			ps.close();
	}

	public void flush() {
		for( PrintStream ps : streams )
			ps.flush();
	}

	public PrintStream format(Locale x, String format, Object... args) {
		for( PrintStream ps : streams )
			ps.format(x, format, args );
		return this;
	}

	public PrintStream format(String format, Object... args) {
		for( PrintStream ps : streams )
			ps.format( format, args );
		return this;
	}

	public void print(boolean x) {
		for( PrintStream ps : streams )
			ps.print( x );
	}

	public void print(char x) {
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(char[] x)  {
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(double x)   {
		super.print( x );
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(float x)   {
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(int x)   {
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(long x)   {
		for( PrintStream ps : streams )
			ps.print( x );
	}
	public void print(Object x)   {
		for( PrintStream ps : streams )
			ps.print( x );
	}

	public void print(String x)   {
		for( PrintStream ps : streams )
			ps.print( x );
	}

	public PrintStream printf(Locale x, String format, Object... args)   {
		for( PrintStream ps : streams )
			ps.printf(x, format, args );
		return this;
	}

	public PrintStream printf(String format, Object... args)   {
		for( PrintStream ps : streams )
			ps.printf( format, args );
		return this;
	}

	public void println()   {
		for( PrintStream ps : streams )
			ps.println();
	}

	public void println(boolean x)    {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(char x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}
	public void println(char[] x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(double x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(float x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(int x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(long x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(Object x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void println(String x)   {
		for( PrintStream ps : streams )
			ps.println( x );
	}

	public void write(byte[] buf, int off, int len) {
		for( PrintStream ps : streams )
			ps.write( buf, off, len );
	}

	public void write(int x) {
		for( PrintStream ps : streams )
			ps.write( x );
	}
}

// End ///////////////////////////////////////////////////////////////
