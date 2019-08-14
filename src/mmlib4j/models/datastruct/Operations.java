package mmlib4j.models.datastruct;

public interface Operations {
	
	public static final NativeOperations NATIVE  = NativeOperations.instance;
	public static final JavaOperations NO_NATIVE = JavaOperations.instance;
	
	// Help method
	
	public int getIndex(int row, int col, int numRows, int numColumns);
	
	// All made in native (when use NATIVE)	
	
	public Matrix sum(Matrix A);
	
	public Matrix sum(Matrix A, int axis);
	
	public Matrix sum(Matrix A, int axis, Matrix C);
	
	public Matrix plusi(Matrix A, Matrix B);
	
	public Matrix plus(Matrix A, Matrix B);
	
	public Matrix minusi(Matrix A, Matrix B);
	
	public Matrix minus(Matrix A, Matrix B);
	
	public Matrix dot(Matrix A, Matrix B);
	
	public Matrix dot(Matrix A, Matrix B, Matrix C);
	
	public Matrix dot(double alpha, Matrix A, Matrix B);
	
	public Matrix dot(double alpha, Matrix A, Matrix B, Matrix C);
	
	public Matrix Tdot(Matrix A, Matrix B);
	
	public Matrix Tdot(Matrix A, Matrix B, Matrix C);
	
	public Matrix Tdot(double alpha, Matrix A, Matrix B);
	
	public Matrix Tdot(double alpha, Matrix A, Matrix B, Matrix C);
	
	public Matrix dotT(Matrix A, Matrix B);
	
	public Matrix dotT(Matrix A, Matrix B, Matrix C);
	
	public Matrix dotT(double alpha, Matrix A, Matrix B);
	
	public Matrix dotT(double alpha, Matrix A, Matrix B, Matrix C);
	
	public Matrix TdotT(Matrix A, Matrix B);
	
	public Matrix TdotT(Matrix A, Matrix B, Matrix C);
	
	public Matrix TdotT(double alpha, Matrix A, Matrix B);
	
	public Matrix TdotT(double alpha, Matrix A, Matrix B, Matrix C);	
	
	// Partial native (when use NATIVE)
	
	public Matrix mean(Matrix A);
	
	public Matrix mean(Matrix A, int axis);
	
	public Matrix mean(int axis, Matrix A, Matrix C);
	
}
