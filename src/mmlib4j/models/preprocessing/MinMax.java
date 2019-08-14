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
 * <p> This class implements the min max normalization for the {@link Matrix} datastruct. </p>
 * 
 * @author Charles Ferreira Gobber
 * @version  0.0.1
 * @since  0.0.1
 * @see Scaler 
 * @see Zscore
 * @see Matrix  
 * 
 */

public class MinMax implements Scaler{

	/**
	 * 
	 * 	<p>This method normalizes a given Matrix :math:`A` by min max scaler. More formally, the 
	 * 	min max normalization can be defined as follows: </p> 
	 * 
	 * 	.. math::
	 * 		
	 * 		\begin{aligned}
	 * 		C_{1c} = \frac{A_{1c} - \min\limits_{r=1, \ldots, m}\{A_{rc}\}}{ \max\limits_{r=1, \ldots, m}\{A_{rc}\} - \min\limits_{r=1, \ldots, m}\{A_{rc}\}}, c=1,\ldots,n,
	 * 		\end{aligned} 		
	 *
	 * 	<p> where :math:`m` is the number of rows and :math:`n` is the number of columns of :math:`A`. </p>	 
	 * 
	 *	@param matrix A Matrix
	 *	@return A matrix :math:`C` normalized by min max.
	 * 
	 */
	
	private Matrix min;
	private Matrix max;
	
	private Statistics statistics;
	
	public MinMax(Matrix min, Matrix max) {
		this.min = min;
		this.max = max;
	}
	
	public MinMax() {}
	
	public MinMax(String modelData) {	
		load(modelData);
	}	
	
	public MinMax(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public MinMax load(String modelData) {
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
	
	public MinMax load(JsonObject jsonObject) {	   			
		this.statistics = new Gson().fromJson(jsonObject, Statistics.class);			
		this.min = new Matrix(statistics.min, 1, statistics.min.length, false);		
        this.max = new Matrix(statistics.max, 1, statistics.max.length, false);        
        return this;        
	}	
		
	@Override
	public Matrix normalize(Matrix x) {				
		this.min = this.min == null ? x.min(0) : this.min;
		this.max = this.max == null ? x.max(0) : this.max;	
		//Matrix z = x.minus(min).divi(max.minus(min));		
		/*if(statistics.upper != 1 && statistics.lower != 0) {
			z.muli(statistics.upper-statistics.lower).plusi(statistics.lower);
		}*/		
		return x.minus(min).divi(max.minus(min));
	}

	private class Statistics {		
		double max[];
		double min[];		
	}
	
}
