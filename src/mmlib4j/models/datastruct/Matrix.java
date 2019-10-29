package mmlib4j.models.datastruct;

import java.util.Arrays;

import mmlib4j.options.Options;
import mmlib4j.utils.Random;

/**
 *  
 * <p>
 * A matrix is a rectangular array of numbers arranged by rows and columns. Formally, 
 * a matrix can be defined as :math:`A \in \mathbb{R}^{m\times n}` where :math:`m` is the number
 * of rows and :math:`n` is the number of columns. We access a value in a matrix as
 * :math:`A_{i, j}` where :math:`0 \leq i \leq m` and :math:`0 \leq j \leq n`. We say
 * that :math:`A` is a row vector if :math:`m=1` and that :math:`A` is a column vector 
 * when :math:`n=1`. This is not the usual definition of a vector, but this simplifies 
 * the method definition, since internally they are defined with the Matrix class.       
 * </p>
 * 
 * <p>
 * The Matrix is stored in column major scheme (see <a href="https://en.wikipedia.org/wiki/Row-_and_column-major_order" target="blank">here</a>). 
 * This is a decision project that makes possible to apply native code avoiding memory copy 
 * since we use <a href="http://www.netlib.org/blas/" target="blank">BLAS</a>.
 * </p>
 *  
 * @author Charles Ferreira Gobber
 * @version  0.0.1
 * @since  0.0.1
 * @see Operations
 * @see NativeOperations
 * @see JavaOperations
 * @see SimpleBlas
 *
 */
public class Matrix {
	
	private double data[];
	private int numRows;
	private int numColumns;
	private String separator = ";";
	
	/**
	 * 
	 *	A constructor for Matrix.class. 
	 *  This allocate a Matrix with numRows by numColumns size.
	 *   
	 *  @param numRows Number of rows of the Matrix.
	 *  @param numColumns Number of columns of the Matrix. 
	 * 
	 **/	
	public Matrix (int numRows, int numColumns)	{			
		this.data = new double[numRows * numColumns];			
		this.numRows = numRows;
		this.numColumns = numColumns;
	}
	
	/**
	 * 
	 *	Another constructor for Matrix.class. This allocate a Matrix with numRows by numColumns size.
	 *  This receives a vector stored in column major scheme (see <a href="https://en.wikipedia.org/wiki/Row-_and_column-major_order" target="blank">here</a>). 
	 *
	 *  @param values A vector of double values.
	 *  @param numRows Number of rows of the Matrix.
	 *  @param numColumns Number of columns of the Matrix. 
	 * 
	 **/	
	public Matrix (double values[], int numRows, int numColumns) {
		this(values, numRows, numColumns, false);
	}
	
	/**
	 * 
	 *	Another constructor for Matrix.class. This allocate a Matrix with numRows by numColumns size. 
	 *  This receives a vector stored in column major scheme (see <a href="https://en.wikipedia.org/wiki/Row-_and_column-major_order" target="blank">here</a>). 
	 *		 
	 *  @param values A vector of double values.
	 *  @param numRows Number of rows of the Matrix.
	 *  @param numColumns Number of columns of the Matrix. 
	 *  @param deep A boolean parameter, if true the values vector is cloned, is not cloned otherwise.  
	 * 
	 **/	
	public Matrix (double[] values, int numRows, int numColumns, boolean deep) {
		this.numRows = numRows;
		this.numColumns = numColumns;	
		if(deep)
			data = values.clone();
		else
			data = values;				
	}
	
	/**
	 * 
	 *	Another constructor for Matrix.class. This method copies the Matrix values[][]. 
	 *  This stores a vector in column major scheme (see <a href="https://en.wikipedia.org/wiki/Row-_and_column-major_order" target="blank">here</a>). 
	 *		 
	 *  @param values A Matrix of double values.  
	 * 
	 **/
	public Matrix (double values[][]) {		
		this.numRows = values.length;
		this.numColumns = values[0].length;
		this.data = new double[this.numRows * this.numColumns];		
		for (int row = 0; row < numRows; row++) 
		       for (int col = 0; col < numColumns; col++)
		    	   this.data[row + col * numRows] = values[row][col];		
	}
	
	/**
	 * 
	 *	This method tests if a Matrix is a scalar or not.
	 *
	 *  @return Returns true if the Matrix is a scalar and false otherwise.
	 * 
	 **/
	public boolean isScalar() {
		return numRows*numColumns == 1;
	}
	
	/**
	 * 
	 *	This method tests if a Matrix is a row vector or not.
	 *
	 *  @return Returns true if the Matrix is a row vector and false otherwise.
	 * 
	 **/
	public boolean isRowVector() {
		return numRows == 1 && numColumns!=1;
	}
	
	/**
	 * 
	 *	This method tests if a Matrix is a column vector or not.
	 *
	 *  @return Returns true if the Matrix is a column vector and false otherwise.
	 * 
	 **/
	public boolean isColVector() {
		return numColumns == 1 && numRows != 1;
	}
	
	/**
	 * 
	 *	This method tests if a Matrix is a matrix.
	 *
	 *  @return Returns true if the Matrix is a matrix and false otherwise.
	 * 
	 **/
	public boolean isMatrix() {
		return !isRowVector() && !isColVector();
	}
	
	/**
	 * 
	 *	This method returns a string with the shape of the Matrix.
	 *
	 *  @return Returns (numRows, numColumns)
	 * 
	 **/
	public String shape() {
		return "("+numRows + ","+ numColumns + ")";
	}
	
