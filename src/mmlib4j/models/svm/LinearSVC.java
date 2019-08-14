package mmlib4j.models.svm;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.Models;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.postprocessing.PostProcessing;
import mmlib4j.models.postprocessing.PostProcessingLinear;
import mmlib4j.models.postprocessing.PostProcessingMulticlass;
import mmlib4j.models.preprocessing.Scaler;
import mmlib4j.models.preprocessing.ScalerFactory;

public class LinearSVC implements Models {		
    
    private LinearClassifier classifier;
    private PostProcessing post;
    private Matrix coefficients;
    private Matrix intercepts;
    private Scaler scaler;    
    
	public LinearSVC(JsonObject jsonObject) {
		load(jsonObject);
	}
		
	public LinearSVC(String modelData) {
		load(modelData);
	}
	
	public LinearSVC load(JsonObject jsonObject) {       	
		this.classifier = new Gson().fromJson(jsonObject, LinearClassifier.class);    	    	
        coefficients = new Matrix(classifier.coefficients, classifier.numRowsC, classifier.numColumnsC, false);
        intercepts   = new Matrix(classifier.intercepts, 1, classifier.intercepts.length, false);
        scaler = ScalerFactory.create(jsonObject);              
        String type = jsonObject.get("type").getAsString();        
        if(type.contains("LinearSVCBinary")) {
        	post = new PostProcessingLinear();
        }else if(type.contains("LinearSVCMulticlass")) {
        	post = new PostProcessingMulticlass();
        } else {
        	throw new IllegalArgumentException("Invalid model type");
        }  
        
        return this;
    }
    
    public LinearSVC load(String modelData) {    	
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
    
    public double predict(double[] data) {
		Matrix p = new Matrix(data, 1, data.length, true);
		return predict(p).get(0);	
	}

    @Override
	public Matrix predict(Matrix x) {    	
    	return post.execute(scaler.normalize(x).dotT(coefficients).plusi(intercepts));
	}
    
    public class LinearClassifier {    	
    	double coefficients[];
    	double intercepts[];
    	int numRowsC;
    	int numColumnsC;    	    	
    }
    
}
