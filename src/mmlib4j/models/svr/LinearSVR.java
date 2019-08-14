package mmlib4j.models.svr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.Models;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.preprocessing.Scaler;
import mmlib4j.models.preprocessing.ScalerFactory;

public class LinearSVR implements Models {
	
    private LinearRegressor regressor;
    private Matrix coefficients;
    private Matrix intercepts;
    private Scaler scaler;    
    
	public LinearSVR(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public LinearSVR(String modelData) {
		load(modelData);
	}
    
	public LinearSVR load(JsonObject jsonObject) {       	
		this.regressor = new Gson().fromJson(jsonObject, LinearRegressor.class);	      	    	
        coefficients = new Matrix(regressor.coefficients, 1, regressor.coefficients.length, false);
        intercepts   = new Matrix(regressor.intercepts, 1, 1, false);
        scaler = ScalerFactory.create(jsonObject);
        return this;
    }
    
    public LinearSVR load(String modelData) {    	
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
        return load(jsonObject);
    }    
    
    @Override
    public double predict(double[] data) {
		Matrix p = new Matrix(data, 1, data.length, true);
		return predict(p).get(0);
	}

    @Override
	public Matrix predict(Matrix x) {
    	return scaler.normalize(x).dotT(coefficients).plusi(intercepts);
	}
    
    public class LinearRegressor {
    	double coefficients[];
    	double intercepts[];  	
    }

}
