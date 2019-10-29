package mmlib4j.models.neural_network;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mmlib4j.models.Models;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.neural_network.Layer;
import mmlib4j.models.postprocessing.PostProcessing;
import mmlib4j.models.postprocessing.PostProcessingBinary;
import mmlib4j.models.postprocessing.PostProcessingIdentity;
import mmlib4j.models.postprocessing.PostProcessingMulticlass;
import mmlib4j.models.preprocessing.Scaler;
import mmlib4j.models.preprocessing.ScalerFactory;
import mmlib4j.models.transfer.TransferFactory;

public class MLP implements Models {
	
	private PostProcessing post;
	private LinkedList<Layer> layers = new LinkedList<Layer>();
	private Scaler scaler;
	private Network net;
	
	public MLP(){}
	
	public MLP(JsonObject jsonObject) {
		load(jsonObject);
	}
	
	public MLP(String modelData) {
		load(modelData);
	}
	
	public MLP load(String modelData){
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
		
	public MLP load(JsonObject jsonObject){
		net = new Gson().fromJson(jsonObject, Network.class);	   	
		for(int l = 0 ; l < net.weights.length-1 ; l++) {
			layers.add(new Layer(TransferFactory.create(net.hidden_activation),
								new Matrix(net.weights[l], net.numRows[l], net.numColumns[l], false),
								new Matrix(net.bias[l], 1, net.bias[l].length, false)));
		}		
		layers.add(new Layer(TransferFactory.create(net.output_activation),
				  new Matrix(net.weights[net.weights.length-1], net.numRows[net.weights.length-1], net.numColumns[net.weights.length-1], false),
				  new Matrix(net.bias[net.weights.length-1], 1, net.bias[net.weights.length-1].length, false)));    	    					
		String type = jsonObject.get("type").getAsString();        
    	if(type.contains("MLPBinaryClassifier")) {
    		post = new PostProcessingBinary();
        }else if(type.contains("MLPMultiClassifier")) {
        	post = new PostProcessingMulticlass();
        } else if(type.contains("MLPRegressor")){        	
        	post = new PostProcessingIdentity();
        } else {
        	throw new IllegalArgumentException("Invalid model type");
        }       		
    	this.scaler = ScalerFactory.create(jsonObject);
        return this;
	}
	
	public double predict(double[] data) {
		Matrix x = new Matrix(data, 1, data.length, true);		
		return predict(x).get(0);
	}
	
	@Override
	public Matrix predict(Matrix x) {		
		Matrix a = scaler.normalize(x);
		Matrix z;			
		for(Layer layer : layers) {
			z = a.dot(layer.getWeigths()).plusi(layer.getBias());		
			a = layer.activate(z);		
		} 		
		return post.execute(a);		
	}	
	
	public class Network {
		private String hidden_activation;
	    private String output_activation;
	    private double[][] weights;        
	    private double[][] bias;
	    private int[] numRows;
	    private int[] numColumns;
	}
	
}


