package metaxa.comparators;

import java.util.Comparator;

import org.apache.commons.math3.stat.inference.WilcoxonSignedRankTest;

public final class MinWilcoxsonFriedmanComparator 
implements Comparator< double [] > {

	private final double significanceLevel;
	private final boolean exactPValue;
	
	///////////////////////////////
	
	public MinWilcoxsonFriedmanComparator( double significanceLevel, boolean exactPValue )
	{
		this.significanceLevel = significanceLevel;
		this.exactPValue = exactPValue; 
	}
	
	///////////////////////////////
	
	@Override
	public int compare(double[] algA, double[] algB) 
	{
		if( algA.length!=algB.length )
			throw new IllegalArgumentException();
		
		WilcoxonSignedRankTest test = new WilcoxonSignedRankTest();
		final double val = test.wilcoxonSignedRankTest( algA, algB, exactPValue );

		if( val > significanceLevel )
			throw new NotComparableAtSignificanceLevel( significanceLevel, val ); 
		
		///////////////////////////
		
		double [] ranks_algA = new double [ algA.length ];
		double [] ranks_algB = new double [ algB.length ];
		
		for( int i=0; i<algA.length; ++i )
		{
			if(algA[i]<algB[i])
			{
				ranks_algA[i]=1.0;
				ranks_algB[i]=2.0;
			}
			else
			{
				if(algA[i]==algB[i])
				{
					ranks_algA[i]=1.5;
					ranks_algB[i]=1.5;
				}
				else
				{
					ranks_algA[i]=2.0;
					ranks_algB[i]=1.0;
				}
			}
		}
		
		double rankAlgA=0.0;
		double rankAlgB=0.0;
		for(int i=0;i<algA.length;i++)
		{
			rankAlgA+=ranks_algA[i];
			rankAlgB+=ranks_algB[i];
		}
		
		rankAlgA/=(double)algA.length;
		rankAlgB/=(double)algB.length;
		
		if(rankAlgA<rankAlgB)
			return 1;
		else
			if(rankAlgA==rankAlgB)
				return 0;
		return -1;
	}

	///////////////////////////////
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("saludos");
		double algA[] ={1.0,2.0,3.0,4.0,5.0};
		double algB[] ={6.0,7.0,8.0,9.0,10.0};
		
		// Comparator<double[]> Max = new MaxWilcoxsonFriedmanComparator();
		final double pValue = 0.05;
		final boolean exactPValue = true;
		Comparator< double [] > Min = new MinWilcoxsonFriedmanComparator( pValue, exactPValue );
		
		//Min Test//
		System.out.println("Min comparation = "+Min.compare(algA, algB));
		//Max Test//
//		System.out.println("Max comparation = "+Max.compare(algA, algB));
		
	}

}