	/**
	 * 
	 *	This method returns the separator of the Matrix.
	 *
	 *  @return Returns the separator. Default is ";"
	 * 
	 **/
	public String getSeparator() {
		return separator;
	}
	
	/**
	 * 
	 *	This method sets the separator of the Matrix. 
	 *
	 *  @param separator A String separator useful to save store a Matrix as a file. 
	 * 
	 **/
	public void setSeparator(String separator) {
		this.separator = separator;	
	}
	
	/**
	 * 
	 *	This method return a value of the Matrix from pos.
	 *	
	 *	@param pos A valid position of the Matrix.
	 *  @return Value of the position pos.
	 * 
	 **/
	public double get(int pos) {
		return data[pos];
	}
	
	/**
	 * 
	 *	This method sets a value of the Matrix from a position pos.
	 *	
	 *	@param pos A valid position of the Matrix.
	 *  @param value A value to be stored in pos.
	 * 
	 **/
	public void set(int pos, double value) {
		data[pos] = value;
	} 
	
	/**
	 * 
	 *	This method return a value of the Matrix from a position (row, col).
	 *	
	 *	@param row A valid row of the Matrix.
	 *  @param col A valid col of the Matrix.
	 *  @return Value of the position (row, col).
	 * 
	 **/
	public double get(int row, int col) {
		return data[row + col * numRows];
	}
	
	/**
	 * 
	 *	This method sets a value of the Matrix from a position (row, col).
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 *  @param value A value to be stored in (row, col).
	 * 
	 **/
	public void set(int row, int col, double value) {
		data[row + col * numRows] = value;
	} 
	
	/**
	 * 
	 *	This method adds the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation: 
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}+v,
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 *  @param value A value to adds the value stored in (row, col).
	 * 
	 **/
	public void plus(int row, int col, double value) {
		data[row + col * numRows] += value;
	}
	
	/**
	 * 
	 *	This method multiplies the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation: 
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}*v,
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 *  @param value A value to multiplies the value stored in (row, col).
	 * 
	 **/
	public void mul(int row, int col, double value) {
		data[row + col * numRows] *= value;
	}
	
	/**
	 * 
	 *	This method subtracts the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation: 
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}-v,
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 *  @param value A value to subtracts the value stored in (row, col).
	 * 
	 **/
	public void minus(int row, int col, double value) {
		data[row + col * numRows] -= value;
	}
	
	/**
	 * 
	 *	This method divides the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=\frac{A_{r, c}}{v},
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 *  @param value A value to divides the value stored in (row, col).
	 * 
	 **/
	public void div(int row, int col, double value) {
		data[row + col * numRows] /= value;
	}
	
	/**
	 * 
	 *	This method squares the value stored in Matrix position (row, col).
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}^2,
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows and :math:`c` is the number of columns. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 * 
	 **/	
	public void pow2(int row, int col) {
		data[row + col * numRows] *= data[row + col * numRows];
	}
	
	/**
	 * 
	 *	This method negates the value stored in Matrix position (row, col).
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}*-1,
	 *	</p>
	 *	
	 *	where :math:`r` is the number of rows and :math:`c` is the number of columns. 
	 *	
	 *	@param row A valid row of the Matrix.
	 *	@param col A valid col of the Matrix.
	 * 
	 **/
	public void neg(int row, int col) {
		data[row + col * numRows] *= -1;
	}
	
	/**
	 * 
     *  This method adds the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}+v,
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 *	@param value A value to adds the value stored in (row, col).
	 * 
	 **/
	public void plus(int pos, double value) {
		data[pos] += value;
	}
	
	/**
	 * 
     *  This method multiplies the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}*v,
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 *	@param value A value to multiplies the value stored in (row, col).
	 * 
	 **/
	public void mul(int pos, double value) {
		data[pos] *= value;
	}
	
	/**
	 * 
     *  This method subtracts the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}-v,
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 *	@param value A value to subtracts the value stored in (row, col).
	 * 
	 **/
	public void minus(int pos, double value) {
		data[pos] -= value;
	}
	
	/**
	 * 
     *  This method divides the value stored in Matrix position (row, col) by a value passed for parameter.
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=\frac{A_{r, c}}{v},
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 *	@param value A value to divides the value stored in (row, col).
	 * 
	 **/	
	public void div(int pos, double value) {
		data[pos] /= value;
	}
	
	/**
	 * 
	 *	This method squares the value stored in Matrix position (row, col).
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}^2,
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 * 
	 **/	
	public void pow2(int pos) {
		data[pos] *= data[pos];
	}
	
	/**
	 * 
	 *	This method negates the value stored in Matrix position (row, col).
	 *  This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	A_{r,c}=A_{r, c}*-1,
	 *	</p>
	 *	
	 *	where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns. 
	 *	
	 *	@param pos A valid position of the Matrix.
	 * 
	 **/	
	public void neg(int pos) {
		data[pos] *= -1;
	}
	
	/**
	 * 
	 *	This method returns the data that represents the Matrix. 
	 *	
	 *	@return The vector of Matrix values. 
	 * 
	 **/	
	public double[] getData() {
		return data;
	}

	/**
	 * 
	 *	This method sets the data that represents the Matrix. 
	 *	
	 *	@param data A vector of doubles.  
	 * 
	 **/	
	public void setData(double[] data) {
		this.data = data;
	}

