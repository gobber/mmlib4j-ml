package mmlib4j.models.preprocessing;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.datastruct.Matrix;

public class Mean implements Scaler{
	
	private Statistics statistics;
	private Matrix mean;
	
	public Mean() {}
	
	public Mean(String modelData) {
		load(modelData);		
	}	
	
	public Mean(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public Mean(Matrix mean){
		this.mean = mean;
	}
	
	public Mean load(String modelData) {
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
	
	public Mean load(JsonObject jsonObject) {		
		this.statistics = new Gson().fromJson(jsonObject, Statistics.class);
        this.mean = new Matrix(statistics.mean, 1, statistics.mean.length, false);        
        return this;
	}
	
	@Override
	public Matrix normalize(Matrix x) {
		this.mean = this.mean == null ? x.mean(0) : this.mean;
		return x.minus(mean);
	}
	
	private class Statistics{
		double mean[];				
	}

}
