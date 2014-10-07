package metaxa.comparators;

public final class NotComparableAtSignificanceLevel
extends RuntimeException
{
	private final double significance;
	private final double pValue;	
	
	///////////////////////////
	
	public NotComparableAtSignificanceLevel( double significance, double pValue )
	{
		this.significance = significance;
		this.pValue = pValue;
	}
	
	public double getSignificance() { return significance; }
	public double getPValue() { return pValue; }	
}

// End ///////////////////////////////////////////////////////////////
