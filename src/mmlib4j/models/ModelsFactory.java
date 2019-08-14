package mmlib4j.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.linear.LinearRegression;
import mmlib4j.models.linear.LogisticRegression;
import mmlib4j.models.neural_network.MLP;
import mmlib4j.models.svm.LinearSVC;
import mmlib4j.models.svm.SVC;
import mmlib4j.models.svr.LinearSVR;

public class ModelsFactory {
	
	public static Models create(String modelData){
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
        return create(jsonObject);
	}	
	
	public static Models create(JsonObject jsonObject){
		Models model;
		String type = jsonObject.get("type").getAsString();    			
		if(type.contains("LinearSVC")) {
			model = new LinearSVC(jsonObject);
		} else if(type.contains("SVC")) {
			model = new SVC(jsonObject);
		} else if(type.contains("MLP")) {	
			model = new MLP(jsonObject);
		} else if(type.contains("LinearRegression")) {
			model = new LinearRegression(jsonObject);			
		} else if(type.contains("Logistic")) {
			model = new LogisticRegression(jsonObject);		
		} else if(type.contains("LinearSVR")) {
			model = new LinearSVR(jsonObject);
		}else if(type.contains("SVR")) {
			model = new SVC(jsonObject); 						
		} else {
			throw new InvalidParameterException("Model is not supported yet");
		}			
		return model;
	}
	
}
