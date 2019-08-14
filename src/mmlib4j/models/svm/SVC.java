package mmlib4j.models.svm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.Models;
import mmlib4j.models.datastruct.Matrix;

public class SVC implements Models {

	private SVC svc; 
	
	SVC(){}
	
	public SVC(JsonObject jsonObject) {
		load(jsonObject);
	}

	public SVC(String modelData) {
		load(modelData);
	}
	
	public SVC load(String modelData){
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
	
	public SVC load(JsonObject jsonObject) {		
		String type = jsonObject.get("type").getAsString();	
		if(type.contains("SVCBinary")) {
			svc = new BinarySVC(jsonObject);
        }else if(type.contains("SVCMulticlass")) {
        	svc = new MulticlassSVC(jsonObject);
        } else {
        	throw new IllegalArgumentException("Invalid model type");
        }       		
		return this;
	}
	
	public double predict(double[] data) {				
		return svc.predict(data);
	}
	
	@Override
	public Matrix predict(Matrix x) {
		return svc.predict(x);
	}	
	
}
