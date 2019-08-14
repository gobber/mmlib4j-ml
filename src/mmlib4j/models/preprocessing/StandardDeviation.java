package mmlib4j.models.preprocessing;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.datastruct.Matrix;

public final class StandardDeviation implements Scaler {
	
	private Statistics statistics;
	private Matrix std;
	
	public StandardDeviation(){}
	
	public StandardDeviation(String modelData) {
		load(modelData);
	}	
	
	public StandardDeviation(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public StandardDeviation(Matrix std){
		this.std = std;
	}

	public StandardDeviation load(String modelData) {
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
	
	public StandardDeviation load(JsonObject jsonObject) {			
		this.statistics = new Gson().fromJson(jsonObject, Statistics.class);
        this.std = new Matrix(statistics.std, 1, statistics.std.length, false);        
        return this;
	}
	
	@Override
	public Matrix normalize(Matrix x) {
		this.std = this.std  == null ? x.std(0, 1) : this.std;
		return x.div(std);
	}
	
	private class Statistics {
		double std[];	
	}
	
}
