package mmlib4j.models.datastruct;

import com.github.fommil.netlib.BLAS;


/**
 * 
 * <p> This class is a wrapper to some netlib BLAS methods.</p>
 * 
 * @author Charles Ferreira Gobber
 * @version  0.0.1
 * @since  0.0.1 
 * @see BLAS
 * 
 */

public class SimpleBlas {
    
    /**
	 * 
	 * 	<p> This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		C=\alpha A * B + C
	 * 
	 * 	<p> where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, 
	 * 		if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the 
	 * 		we have :math:`C=A * B`. </p>
	 * 
	 *  @param alpha A float scalar.
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *  @param  C A matrix of type double[].
	 *	@return A matrix :math:`C=\alpha A * B + C`.
	 * 
	 * */
    
    public static Matrix multAdd(double alpha, Matrix A, Matrix B, Matrix C) {       

        double[] Ad = A.getData(), Bd = B.getData(), Cd = C.getData();

        BLAS.getInstance().dgemm("N","N", C.numRows(), C.numColumns(),
                A.numColumns(), alpha, Ad, Math.max(1, A.numRows()), Bd,
                Math.max(1, B.numRows()), 1, Cd, Math.max(1, C.numRows()));

        return C;
    }
    
    /**
	 * 
	 * 	<p> This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		C=\alpha A^T * B + C
	 * 
	 * 	<p> where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, 
	 * 		if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the 
	 * 		we have :math:`C=A^T * B`. </p>
	 * 
	 *  @param alpha A float scalar.
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *  @param  C A matrix of type double[].
	 *	@return A matrix :math:`C=\alpha A^T * B + C`.
	 * 
	 * */
    
    public static Matrix transAmultAdd(double alpha, Matrix A, Matrix B, Matrix C) {

        double[] Ad = A.getData(), Bd = B.getData(), Cd = C.getData();

        BLAS.getInstance().dgemm("T", "N", C.numRows(), C.numColumns(),
                A.numRows(), alpha, Ad, Math.max(1, A.numRows()), Bd,
                Math.max(1, B.numRows()), 1, Cd, Math.max(1, C.numRows()));

        return C;
    }
    
    /**
	 * 
	 * 	<p> This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		C=\alpha A * B^T + C
	 * 
	 * 	<p> where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, 
	 * 		if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the 
	 * 		we have :math:`C=A * B^T`. </p>
	 * 
	 *  @param alpha A float scalar.
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *  @param  C A matrix of type double[].
	 *	@return A matrix :math:`C=\alpha A * B^T + C`.
	 * 
	 * */
    
    public static Matrix transBmultAdd(double alpha, Matrix A, Matrix B, Matrix C) {

        double[] Ad = A.getData(), Bd = B.getData(), Cd = C.getData();

        BLAS.getInstance().dgemm("N", "T", C.numRows(), C.numColumns(),
                A.numColumns(), alpha, Ad, Math.max(1, A.numRows()), Bd,
                Math.max(1, B.numRows()), 1, Cd, Math.max(1, C.numRows()));

        return C;
    }  
    
    /**
	 * 
	 * 	<p> This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		C=\alpha A^T * B^T + C
	 * 
	 * 	<p> where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, 
	 * 		if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the 
	 * 		we have :math:`C=A^T * B^T`. </p>
	 * 
	 *  @param alpha A float scalar.
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *  @param  C A matrix of type double[].
	 *	@return A matrix :math:`C=\alpha A^T * B^T + C`.
	 * 
	 * */
    
    public static Matrix transABmultAdd(double alpha, Matrix A, Matrix B, Matrix C) {

        double[] Ad = A.getData(), Bd = B.getData(), Cd = C.getData();

        BLAS.getInstance().dgemm("T", "T", C.numRows(), C.numColumns(),
                A.numRows(), alpha, Ad, Math.max(1, A.numRows()), Bd,
                Math.max(1, B.numRows()), 1, Cd, Math.max(1, C.numRows()));

        return C;
    }
    
    /**
	 * 
	 * 	<p> This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		A = A + B
	 * 
	 * 	<p>Observation: This operation overwrites the matrix :math:`A`.</p>
	 * 
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *	@return A matrix :math:`A = A + B`.
	 * 
	 * */
    
    public static Matrix plus(Matrix A, Matrix B) {    	
    	BLAS.getInstance().daxpy(A.numRows()*A.numColumns(), 1, B.getData(), 0, 1, A.getData(), 0, 1);
    	return A;    	
    }      
    
    /**
	 * 
	 * 	<p> This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. 
	 * Thus, this operation performs: </p>
	 * 
	 * 	.. math::
	 * 
	 * 		A = A - B.
	 * 
	 * 	<p>Observation: This operation overwrites the matrix :math:`A`.</p>
	 * 
	 *	@param  A A matrix of type double[].
	 *  @param  B A matrix of type double[].
	 *	@return A matrix :math:`A = A - B`.
	 * 
	 * */
    
    public static Matrix minus(Matrix A, Matrix B) {       	
    	BLAS.getInstance().daxpy(A.numRows()*A.numColumns(), -1, B.getData(), 0, 1, A.getData(), 0, 1);
    	return A;    	
    }
    
}
