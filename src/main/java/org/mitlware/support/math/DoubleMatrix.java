package org.mitlware.support.math;

//////////////////////////////////////////////////////////////////////

/**
 * Adapted from http://introcs.cs.princeton.edu/java/22library/Matrix.java.html
 * which does not appear to have an associated copyright notice.
 */

public final class DoubleMatrix {
    private final int numRows;			// number of rows
    private final int numColumns;       // number of columns
    private final double [][] data;   	// rows-by-columns array

    ///////////////////////////////

    public DoubleMatrix( int numRows, int numColumns ) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        data = new double[ numRows ][ numColumns ];
    }

    public DoubleMatrix( double[][] data ) {
        numRows = data.length;
        numColumns = data[0].length;
        this.data = new double[numRows][numColumns];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                    this.data[i][j] = data[i][j];
    }

    ///////////////////////////////

	public int getNumRows() { return numRows; }
	public int getNumColumns() { return numColumns; }

    public double get( int i, int j ) {
    	if( i < 0 || i >= getNumRows() )
    		throw new IllegalArgumentException( "expected row index in [0.." + getNumRows() + "), found:" + i );
    	if( j < 0 || j >= getNumColumns() )
    		throw new IllegalArgumentException( "expected column index in [0.." + getNumColumns() + "), found:" + j );

    	return data[ i ][ j ];
    }

    public void set( int i, int j, double x ) {
    	if( i < 0 || i >= getNumRows() )
    		throw new IllegalArgumentException( "expected row index in [0.." + getNumRows() + ", found:" + i );
    	if( j < 0 || j >= getNumColumns() )
    		throw new IllegalArgumentException( "expected column index in [0.." + getNumColumns() + ", found:" + j );

    	data[ i ][ j ] = x;
    }

    ///////////////////////////////

    // create and return the N-by-N identity matrix
    public static DoubleMatrix identity(int N) {
        DoubleMatrix I = new DoubleMatrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // create and return the transpose of the invoking matrix
    public DoubleMatrix transpose() {
        DoubleMatrix A = new DoubleMatrix(numColumns, numRows);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    ///////////////////////////////

    // return C = A + B
    public DoubleMatrix plus(DoubleMatrix B) {
        DoubleMatrix A = this;
        if (B.numRows != A.numRows || B.numColumns != A.numColumns) throw new RuntimeException("Illegal matrix dimensions.");
        DoubleMatrix C = new DoubleMatrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public DoubleMatrix minus(DoubleMatrix B) {
        DoubleMatrix A = this;
        if (B.numRows != A.numRows || B.numColumns != A.numColumns) throw new RuntimeException("Illegal matrix dimensions.");
        DoubleMatrix C = new DoubleMatrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // return C = A * B
    public DoubleMatrix times( DoubleMatrix B ) {
        DoubleMatrix A = this;
        if (A.numColumns != B.numRows) throw new RuntimeException("Illegal matrix dimensions.");
        DoubleMatrix C = new DoubleMatrix(A.numRows, B.numColumns);
        for (int i = 0; i < C.numRows; i++)
            for (int j = 0; j < C.numColumns; j++)
                for (int k = 0; k < A.numColumns; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }

    ///////////////////////////////

    // does A = B exactly?
    public boolean eq(DoubleMatrix B) {
        DoubleMatrix A = this;
        if (B.numRows != A.numRows || B.numColumns != A.numColumns)
        	throw new IllegalArgumentException("Illegal matrix dimensions.");

        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                if (A.data[i][j] != B.data[i][j])
                	return false;

        return true;
    }

    ///////////////////////////////

    public String toString() {
    	StringBuffer result = new StringBuffer();
        result.append( '[' );
        for( int i=0; i < numRows; ++i )
        {
            result.append( '[' );
        	for( int j = 0; j<numColumns; ++j )
        	{
                result.append( data[i][j] );
                if( j < numColumns - 1 )
                	result.append( ',' );
        	}
            result.append( ']' );
            if( i < numColumns - 1 )
            	result.append( ',' );
        	result.append( '\n' );
        }
        result.append( "]\n" );
        return result.toString();
    }
}

// End ///////////////////////////////////////////////////////////////



