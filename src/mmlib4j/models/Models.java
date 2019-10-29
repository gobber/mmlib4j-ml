package mmlib4j.models;

import com.google.gson.JsonObject;

import mmlib4j.models.datastruct.Matrix;

public interface Models {	
	public Models load(String modelData);
	public Models load(JsonObject jsonObject);
	public double predict(double[] data);	
	public Matrix predict(Matrix x); 
}