	/**
	 * 
	 *	This method returns the number of rows of the Matrix. 
	 *	
	 *	@return The number of rows of the Matrix. 
	 * 
	 **/
	public int numRows() {
		return numRows;
	}

	/**
	 * 
	 *	This method sets the number of rows of the Matrix. 
	 *	
	 *	@param numRows The number of rows of the Matrix. 
	 * 
	 **/
	public void numRows(int numRows) {
		this.numRows = numRows;
	}

	/**
	 * 
	 *	This method returns the number of columns of the Matrix. 
	 *	
	 *	@return The number of columns of the Matrix. 
	 * 
	 **/
	public int numColumns() {
		return numColumns;
	}

	/**
	 * 
	 *	This method sets the number of columns of the Matrix. 
	 *	
	 *	@param numColumns The number of columns of the Matrix. 
	 * 
	 **/
	public void numColumns(int numColumns) {
		this.numColumns = numColumns;
	}
	
	/**
	 * 
	 *	This method prints the Matrix.  
	 * 
	 **/
	public void print() {
		for(int row = 0 ; row < numRows ; row++) {
  			for(int col = 0 ; col < numColumns ; col++) {
  				System.out.printf("[%e] ", get(row, col));
  			}    		
  			System.out.println();
  		}   	
	}
	
	/**
	 * 
	 *	This method fills the Matrix by value.
	 *	This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	\forall (r, c), A_{r,c}=v,
	 *	</p>
	 *	
	 *	where :math:`v` is a value to fill :math:`A`.
	 *  
	 *  @param value The value to fill the Matrix. 
	 * 
	 **/
	public Matrix fill(double value){
		Arrays.fill(data, value);
		return this;
	}
	
	/**
	 * 
	 *	This method copies the Matrix. 
	 *	
	 *	@return Returns a copy of the instantiated Matrix. 
	 *
	 **/
	public Matrix copy(){
		Matrix copy = new Matrix(data, numRows, numColumns, true);
		return copy;
	}
	
	/**
	 * 
	 *	This method prints the Matrix given a maximum number of (numRows, numColumns) and
	 *	a given format.
	 *
	 *  @param numRows The maximum number of rows.
	 *  @param numColumns The maximum number of columns.
	 *  @param format The format to print the Matrix. 
	 *
	 **/
	public void head(int numRows, int numColumns, String format) {
		numRows = numRows       > this.numRows    ? this.numRows    : numRows;
		numColumns = numColumns > this.numColumns ? this.numColumns : numColumns;	
		for(int row = 0 ; row < numRows ; row++) { 
			for(int col= 0 ; col < numColumns ; col++)
				System.out.format(format, get(row, col));
			System.out.println();			
		}	
	}	
	
	/**
	 * 
	 *	This method prints the Matrix given a maximum number of (numRows, numColumns) and
	 *	the format "[%e]".
	 *
	 *  @param numRows The maximum number of rows.
	 *  @param numColumns The maximum number of columns.
	 *
	 **/
	public void head(int numRows, int numColumns) {
		head(numRows, numColumns, "[%e]");
	}
	
	/**
	 * 
	 *	This method prints the first 6 lines of the Matrix, or numRows if 6 > numRows.
	 *
	 **/
	public void head() {
		head(6, numColumns);
	}
	
	/**
	 * 
	 *	This method prints the first numRows lines of the Matrix, or this.numRows if numRows > this.numRows.
	 *
	 *	@param numRows Number of rows to be printed.	
	 *
	 **/
	public void head(int numRows) {		
		head(numRows, numColumns, "[%e]");
	}
	
	/**
	 * 
	 *	This method fills the Matrix with 1s. 
	 *  This method implements the following operation: :math:`\forall (r, c), A_{r,c}=1`
	 * 
	 **/
	public Matrix one(){
		fill(1);
		return this;
	}
	
	/**
	 * 
	 *	This method fills the Matrix with 0s. 
	 *  This method implements the following operation: :math:`\forall (r, c), A_{r,c}=0`
	 * 
	 **/
	public Matrix zero(){
		fill(0);
		return this;
	}	
	
	/**
	 * 
	 *	This method converts the Matrix to a String.
	 *
	 * 	@return A String that represents the Matrix.
	 * 
	 **/
	public String toString() {
		String out = "";					
		for(int row = 0 ; row < numRows ; row++)
			for(int col = 0 ; col < numColumns ; col++)
				out += get(row, col) + separator;
		return out.substring(0, out.length()-1);	
	}
	
	/**
	 * 
	 *	This method returns the length of the Matrix.
	 *
	 * 	@return The length of the Matrix (numRows x numColumns).
	 * 
	 **/
	public int length() {
		return data.length;
	}
	
	/**
	 * 
	 *	This method returns a given row of the Matrix.
	 *	This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	\forall c=1,\ldots,n,~ C_{1,c}=A_{r,c},
	 *	</p>
	 *	
	 *	where :math:`r` is the row and :math:`C` is a Matrix allocated inside the method.
	 *	
	 *	@param row A row of :math:`A`
	 * 	@return A row Matrix (or a vector) of a given row.
	 * 
	 **/
	public Matrix row(int row){
		Matrix C = new Matrix(1, numColumns);		
		return row(row, C);
	}
	
