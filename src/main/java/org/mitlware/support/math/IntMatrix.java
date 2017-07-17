package org.mitlware.support.math;

//////////////////////////////////////////////////////////////////////
/**
 * Adapted from http://introcs.cs.princeton.edu/java/22library/Matrix.java.html
 * which does not appear to have an associated copyright notice.
 */

public final class IntMatrix {

    private final int numRows;			// number of rows
    private final int numColumns;       // number of columns
    private final int [][] data;   	// rows-by-columns array

    ///////////////////////////////

    public IntMatrix( int numRows, int numColumns ) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        data = new int[ numRows ][ numColumns ];
    }

    public IntMatrix( int [][] data ) {
        numRows = data.length;
        numColumns = data[0].length;
        this.data = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                    this.data[i][j] = data[i][j];
    }

    ///////////////////////////////

	public int getNumRows() { return numRows; }
	public int getNumColumns() { return numColumns; }

    public int get( int i, int j ) {
    	if( i < 0 || i >= getNumRows() )
    		throw new IllegalArgumentException( "expected row index in [0.." + getNumRows() + "), found:" + i );
    	if( j < 0 || j >= getNumColumns() )
    		throw new IllegalArgumentException( "expected column index in [0.." + getNumColumns() + "), found:" + j );

    	return data[ i ][ j ];
    }

    public void set( int i, int j, int x ) {
    	if( i < 0 || i >= getNumRows() )
    		throw new IllegalArgumentException( "expected row index in [0.." + getNumRows() + ", found:" + i );
    	if( j < 0 || j >= getNumColumns() )
    		throw new IllegalArgumentException( "expected column index in [0.." + getNumColumns() + ", found:" + j );

    	data[ i ][ j ] = x;
    }

    ///////////////////////////////

    // create and return the N-by-N identity matrix
    public static IntMatrix identity(int N) {
        IntMatrix I = new IntMatrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // create and return the transpose of the invoking matrix
    public IntMatrix transpose() {
        IntMatrix A = new IntMatrix(numColumns, numRows);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    ///////////////////////////////

    // return C = A + B
    public IntMatrix plus(IntMatrix B) {
        IntMatrix A = this;
        if (B.numRows != A.numRows || B.numColumns != A.numColumns) throw new RuntimeException("Illegal matrix dimensions.");
        IntMatrix C = new IntMatrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public IntMatrix minus(IntMatrix B) {
        IntMatrix A = this;
        if (B.numRows != A.numRows || B.numColumns != A.numColumns) throw new RuntimeException("Illegal matrix dimensions.");
        IntMatrix C = new IntMatrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // return C = A * B
    public IntMatrix times( IntMatrix B ) {
        IntMatrix A = this;
        if (A.numColumns != B.numRows) throw new RuntimeException("Illegal matrix dimensions.");
        IntMatrix C = new IntMatrix(A.numRows, B.numColumns);
        for (int i = 0; i < C.numRows; i++)
            for (int j = 0; j < C.numColumns; j++)
                for (int k = 0; k < A.numColumns; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }

    ///////////////////////////////

    // does A = B exactly?
    public boolean eq(IntMatrix B) {
        IntMatrix A = this;
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



