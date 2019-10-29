package mmlib4j.models.svm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.preprocessing.Scaler;
import mmlib4j.models.preprocessing.ScalerFactory;
import mmlib4j.models.svm.kernels.Kernel;
import mmlib4j.models.svm.kernels.KernelFactory;

public final class BinarySVC extends SVC {
	
	private Scaler scaler;	
	private Matrix vectors;
    private Matrix intercepts;
    private Matrix coefficients;    
    private Kernel K;
    private Classifier classifier;
    
    public BinarySVC() {}
	
	public BinarySVC(JsonObject jsonObject) {
		load(jsonObject);
	}
		
	public BinarySVC(String modelData) {
		load(modelData);
	}
    
    public BinarySVC load(String modelData){
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
    
	public BinarySVC load(JsonObject jsonObject) {    	
    	classifier = new Gson().fromJson(jsonObject, Classifier.class);			                
        this.K = KernelFactory.create(classifier.kernel, classifier.gamma, classifier.degree, classifier.coef0);        
        this.vectors      = new Matrix(classifier.vectors, classifier.numRowsV, classifier.numColumnsV, false);        
        this.coefficients = new Matrix(classifier.coefficients, classifier.numRowsC, classifier.numColumnsC, false);        
        this.intercepts   = new Matrix(classifier.intercepts, classifier.intercepts.length, 1, false);        
        this.scaler = ScalerFactory.create(jsonObject);        
        return this;
    }
    
    public double predict(double[] data) {
		Matrix p = new Matrix(data, 1, data.length, true);
		return predict(p).get(0);
	}
    
	@Override
	public Matrix predict(Matrix x) {
		return K.trick(scaler.normalize(x), vectors).TdotT(-1, coefficients).plusi(intercepts).lesstheni(0);    	
	}
	
	private class Classifier {
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
