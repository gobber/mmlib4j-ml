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
import mmlib4j.models.svm.kernels.Kernel;
import mmlib4j.models.svm.kernels.KernelFactory;

public class SVR implements Models {

	private Scaler scaler;	
	private Matrix vectors;
    private Matrix intercepts;
    private Matrix coefficients;    
    private Kernel K;
    private Regressor regressor;
    
    public SVR() {}
    
	public SVR(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public SVR(String modelData) {
		load(modelData);
	}
   
    public SVR load(String modelData){
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
    
	public SVR load(JsonObject jsonObject) {    	
    	regressor = new Gson().fromJson(jsonObject, Regressor.class);				                
        this.K = KernelFactory.create(regressor.kernel, regressor.gamma, regressor.degree, regressor.coef0);        
        this.vectors      = new Matrix(regressor.vectors, regressor.numRowsV, regressor.numColumnsV, false);        
        this.coefficients = new Matrix(regressor.coefficients, regressor.numRowsC, regressor.numColumnsC, false);        
        this.intercepts   = new Matrix(regressor.intercepts, regressor.intercepts.length, 1, false);        
        this.scaler = ScalerFactory.create(jsonObject);        
        return this;
    }
    
    public double predict(double[] data) {
		Matrix p = new Matrix(data, 1, data.length, true);
		return predict(p).get(0);    	
	}
    
	@Override
	public Matrix predict(Matrix x) {
		return K.trick(scaler.normalize(x), vectors).TdotT(coefficients).plusi(intercepts);    	    	
	}
	
	private class Regressor {
	    double[] vectors;
	    int numRowsV;
	    int numColumnsV;
	    double[] coefficients;
	    int numRowsC;
	    int numColumnsC;
	    double[] intercepts;
	    String kernel;
	    double gamma;
	    double coef0;
	    double degree;
	}

}
