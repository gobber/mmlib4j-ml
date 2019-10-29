package mmlib4j.models.linear;

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

public class LinearRegression implements Models {		 
		
	private Matrix coefficients;
	private Matrix intercept;
	private Regression regression;	
	private Scaler scaler;
	
	public LinearRegression(){}
	
	public LinearRegression(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public LinearRegression(String modelData) {
		load(modelData);
	}
	
	@Override
	public double predict(double[] data) {
		Matrix x = new Matrix(data, 1, data.length, false);		
		return scaler.normalize(x).dotT(coefficients).plusi(intercept).get(0);
	}
	
	@Override
	public Matrix predict(Matrix x){
		return scaler.normalize(x).dotT(coefficients).plusi(intercept);
	}

	public LinearRegression load(String modelData){
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
	
	public LinearRegression load(JsonObject jsonObject) {	
		regression = new Gson().fromJson(jsonObject, Regression.class);
		this.coefficients = new Matrix(regression.coefficients(), 1, regression.coefficients.length, false);
		this.intercept = new Matrix(regression.intercept(), 1, 1, false);
		this.scaler = ScalerFactory.create(jsonObject);		
		return this;
	}	
	
	private class Regression {
		double coefficients[];
		double intercept[];
		public double[] coefficients() {
			return coefficients;
		}
		public double[] intercept() {
			return intercept;
		}
		
	}
	
}