	/**
	 * 
	 *	This method returns a given row of the Matrix, but it writes the values in 
	 *	the Matrix :math:`C`.
	 *	This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	\forall c=1,\ldots,n,~ C_{r,c}=A_{r,c},
	 *	</p>
	 *	
	 *	where :math:`1\leq r\leq m` is the row and :math:`C` is a Matrix passed by parameter.
	 *	
	 *	@param row A row of :math:`A`
	 *  @param C A Matrix to store the row of :math:`A`  
	 * 	@return The Matrix :math:`C` filled by the given row of :math:`A`
	 * 
	 **/
	public Matrix row(int row, Matrix C){
		for (int col = 0; col < numColumns; col++)
			C.set(0, col, get(row, col));
		return C;
	}
	
	/**
	 * 
	 *	This method returns a given column of the Matrix.
	 *	This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	\forall r=1,\ldots,m,~ C_{r,c}=A_{r,c},
	 *	</p>
	 *	
	 *	where :math:`1\leq c\leq n` is the column and :math:`C` is a Matrix allocated inside the method.
	 *	
	 *	@param column A column of :math:`A`
	 * 	@return A column Matrix (or a vector) of a given column.
	 * 
	 **/
	public Matrix column(int column){
		Matrix C = new Matrix(numRows, 1);		
		return column(column, C);
	}
	
	/**
	 * 
	 *	This method returns a given column of the Matrix, but it writes the values in 
	 *	the Matrix :math:`C`.
	 *	This method implements the following operation:
	 *  
	 *  <p>
	 *  .. math::
	 *  
	 *  	\forall r=1,\ldots,m,~ C_{r,c}=A_{r,c},
	 *	</p>
	 *	
	 *	where :math:`1\leq c\leq n` is the column and :math:`C` is a Matrix passed by parameter.
	 *
	 *	@param column A column of :math:`A`
	 *  @param C A Matrix to store the column of :math:`A`  
	 * 	@return The Matrix :math:`C` filled by the given column of :math:`A`
	 * 
	 **/
	public Matrix column(int column, Matrix C){
		for (int row = 0; row < numRows; row++)
			C.set(row, 0, get(row, column));
		return C;
	}
	
	/**
	 * 
	 *	This method returns a binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), C_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} > t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix allocated inside the method.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The Matrix :math:`C` with the binary comparison.
	 * 
	 **/
	public Matrix biggerthen(double t) {	
		Matrix C = new Matrix(numRows, numColumns);
		return biggerthen(t, C);
	}
	
	/**
	 * 
	 *	This method returns a binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), C_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} > t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix passed by parameter.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The Matrix :math:`C` with the binary comparison. 
	 * 
	 **/
	public Matrix biggerthen(double t, Matrix C) {		
		for (int pos = 0; pos < data.length; pos++) 
	        if(get(pos) > t)
	        	C.set(pos, 1);
	        else
	        	C.set(pos, 0);
		return C;
	}
	
	/**
	 * 
	 *	This method returns a in place binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), A_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} > t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The Matrix :math:`C` with the binary comparison. 
	 * 
	 **/
	public Matrix biggertheni(double t){
		return biggerthen(t, this);
	}
	
	/**
	 * 
	 *	This method returns a binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), C_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} < t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix passed by parameter.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The Matrix :math:`C` with the binary comparison. 
	 * 
	 **/
	public Matrix lessthen(double t){
		Matrix C = new Matrix(numRows, numColumns);
		return lessthen(t, C);
	}
	
	/**
	 * 
	 *	This method returns a binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), C_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} < t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix allocated inside the method.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The Matrix :math:`C` with the binary comparison. 
	 * 
	 **/
	public Matrix lessthen(double t, Matrix C){
		for (int pos = 0; pos < data.length; pos++) 
	        if(get(pos) < t)
	        	C.set(pos, 1);
	        else
	        	C.set(pos, 0);
		return C;
	}
	
	/**
	 * 
	 *	This method returns a in place binary Matrix of the following comparison:
	 *
	 *	<p>
	 *  .. math::
	 *  	\forall (r, c), A_{r, c} = \begin{cases}
	 *  		1,& \text{ if } A_{r, c} < t,\\
	 *          0,& \text{ otherwise }\\  
	 *  	\end{cases}
	 *  </p>
	 *  
	 *  where :math:`t \in \mathbb{R}` is a threshold.
	 *	
	 *	@param t The value of threshold.  
	 * 	@return The in place Matrix :math:`A` with the binary comparison. 
	 * 
	 **/
	public Matrix lesstheni(double t){
		return lessthen(t, this);
	}
	
	/**
	 * 
	 *	This method returns the sum of all elements of the Matrix. 
	 *	It is computed natively if Options.operations = Operations.NATIVE, and 
	 *	no native otherwise.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	s = \sum_{r=1}^m\sum_{c=1}^nA_{r, c}
	 *  </p>
	 * 	
	 * 	where :math:`s` is the sum of :math:`A`.
	 * 
	 *  @return The Matrix :math:`C` of the sum of all elements of :math:`A`  
	 * 
	 **/
	public Matrix sum() {
		return Options.operations.sum(this);
	}
	
	/**
	 * 
	 *	This method returns the sum of all elements of the Matrix of a given axis. 
	 *	It is computed natively if Options.operations = Operations.NATIVE, and 
	 *	no native otherwise.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	\begin{align}
	 *  	C_{1, c} &= \sum_{r=1}^mA_{r, c}, 1\leq c \leq n, \text{ if } axis=0\\
	 *  	C_{r, 1} &= \sum_{c=1}^nA_{r, c}, 1\leq r \leq m, \text{ if } axis=1
	 *  	\end{align}
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the sum of a given axis of :math:`A`.
	 * 
	 *  @param axis A valid axis, 0 or 1.
	 *  @return The Matrix :math:`C` the sum of a given axis of :math:`A`  
	 * 
	 **/
	public Matrix sum(int axis) {
		return Options.operations.sum(this, axis);
	}	
	
