package org.mitlware.support.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//////////////////////////////////////////////////////////////////////

public final class IOUtils {

	public static String
	inputStreamToString( InputStream in ) throws IOException {
		return inputStreamReaderToString( new InputStreamReader( in ) );
	}

	///////////////////////////////

	public static String
	inputStreamReaderToString( InputStreamReader ir ) throws IOException 	{
		StringBuilder out = new StringBuilder();
		BufferedReader br = new BufferedReader( ir );

		try {
			for(String line = br.readLine();
					line != null; line = br.readLine() )
				out.append(line);
		}
		finally {
			br.close();
		}

		return out.toString();
	}
}

// End ///////////////////////////////////////////////////////////////

