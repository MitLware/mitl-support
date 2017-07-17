package org.mitlware.support.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

//////////////////////////////////////////////////////////////////////

public final class FunctionPoint< Input, Output >
{
	private Input	input;
	private Output	output;

	//////////////////

	public static < I, O > FunctionPoint< I, O > create( I input, O output ) {
		return new FunctionPoint< I, O >( input, output );
	}

	public FunctionPoint( Input input, Output output )
	{
		this.input = input;
		this.output	= output;
	}

	//////////////////

	public Input getInput() { return input; }
	public Output getOutput() { return output; }

	//////////////////

	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode( this );
	}

	public boolean equals( Object o )
	{
		return EqualsBuilder.reflectionEquals( this, o );
	}

	public String toString()
	{
		return ToStringBuilder.reflectionToString( this );
	}
}

// End ///////////////////////////////////////////////////////////////