	/**
	 * 
	 *	This method returns the sum of all elements of the Matrix of a given axis. 
	 *	It is computed natively if Options.operations = Operations.NATIVE, and 
	 *	no native otherwise.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	\begin{align}
	 *  	C_{1, c} &= \sum_{r=1}^mA_{r, c}, 1\leq c \leq n, \text{ if } axis=0\\
	 *  	C_{r, 1} &= \sum_{c=1}^nA_{r, c}, 1\leq r \leq m, \text{ if } axis=1
	 *  	\end{align}
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the sum of a given axis of :math:`A`.
	 * 	
	 *  @param axis A valid axis, 0 or 1.
	 *  @param A Matrix :math:`C` to store the sum.
	 *  @return The Matrix :math:`C` the sum of a given axis of :math:`A`.  
	 * 
	 **/
	public Matrix sum(int axis, Matrix C) {
		return Options.operations.sum(this, axis, C);
	}
	
	/**
	 * 
	 *	This method returns the transposition of the Matrix, i.e., :math:`C=A^T`,
	 *	where :math:`C` is allocated internally. 
	 * 	
	 * 	@return A Matrix :math:`C` that is :math:`A^T`. 
	 **/
	public Matrix T() {
		Matrix C = new Matrix(numColumns, numRows);
		return T(C);
	}
	
	/**
	 * 
	 *	This method returns the transposition of the Matrix, i.e., :math:`C=A^T`,
	 *	where :math:`C` is passed by parameter. 
	 * 	
	 * 	@param A Matrix :math:`C`.
	 * 	@return A Matrix :math:`C` that is :math:`A^T`. 
	 **/
	public Matrix T(Matrix C){
		for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	
            	C.set(col, row, get(row, col)); 		
		return C;	
	}
	
