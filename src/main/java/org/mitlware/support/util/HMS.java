package org.mitlware.support.util;

//////////////////////////////////////////////////////////////////////

public class HMS {

	private final int 		hours_;
	private final int 		minutes_;
	private final double	seconds_;

	///////////////////////////////

	public HMS( double seconds ) {
		hours_ = (int)( seconds / 3600 );
		minutes_ = (int)( ( seconds - ( hours_ * 3600 ) ) / 60 );
		seconds_ = seconds % 60.0;
	}

	///////////////////////////////

	public String toString() {

		StringBuffer result = new StringBuffer();

		if( hours_ < 10 )
			result.append( "0" );
		result.append( hours_ );
		result.append( ':' );

		if( minutes_ < 10 )
			result.append( "0" );
		result.append( minutes_ );
		result.append( '.' );

		if( seconds_ < 10 )
			result.append( "0" );
		result.append( (int)seconds_ );

		return result.toString();
	}
}

// End ///////////////////////////////////////////////////////////////

