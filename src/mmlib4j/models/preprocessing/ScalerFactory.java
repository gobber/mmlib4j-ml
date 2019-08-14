package mmlib4j.models.preprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ScalerFactory {
	
	public static Scaler create(String modelData) {
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
	
	public static Scaler create(JsonObject jsonObject){
		Scaler scaler;
		String type = jsonObject.get("type").getAsString();		
		if(type.contains("ZscoreScaler")) {  
        	scaler = new Zscore(jsonObject);
        } else if(type.contains("StandardDeviationScaler")){
        	scaler = new StandardDeviation(jsonObject);        	
        } else if(type.contains("MeanScaler")) {
        	scaler = new Mean(jsonObject);
        }else if(type.contains("MinMaxScaler")){
        	scaler = new MinMax(jsonObject);
        } else {
        	scaler = new IdentityScaler();
        } 	
		return scaler; 
	}

}
