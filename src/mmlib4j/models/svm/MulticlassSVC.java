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

public class MulticlassSVC extends SVC {

	private Classifier classifier;
	private Matrix vectors;
	private Matrix coefficients;
	private Scaler scaler;	
	private Kernel K;
	private Matrix intercepts;
	private int[] classes;
	
	public MulticlassSVC(JsonObject jsonObject) {
		load(jsonObject);
	}
		
	public MulticlassSVC(String modelData) {
		load(modelData);
	}
	
	public MulticlassSVC load(JsonObject jsonObject) {    	
		classifier = new Gson().fromJson(jsonObject, Classifier.class);		
        classes = new int[classifier.nClasses];        
        for (int i = 0; i < classifier.nClasses; i++) {
            classes[i] = i;
        }                
        K =  KernelFactory.create(classifier.kernel, classifier.gamma, classifier.degree, classifier.coef0);        
        vectors      = new Matrix(classifier.vectors, classifier.numRowsV, classifier.numColumnsV, false);	
        coefficients = new Matrix(classifier.coefficients, classifier.numRowsC, classifier.numColumnsC, false);
        intercepts   = new Matrix(classifier.intercepts, classifier.intercepts.length, 1, false);
        scaler = ScalerFactory.create(jsonObject);   
        return this;
    }
    
    public MulticlassSVC load(String modelData) {    	
    	Scanner scanner = null;
		try {
			scanner = new Scanner(new File(modelData));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		String jsonStr = scanner.useDelimiter("\\Z").next();   	
		JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonStr).getAsJsonObject(); 		
		load(jsonObject);
        return this;
    }
    
    @Override
    public double predict(double[] data) {
    	Matrix x = new Matrix(data, 1, data.length, true);	
		return predict(x).get(0);
	}
    
	@Override
	public Matrix predict(Matrix x) {
		Matrix predict = new Matrix(x.numRows(), 1);
		Matrix trick = K.trick(scaler.normalize(x), vectors);		
		int p = 0;    	
		for(int col = 0; col < trick.numColumns() ; col++) {
		int[] starts = new int[classifier.nRows];
			for (int i = 1; i < classifier.nRows; i++) {
				int start = 0;
				for (int j = 0; j < i; j++) {
					start += classifier.weights[j];
				}
				starts[i] = start;            
			}
			int[] ends = new int[classifier.nRows];
			for (int i = 0; i < classifier.nRows; i++) {
				ends[i] = classifier.weights[i] + starts[i];
			}      

			int[] histogram = new int[classifier.nClasses];
			for (int i = 0, d = 0, l = classifier.nRows; i < l; i++) {
				for (int j = i + 1; j < l; j++) {
					double tmp = 0.0;
					for (int k = starts[j]; k < ends[j]; k++) {	                		                	
						tmp += coefficients.get(i, k) * trick.get(k, col);	                   	                   
					}
					for (int k = starts[i]; k < ends[i]; k++) {	                		                	
						tmp += coefficients.get((j-1), k)  * trick.get(k, col);	                    	                    
					}   	                	                
					histogram[tmp + intercepts.get(d) > 0 ? i : j] += 1;	               
					d++;
				}
			}    
			int classVal = -1, classIdx = -1;
			for (int i = 0, l = histogram.length; i < l; i++) {
				if (histogram[i] > classVal) {
					classVal = histogram[i];
					classIdx = i;
				}
			}	        
			predict.getData()[p] = classes[classIdx];
			p++;	        
		}
		return predict;
		
	}
	
	private class Classifier {
		int nClasses;
	    int nRows;
	    double[] vectors;
	    int numRowsV;
	    int numColumnsV;
	    double[] coefficients;
	    int numRowsC;
	    int numColumnsC;
	    double[] intercepts;       
	    int[] weights;
	    String kernel;
	    double gamma;
	    double coef0;
	    double degree;
	}
	
}
