package mmlib4j.models.preprocessing;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import mmlib4j.models.datastruct.Matrix;


/**
 * 
 * <p> This class implements the zscore normalization for the {@link MatrixOld} datastruct. </p>
 * 
 * @author Charles Ferreira Gobber
 * @version  0.0.1
 * @since  0.0.1
 * @see Scaler 
 * @see Zscore
 * @see MatrixOld  
 * 
 */

public class Zscore implements Scaler {

	/**
	 * 
	 * 	<p>This method normalizes a given Matrix :math:`A` by zscore scaler. More formally, the 
	 * 	zscore normalization can be defined as follows: </p> 
	 * 
	 * 	.. math::
	 * 		
	 * 		\begin{aligned}
	 * 		C_{1c} = \frac{A_{1c} - \mu_{1c} }{ \sqrt{\frac{1}{m-1}\sum\limits_{r=1}^m (A_{rc} - \mu_{1c})^2 } }, c=1,\ldots,n,
	 * 		\end{aligned}	
	 *
	 * 	<p> where :math:`m` is the number of rows, :math:`n` is the number of columns of :math:`A` and :math:`\mu_{r1}` is the column mean of :math:`A`. </p>	 
	 * 
	 *	@param matrix A Matrix
	 *	@return A matrix :math:`C` normalized by zscore.
	 * 
	 */
	
	private Statistics statistics;
	private Matrix mean;
	private Matrix std;
	
	public Zscore(){}
	
	public Zscore(String modelData) {
		load(modelData);
	}	
	
	public Zscore(JsonObject jsonObject) {
		load(jsonObject);
	}		

	public Zscore(Matrix mean, Matrix std){
		this.mean = mean;
		this.std  = std;	
	}
	
	public Zscore load(String modelData) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(modelData));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	    
		String jsonStr = scanner.useDelimiter("\\Z").next(); 
        scanner.close();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonStr).getAsJsonObject();
        load(jsonObject);
        return this;
	}
	
	public Zscore load(JsonObject jsonObject) {		
		this.statistics = new Gson().fromJson(jsonObject, Statistics.class);			
        this.mean = new Matrix(statistics.mean, 1, statistics.mean.length, false);
        this.std = new Matrix(statistics.std, 1, statistics.std.length, false);        
        return this;
	}
	
	@Override
	public Matrix normalize(Matrix x) {		
		this.mean = this.mean == null ? x.mean(0)   : this.mean;
		this.std  = this.std  == null ? x.std(0, 1) : this.std;
		//x.minus(mean).divi(std).print();		
		return x.minus(mean).divi(std);				
	}
	
	private class Statistics {		
		double mean[];
		double std[];
	}
	
}
