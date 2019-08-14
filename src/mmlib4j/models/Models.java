package mmlib4j.models;

import mmlib4j.models.datastruct.Matrix;

public interface Models {	
	public double predict(double[] data);	
	public Matrix predict(Matrix x); 
}
