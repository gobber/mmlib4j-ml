package mmlib4j.models.linear;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.Models;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.postprocessing.PostProcessing;
import mmlib4j.models.postprocessing.PostProcessingBinary;
import mmlib4j.models.postprocessing.PostProcessingMulticlass;
import mmlib4j.models.preprocessing.Scaler;
import mmlib4j.models.preprocessing.ScalerFactory;
import mmlib4j.models.transfer.Logistic;
import mmlib4j.models.transfer.Softmax;
import mmlib4j.models.transfer.Transfer;

public class LogisticRegression implements Models {
		
	private PostProcessing post;
	private Classifier classifier;		
	private Matrix coefficients;	
	private Matrix intercept;
	private Transfer transfer;
	private Scaler scaler;
	
	public LogisticRegression(JsonObject jsonObject) {
		load(jsonObject);
	}
		
	public LogisticRegression(String modelData) {
		load(modelData);
	}
	
	public LogisticRegression load(String modelData){
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
	
	public LogisticRegression load(JsonObject jsonObject){		
		classifier =  new Gson().fromJson(jsonObject, Classifier.class);		            
        this.coefficients = new Matrix(classifier.coefficients, classifier.numRows, classifier.numColumns, false);        
        this.intercept = new Matrix(classifier.intercepts, 1, classifier.intercepts.length, false);        
        this.scaler = ScalerFactory.create(jsonObject);        
		String type = jsonObject.get("type").getAsString();		
    	if(type.contains("MultinomialLogistic")) {
    		post = new PostProcessingMulticlass();
    		transfer = new Softmax();
        }else if(type.contains("BinaryLogistic")) {
        	post = new PostProcessingBinary();
        	transfer = new Logistic();
        } else if(type.contains("MulticlassLogistic")){
        	post = new PostProcessingMulticlass();
        	transfer = new Logistic();
        } else {
        	throw new IllegalArgumentException("Invalid model type");
        }     	
    	return this;
	}
	
	public Matrix probability(Matrix x) {
		return transfer.activate(scaler.normalize(x).dotT(coefficients).plusi(intercept));
	}
	
	@Override
	public double predict(double[] data) {
		Matrix x = new Matrix(data, 1, data.length, true);
		return post.execute(transfer.activate(scaler.normalize(x).dotT(coefficients).plusi(intercept))).get(0);
	}
	
	@Override
	public Matrix predict(Matrix x) {				
		return post.execute(transfer.activate(scaler.normalize(x).dotT(coefficients).plusi(intercept)));		
	}
	
	public class Classifier {
		double coefficients[];
		double intercepts[];
		int numRows;
		int numColumns;
	}

}
