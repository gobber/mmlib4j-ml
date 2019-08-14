package mmlib4j.models.preprocessing;


import mmlib4j.models.datastruct.Matrix;

/**
 * 
 * <p> This interface is a model to normalization classes for the {@link Matrix} datastruct. </p>
 * 
 * @author Charles Ferreira Gobber
 * @version  0.0.1
 * @since  0.0.1
 * @see MinMax
 * @see Zscore 
 * @see Matrix  
 * 
 */

public interface Scaler {
	
	/**
	 * 	
	 *	@param matrix A Matrix
	 *	@return A matrix :math:`C` normalized. 
	 * 
	 */
	
	public Matrix normalize(Matrix A);
		
}
