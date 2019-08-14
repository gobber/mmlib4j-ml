package mmlib4j.models.datastruct;

public class NativeOperations implements Operations{
	
	public static final NativeOperations instance = new NativeOperations();
	
	// Column major
	@Override
	public int getIndex(int row, int col, int numRows, int numColumns) {
		return row + col * numRows;
	}

	@Override
	public Matrix sum(Matrix A) {
		Matrix aux1 = new Matrix(1, A.numRows());
		aux1.one();
		Matrix aux2 = new Matrix(1, A.numColumns());
		Matrix aux3 = new Matrix(A.numColumns(), 1);
		aux3.one();
		Matrix C = new Matrix(1, 1);			
		SimpleBlas.multAdd(1, aux1, A, aux2);
		SimpleBlas.multAdd(1, aux2, aux3, C);						
		return C;		
	}
	
	@Override
	public Matrix sum(Matrix A, int axis) {
		Matrix B;
		Matrix C;		
		if(axis == 0) {
			B = new Matrix(1, A.numRows());
			B.one();
			C = new Matrix(1, A.numColumns());
			SimpleBlas.multAdd(1, B, A, C);
			return C;
		} else if(axis == 1) {
			B = new Matrix(A.numColumns(), 1);
			B.one();
			C = new Matrix(A.numRows(), 1);
			SimpleBlas.multAdd(1, A, B, C);
			return C;
		} else {			
			throw new IllegalArgumentException("Invalid axis");			
		}
	}

	@Override
	public Matrix sum(Matrix A, int axis, Matrix C) {
		Matrix B;
		if(axis == 0) {
			B = new Matrix(1, A.numRows());
			B.one();
			SimpleBlas.multAdd(1, B, A, C);
			return C;
		} else if(axis == 1) {
			B = new Matrix(A.numColumns(), 1);
			B.one();	
			SimpleBlas.multAdd(1, A, B, C);
			return C;
		} else {			
			throw new IllegalArgumentException("Invalid axis");			
		}
	}

	@Override
	public Matrix plusi(Matrix A, Matrix B) {
		SimpleBlas.plus(A, B);
		return A;
	}
	
	@Override
	public Matrix plus(Matrix A, Matrix B) {
		Matrix C = A.copy();
		SimpleBlas.plus(C,  B);
		return C;
	}

	@Override
	public Matrix minusi(Matrix A, Matrix B) {
		SimpleBlas.minus(A, B);
		return A;
	}
	
	@Override
	public Matrix minus(Matrix A, Matrix B) {
		Matrix C = A.copy();
		SimpleBlas.minus(C, B);
		return C;
	}

	@Override
	public Matrix dot(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numColumns());
		SimpleBlas.multAdd(1, A, B, C);
		return C;
	}

	@Override
	public Matrix dot(Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.multAdd(1, A, B, C);
	}

	@Override
	public Matrix dot(double value, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numColumns());
		return SimpleBlas.multAdd(value, A, B, C);
	}

	@Override
	public Matrix dot(double value, Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.multAdd(value, A, B, C);
	}

	@Override
	public Matrix Tdot(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numColumns());
		SimpleBlas.transAmultAdd(1, A, B, C);
		return C;
	}

	@Override
	public Matrix Tdot(Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transAmultAdd(1, A, B, C);
	}

	@Override
	public Matrix Tdot(double value, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numColumns());
		return SimpleBlas.transAmultAdd(value, A, B, C);
	}

	@Override
	public Matrix Tdot(double value, Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transAmultAdd(value, A, B, C);
	}

	@Override
	public Matrix dotT(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numRows());
		SimpleBlas.transBmultAdd(1, A, B, C);
		return C;
	}

	@Override
	public Matrix dotT(Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transBmultAdd(1, A, B, C);
	}

	@Override
	public Matrix dotT(double value, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numRows());
		SimpleBlas.transBmultAdd(value, A, B, C);
		return C;
	}

	@Override
	public Matrix dotT(double value, Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transBmultAdd(value, A, B, C);
	}

	@Override
	public Matrix TdotT(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numRows());
		SimpleBlas.transABmultAdd(1, A, B, C);
		return C;
	}

	@Override
	public Matrix TdotT(Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transABmultAdd(1, A, B, C);
	}

	@Override
	public Matrix TdotT(double value, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numRows());
		SimpleBlas.transABmultAdd(value, A, B, C);
		return C;
	}

	@Override
	public Matrix TdotT(double value, Matrix A, Matrix B, Matrix C) {
		return SimpleBlas.transABmultAdd(value, A, B, C);
	}

	@Override
	public Matrix mean(Matrix A) {
		Matrix C = sum(A);
		C.set(0, C.get(0) / (A.numRows()*A.numColumns()));		
		return C;
	}

	@Override
	public Matrix mean(int axis, Matrix A, Matrix C) {
		sum(A, axis, C);
		if(axis == 0)
			C.divi(A.numRows());
		else
			C.divi(A.numColumns());
		return C;
	}
	
	@Override
	public Matrix mean(Matrix A, int axis) {
		Matrix C = sum(A, axis);
		if(axis == 0)
			C.divi(A.numRows());
		else
			C.divi(A.numColumns());
		return C;	
	}
	
}
