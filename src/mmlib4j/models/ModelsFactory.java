package mmlib4j.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.files.DataWriter;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.linear.LinearRegression;
import mmlib4j.models.linear.LogisticRegression;
import mmlib4j.models.neural_network.MLP;
import mmlib4j.models.svm.LinearSVC;
import mmlib4j.models.svm.SVC;
import mmlib4j.models.svr.LinearSVR;
import mmlib4j.models.svr.SVR;

public class ModelsFactory {
	
	private static final Map<String, Class<? extends Models>> registeredModels = new HashMap<String, Class<? extends Models>>();
	
	static {				
		registeredModels.put("LinearSVCBinary", LinearSVC.class);
		registeredModels.put("LinearSVCMulticlass", LinearSVC.class);				
		registeredModels.put("SVCBinary", SVC.class);
		registeredModels.put("SVCMulticlass", SVC.class);		
		registeredModels.put("MLPBinaryClassifier", MLP.class);
		registeredModels.put("MLPMultiClassifier", MLP.class);
		registeredModels.put("MLPRegressor", MLP.class);		
		registeredModels.put("LinearRegression", LinearRegression.class);		
		registeredModels.put("MultinomialLogisticRegression", LogisticRegression.class);
		registeredModels.put("BinaryLogistic", LogisticRegression.class);
		registeredModels.put("MulticlassLogistic", LogisticRegression.class);		
		registeredModels.put("LinearSVR", LinearSVR.class);		
		registeredModels.put("SVR", SVR.class);		
	}
	
	public static void register(String modelName, Class<? extends Models> modelClass) {
		registeredModels.put(modelName, modelClass);
	}
	
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
		Models model = null;
		String type = jsonObject.get("type").getAsString();
		try {
			model = registeredModels.get(type).getConstructor().newInstance();
			model.load(jsonObject);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}		
		return model;
	}
	
	public static void main(String args[]) {
		
		Models model = ModelsFactory.create("/Users/gobber/Desktop/temp/data.json");		
		Matrix x = new Matrix(new double[][] {{5.1, 3.5, 1.4, 0.2}, {5.1, 3.5, 1.4, 0.2}});
		
		model.predict(x).print();
		
		DataWriter dat = new DataWriter();
		dat.create("/Users/gobber/Desktop/matrix").write(x).close();
		
	}

}