	/**
	 * 
	 *	This method returns the in place point wise multiplication between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A * B
	 *  </p>
	 * 	
	 * 	
	 *  @param B A Matrix :math:`B` to multiplies with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place point wise multiplication between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix muli(Matrix B){
		if(B.isScalar()) {
			return mul(B.get(0), this);
		}		
		return mul(B, this);
	}
	
	/**
	 * 
	 *	This method returns the in place scalar multiplication between two :math:`A` and :math:`v`.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A * v
	 *  </p>
	 * 	
	 * 	where :math:`v` is a value.
	 * 	
	 *  @param value A value to multiplies with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place scalar multiplication between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix muli(double value){
		return mul(value);
	}
	
	private Matrix mul_inrow(Matrix B, Matrix C){
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)		
				C.set(row, col, get(row, col) * B.get(col));
		return C;
	}
	
	private Matrix mul_incol(Matrix B, Matrix C){
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)		
				C.set(row, col, get(row, col) * B.get(row));
		return C;
	}
	
	/**
	 * 
	 *	This method returns the point wise multiplication between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A * B
	 *  </p>
	 * 	
	 * 	where :math:`C` (passes by parameter) is the point wise multiplication between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to multiplies with :math:`A`.
	 *  @param C A Matrix :math:`C` to store :math:`A*B`.
	 *  @return The Matrix :math:`C` that is the point wise multiplication between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix mul(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return mul_inrow(B, C);
		} else if(B.isColVector()){
			return mul_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) * B.get(pos));							
			return C;
		}
	}
	
	/**
	 * 
	 *	This method returns the point wise multiplication between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A * B
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the point wise multiplication between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to multiplies with :math:`A`.
	 *  @param C A Matrix :math:`C` to store :math:`A*B`.
	 *  @return The Matrix :math:`C` that is the point wise multiplication between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix mul(Matrix B){
		Matrix C = new Matrix(numRows, numColumns);
		if(B.isScalar()) {
			return mul(B.get(0), C);
		}		
		return mul(B, C);
	}
	
	/**
	 * 
	 *	This method returns the scalar multiplication between two :math:`A` and :math:`v`.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A * v
	 *  </p>
	 * 	
	 * 	where :math:`v` is a value and :math:`C` (allocated internally) is the scalar multiplication between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A value to multiplies with :math:`A`.
	 *  @return The Matrix :math:`C` that is the scalar multiplication between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix mul(double value){
		Matrix C = new Matrix(numRows, numColumns);   			       
		return mul(value, C); 
	}
	
	/**
	 * 
	 *	This method returns the scalar multiplication between two :math:`A` and :math:`v`.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A * v
	 *  </p>
	 * 	
	 * 	where :math:`v` is a value and :math:`C` (passed by parameter) is the scalar multiplication between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A value to multiplies with :math:`A`.
	 *  @param C A Matrix :math:`C` to store :math:`A*v`. 
	 *  @return The Matrix :math:`C` that is scalar multiplication between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix mul(double value, Matrix C){		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) * value);						
		return C;
	}
	
	/**
	 * 
	 *	This method returns the point wise summation between two Matrix.
	 *	It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is
	 *	not a scalar, and no native otherwise.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A + B
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the point wise summation between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to sum with :math:`A`.
	 *  @return The Matrix :math:`C` that is the point wise summation between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix plus(Matrix B){
		if(B.isScalar()) {
			return plus(B.get(0), B);
		}   
		return Options.operations.plus(this, B);
	}
	
	/**
	 * 
	 *	This method returns the in place point wise summation between two Matrix.
	 *	It is computed natively if Options.operations = Operations.NATIVE, and 
	 *	no native otherwise.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A + B
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place point wise summation between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to sum with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place point wise summation between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix plusi(Matrix B){
		if(B.isScalar()) {
			return plus(B.get(0), this);
		}    		
		return Options.operations.plusi(this, B);
	}
	
	/**
	 * 
	 *	This method returns the in place scalar summation between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A + v
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place scalar summation between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to sum with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place scalar summation between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix plusi(double value){   			       
		return plus(value, this); 
	}
	
	private Matrix plus_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) + B.get(col));
		return C;
	}
	
	private Matrix plus_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) + B.get(row));
		return C;
	}
	
	/**
	 * 
	 *	This method returns the in place point wise summation between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A + B
	 *  </p>
	 * 	
	 * 	where :math:`C` is the point wise summation between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to sum with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the point wise summation between :math:`A` and :math:`B`.
	 *  @return The Matrix :math:`C` that is the point wise summation between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix plus(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return plus_inrow(B, C);
		} else if(B.isColVector()){
			return plus_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) + B.get(pos));  							
			return C;
		}
	}
	
	/**
	 * 
	 *	This method returns the scalar summation between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A + v
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the scalar summation between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to sum with :math:`A`.
	 *  @return The Matrix :math:`C` that is the scalar summation between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix plus(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return plus(value, C);
	}
	
	/**
	 * 
	 *	This method returns the scalar summation between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A + v
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the scalar summation between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to sum with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the scalar summation between :math:`A` and :math:`v`.
	 *  @return The Matrix :math:`C` that is the scalar summation between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix plus(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) + value);							
		return C;
	}		
	
	/**
	 * 
	 *	This method returns the point wise subtraction between two Matrix.
	 *	It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is
	 *	not a scalar, and no native otherwise.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A - B
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the point wise subtraction between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to subtract with :math:`A`.
	 *  @return The Matrix :math:`C` that is the point wise subtraction between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix minus(Matrix B){
		return Options.operations.minus(this, B);
	}
	
	/**
	 * 
	 *	This method returns the in place point wise subtraction between two Matrix.
	 *	It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is
	 *	not a scalar, and no native otherwise.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A - B
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place point wise subtraction between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to subtract with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place point wise subtraction between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix minusi(Matrix B){
		if(B.isScalar()) {
			return minus(B.get(0), this);
		}		
		return Options.operations.minusi(this, B);
	}
	
	/**
	 * 
	 *	This method returns the in place scalar subtraction between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A - v
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place scalar subtraction between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to subtract with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place scalar subtraction between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix minusi(double value){
		return minus(value, this);
	}
	
	private Matrix minus_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) - B.get(col));
		return C;
	}
	
	private Matrix minus_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) - B.get(row));
		return C;
	}
	
	/**
	 * 
	 *	This method returns the point wise subtraction between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A - B
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the point wise subtraction between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to subtract with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the point wise subtraction between :math:`A` and :math:`B`.
	 *  @return The Matrix :math:`C` that is the point wise subtraction between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix minus(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return minus_inrow(B, C);
		} else if(B.isColVector()){
			return minus_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) - B.get(pos));  							
			return C;
		}
	}
	
	/**
	 * 
	 *	This method returns the scalar subtraction between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A - v
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the scalar subtraction between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to subtract with :math:`A`.
	 *  @return The Matrix :math:`C` that is the scalar subtraction between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix minus(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return minus(value, C);
	}
	
	/**
	 * 
	 *	This method returns the scalar subtraction between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = A - v
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the scalar subtraction between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to subtract with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the scalar subtraction between :math:`A` and :math:`v`.
	 *  @return The Matrix :math:`C` that is the scalar subtraction between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix minus(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) - value);  							
		return C;
	}	
	
	/**
	 * 
	 *	This method returns the in place scalar division between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = A - v
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place scalar division between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to divide with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place scalar division between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix divi(double value){		
		return div(value, this);	
	}
	
	/**
	 * 
	 *	This method returns the in place point wise division between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	A = \frac{A}{B}
	 *  </p>
	 * 	
	 * 	where :math:`A` is the in place point wise division between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to divide with :math:`A`.
	 *  @return The Matrix :math:`A` that is the in place point wise division between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix divi(Matrix B){
		if(B.isScalar()) {
			return div(B.get(0), this);
		}    		
		return div(B, this);
	}
	
	private Matrix div_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) / B.get(col));
		return C;
	}
	
	private Matrix div_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) / B.get(row));
		return C;
	}
	
	/**
	 * 
	 *	This method returns the point wise division between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = \frac{A}{B}
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the point wise division between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to divide with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the point wise division between :math:`A` and :math:`B`.
	 *  @return The Matrix :math:`C` that is the point wise division between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix div(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return div_inrow(B, C);
		} else if(B.isColVector()){
			return div_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) / B.get(pos));  							
			return C;
		}
	}
	
	/**
	 * 
	 *	This method returns the point wise division between two Matrix.
	 *	This supports broadcasting operations. 
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = \frac{A}{B}
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the point wise division between :math:`A` and :math:`B`.
	 * 	
	 *  @param B A Matrix :math:`B` to divide with :math:`A`.
	 *  @return The Matrix :math:`C` that is the point wise division between :math:`A` and :math:`B`.  
	 * 
	 **/
	public Matrix div(Matrix B){
		Matrix C = new Matrix(numRows, numColumns);
		if(B.isScalar()) {
			return div(B.get(0), C);
		}
		return div(B, C);
	}
	
	/**
	 * 
	 *	This method returns the scalar division between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = \frac{A}{v}
	 *  </p>
	 * 	
	 * 	where :math:`C` (allocated internally) is the scalar division between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to divide with :math:`A`.
	 *  @return The Matrix :math:`C` that is the scalar division between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix div(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return div(value, C);
	}
	
	/**
	 * 
	 *	This method returns the scalar division between a Matrix and a value.
	 *	This method implements the following operation: 
	 * 	
	 * 	<p>
	 *  .. math::
	 *  	C = \frac{A}{v}
	 *  </p>
	 * 	
	 * 	where :math:`C` (passed by parameter) is the scalar division between :math:`A` and :math:`v`.
	 * 	
	 *  @param value A scalar to divide with :math:`A`.
	 *  @param C A Matrix :math:`C` to store the scalar division between :math:`A` and :math:`v`.
	 *  @return The Matrix :math:`C` that is the scalar division between :math:`A` and :math:`v`.  
	 * 
	 **/
	public Matrix div(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) / value);						
		return C;				
	}

	public Matrix dot(Matrix B){
		return Options.operations.dot(this, B);
	}
	
	public Matrix dot(Matrix B, Matrix C){
		return Options.operations.dot(this, B, C);
	}
	
	public Matrix dot(double value, Matrix B){
		return Options.operations.dot(value, this, B);
	}
	
	public Matrix dot(double value, Matrix B, Matrix C){
		return Options.operations.dot(value, this, B, C);
	}

	public Matrix Tdot(Matrix B){
		return Options.operations.Tdot(this, B);
	}
	
	public Matrix Tdot(Matrix B, Matrix C){
		return Options.operations.Tdot(this, B, C);
	}
	
	public Matrix Tdot(double value, Matrix B){
		return Options.operations.Tdot(value, this, B);
	}
	
	public Matrix Tdot(double value, Matrix B, Matrix C){
		return Options.operations.Tdot(value, this, B, C);
	}	
	
	public Matrix dotT(Matrix B){
		return Options.operations.dotT(this, B);
	}
	
	public Matrix dotT(Matrix B, Matrix C){
		return Options.operations.dotT(this, B, C);
	}
	
	public Matrix dotT(double value, Matrix B){
		return Options.operations.dotT(value, this, B);
	}
	
	public Matrix dotT(double value, Matrix B, Matrix C){
		return Options.operations.dotT(value, this, B, C);
	}
	
	public Matrix TdotT(Matrix B){
		return Options.operations.TdotT(this, B);
	}
	
	public Matrix TdotT(Matrix B, Matrix C){
		return Options.operations.TdotT(this, B, C);
	}
	
	public Matrix TdotT(double value, Matrix B){
		return Options.operations.TdotT(value, this, B);
	}
	
	public Matrix TdotT(double value, Matrix B, Matrix C){
		return Options.operations.TdotT(value, this, B, C);
	}

	public Matrix negi(){
		return neg(this);
	}
	
	public Matrix neg(){
		Matrix C = new Matrix(numRows, numColumns);
		return neg(C);
	}
	
	public Matrix neg(Matrix C){		
		for (int pos = 0; pos < data.length; pos++)
			C.set(pos, -get(pos));
		return C;
	}
	
	public Matrix mean(){
		return Options.operations.mean(this);
	}
	
	public Matrix mean(int axis, Matrix C){
		return JavaOperations.instance.mean(axis, this, C);
	}
	
	public Matrix mean(int axis){
		return Options.operations.mean(this, axis);
	}	
	
	public Matrix pow2i(){
		return pow2(this);
	}
	
	public Matrix pow2(){
		Matrix C = new Matrix(numRows, numColumns);
		return pow2(C);
	}
	
	public Matrix pow2(Matrix C) {
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, get(pos) * get(pos));		
		return C;
	}
	
	public Matrix powi(double exponent){
		return pow(exponent, this);
	}
	
	public Matrix pow(double exponent){
		Matrix C = new Matrix(numRows, numColumns);
		return pow(exponent, C);
	}
	
	public Matrix pow(double exponent, Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.pow(get(pos), exponent));		
		return C;
	}
	
	public Matrix sqrti(){
		return sqrt(this);
	}
	
	public Matrix sqrt(){
		Matrix C = new Matrix(numRows, numColumns);
		return sqrt(C);
	}
	
	public Matrix sqrt(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.sqrt(get(pos)));		
		return C;			
	}
	
	public Matrix expi(){
		return exp(this);
	}
		
	public Matrix exp(){
		Matrix C = new Matrix(numRows, numColumns);
		return exp(C);
	}
	
	public Matrix exp(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.exp(get(pos)));		
		return C;
	}
	
	public Matrix tanhi(){
		return tanh(this);
	}
	
	public Matrix tanh(){
		Matrix C = new Matrix(numRows, numColumns);
		return tanh(C);
	}
	
	public Matrix tanh(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.tanh(get(pos)));		
		return C;			
	}
	
	private Matrix var(int axis, int div, int d, Matrix C) {		
		Matrix mean = mean(axis);
		Matrix aux  = minus(mean, C).powi(2);
		mean.zero();		
		aux.sum(axis, mean);
		return mean.divi(div-d);
	}
	
	public Matrix var(int axis, int d){
		Matrix C = new Matrix(numRows, numColumns);
		if(axis == 0) {    		
    		return var(axis, numRows, d, C);    		
    	}else if(axis == 1){    		
    		return var(axis, numColumns, d, C);    		
    	}else {
			throw new IllegalArgumentException("Invalid axis");
		}    	
	}
	
	private Matrix std(int axis, int div, int d, Matrix C) {				
		Matrix var = var(axis, div, d, C);	
		return var.sqrti();				
	} 
	
	public Matrix std(int axis, int d){
		Matrix C = new Matrix(numRows, numColumns);
		if(axis == 0) {
    		return std(axis, numRows, d, C);    		
    	}else if(axis == 1){
    		return std(axis, numColumns, d, C);    	
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}    	 
	}
	
	private Matrix max_inrow(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(col, Math.max(get(row, col), C.get(col)));
		return C;
	}
	
	private Matrix max_incol(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, Math.max(get(row, col), C.get(row)));
		return C;
	}
	
	private Matrix max(Matrix C){		
		if(C.isRowVector()) {
			return max_inrow(C);
		} else if(C.isColVector()){
			return max_incol(C);
		}		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(0, Math.max(C.get(0), get(pos)));	                      
		return C;    	
	}
	
	public Matrix max(){
		Matrix C = new Matrix(1, 1);
		C.fill(Double.MIN_VALUE);
		return max(C);
	}
	
	public Matrix max(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		C.fill(Double.MIN_VALUE);
    		return max_inrow(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		C.fill(Double.MIN_VALUE);
    		return max_incol(C);	
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}       	
	}
	
	public Matrix max(double value, Matrix C){		
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.max(get(pos), value));		            	        
		return C;		
	}
	
	public Matrix maxi(double value){
		return max(value, this);
	}	
	
	private Matrix min_inrow(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(col, Math.min(get(row, col), C.get(col)));
		return C;
	}
	
	private Matrix min_incol(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, Math.min(get(row, col), C.get(row)));
		return C;
	}
	
	private Matrix min(Matrix C){		
		if(C.isRowVector()) {
			return min_inrow(C);
		} else if(C.isColVector()){
			return min_incol(C);
		}		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(0, Math.min(C.get(0), get(pos)));                      
		return C;    	
	}
	
	public Matrix min(){
		Matrix C = new Matrix(1, 1);
		C.fill(Double.MAX_VALUE);
		return min(C);
	}
	
	public Matrix min(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		C.fill(Double.MAX_VALUE);
    		return min_inrow(C);  		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		C.fill(Double.MAX_VALUE);
    		return min_incol(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}       	
	}
	
	public Matrix min(double value, Matrix C){
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.min(get(pos), value));		            	        
		return C;		
	}
	
	private Matrix colargmax(Matrix C) {		
		Matrix aux = new Matrix(numRows, 1);		
		aux.fill(Double.MIN_VALUE);		
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)
            	if(get(row, col) > aux.get(row)) {            		
            		aux.set(row, get(row, col));            	    
            		C.set(row, col);            		            		
            	}    	    	    	    	
		return C;		
    }
	
	private Matrix rowargmax(Matrix C) {
		Matrix aux = new Matrix(1, numColumns);		
		aux.fill(Double.MIN_VALUE);
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	                    
            	if(get(row, col) > aux.get(col)) {            		
            		aux.set(col, get(row, col));            	    
            		C.set(col, row);            		            		
            	}    	    	    	           
		return C;		   	
    }
	
	public Matrix argmax(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		return rowargmax(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		return colargmax(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}     
	}
	
	private Matrix colargmin(Matrix C) {		
		Matrix aux = new Matrix(1, numColumns);		
		aux.fill(Double.MIN_VALUE);		
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)
            	if(get(row, col) < aux.get(row)) {            		
            		aux.set(row, get(row, col));            	    
            		C.set(row, col);            		            		
            	}    	    	    	    	
		return C;		
    }
	
	private Matrix rowargmin(Matrix C) {
		Matrix aux = new Matrix(numRows, 1);		
		aux.fill(Double.MIN_VALUE);
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	                    
            	if(get(row, col) < aux.get(col)) {            		
            		aux.set(col, get(row, col));            	    
            		C.set(col, row);            		            		
            	}    	    	    	           
		return C;		   	
    }
	
	public Matrix argmin(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		return rowargmin(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		return colargmin(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}     
	}
	
	public Matrix sigmoid(Matrix C){
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.min(get(pos), 1.0/(1.0 + Math.exp(-get(pos)))));		            	        
		return C;		
	}
	
	public Matrix sigmoidi(){
		return sigmoid(this);
	}
	
	public Matrix rand(){		
		for(int pos = 0 ; pos < data.length ; pos++)
			set(pos, Random.instance.nextDouble());
		return this;
	}
	
	public Matrix randnorm(){
		for(int pos = 0 ; pos < data.length ; pos++)
			set(pos, Random.instance.nextGaussian());
		return this;
	}
	
	public static Matrix rand(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.rand();
		return C;
	}
	
	public static Matrix randn(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.randnorm();
		return C;		
	}
	
	public static Matrix ones(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.one();
		return C;		
	}
	
	public static Matrix zeros(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		return C;		
	}
	
}
