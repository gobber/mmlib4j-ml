package mmlib4j.models.datastruct;

import java.util.Arrays;

import mmlib4j.options.Options;
import mmlib4j.utils.Random;

public class Matrix {
	
	private double data[];
	private int numRows;
	private int numColumns;
	private String separator = ";";
	
	public Matrix (int numRows, int numColumns)	{			
		this.data = new double[numRows * numColumns];			
		this.numRows = numRows;
		this.numColumns = numColumns;
	}
	
	public Matrix (double values[], int numRows, int numColumns) {
		this(values, numRows, numColumns, false);
	}
	
	public Matrix (double[] values, int numRows, int numColumns, boolean deep) {
		this.numRows = numRows;
		this.numColumns = numColumns;	
		if(deep)
			data = values.clone();
		else
			data = values;				
	}
	
	public Matrix (double values[][]) {		
		this.numRows = values.length;
		this.numColumns = values[0].length;
		this.data = new double[this.numRows * this.numColumns];		
		for (int row = 0; row < numRows; row++) 
		       for (int col = 0; col < numColumns; col++)
		    	   this.data[row + col * numRows] = values[row][col];		
	}
	
	public boolean isScalar() {
		return numRows*numColumns == 1;
	}
	
	public boolean isRowVector() {
		return numRows == 1 && numColumns!=1;
	}
	
	public boolean isColVector() {
		return numColumns == 1 && numRows != 1;
	}
	
	public boolean isMatrix() {
		return !isRowVector() && !isColVector();
	}
	
	public String shape() {
		return "("+numRows + ","+ numColumns + ")";
	}
	
	public String getSeparator() {
		return separator;
	}
	
	public void setSeparator(String separator) {
		this.separator = separator;	
	}
	
	public double get(int pos) {
		return data[pos];
	}
	
	public void set(int pos, double value) {
		data[pos] = value;
	} 
	
	public double get(int row, int col) {
		return data[row + col * numRows];
	}
	
	public void set(int row, int col, double value) {
		data[row + col * numRows] = value;
	} 
	
	public void plus(int row, int col, double value) {
		data[row + col * numRows] += value;
	}
	
	public void mul(int row, int col, double value) {
		data[row + col * numRows] *= value;
	}
	
	public void minus(int row, int col, double value) {
		data[row + col * numRows] -= value;
	}
	
	public void div(int row, int col, double value) {
		data[row + col * numRows] /= value;
	}
	
	public void pow2(int row, int col) {
		data[row + col * numRows] *= data[row + col * numRows];
	}
	
	public void neg(int row, int col) {
		data[row + col * numRows] *= -1;
	}
	
	public void plus(int pos, double value) {
		data[pos] += value;
	}
	
	public void mul(int pos, double value) {
		data[pos] *= value;
	}
	
	public void minus(int pos, double value) {
		data[pos] -= value;
	}
	
	public void div(int pos, double value) {
		data[pos] /= value;
	}
	
	public void pow2(int pos) {
		data[pos] *= data[pos];
	}
	
	public void neg(int pos) {
		data[pos] *= -1;
	}
	
	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	public int numRows() {
		return numRows;
	}

	public void numRows(int numRows) {
		this.numRows = numRows;
	}

	public int numColumns() {
		return numColumns;
	}

	public void numColumns(int numColumns) {
		this.numColumns = numColumns;
	}
	
	public void print() {
		for(int row = 0 ; row < numRows ; row++) {
  			for(int col = 0 ; col < numColumns ; col++) {
  				System.out.printf("[%e] ", get(row, col));
  			}    		
  			System.out.println();
  		}   	
	}
	
	public Matrix fill(double value){
		Arrays.fill(data, value);
		return this;
	}
	
	public Matrix copy(){
		Matrix copy = new Matrix(data, numRows, numColumns, true);
		return copy;
	}
	
	public void head(int numRows, int numColumns, String format) {
		numRows = numRows       > this.numRows    ? this.numRows    : numRows;
		numColumns = numColumns > this.numColumns ? this.numColumns : numColumns;	
		for(int row = 0 ; row < numRows ; row++) { 
			for(int col= 0 ; col < numColumns ; col++)
				System.out.format(format, get(row, col));
			System.out.println();			
		}	
	}
	
	public void head(int numRows, int numColumns) {
		head(numRows, numColumns, "%e");
	}
	
	public void head() {
		head(6, 7);
	}
	
	public Matrix one(){
		fill(1);
		return this;
	}
	
	public Matrix zero(){
		fill(0);
		return this;
	}	
	
	public String toString() {
		String out = "";					
		for(int row = 0 ; row < numRows ; row++)
			for(int col = 0 ; col < numColumns ; col++)
				out += get(row, col) + separator;						
		return out.substring(0, out.length()-1);	
	}
	
	public int length() {
		return data.length;
	}
	
	public Matrix row(int row){
		Matrix C = new Matrix(1, numColumns);		
		return row(row, C);
	}
	
	public Matrix row(int row, Matrix C){
		for (int col = 0; col < numColumns; col++)
			C.set(0, col, get(row, col));
		return C;
	}
	
	public Matrix column(int column){
		Matrix C = new Matrix(numRows, 1);		
		return column(column, C);
	}
	
	public Matrix column(int column, Matrix C){
		for (int row = 0; row < numRows; row++)
			C.set(row, 0, get(row, column));
		return C;
	}
	
	public Matrix biggerthen(double t) {	
		Matrix C = new Matrix(numRows, numColumns);
		return biggerthen(t, C);
	}
	
	public Matrix biggerthen(double t, Matrix C) {		
		for (int pos = 0; pos < data.length; pos++) 
	        if(get(pos) > t)
	        	C.set(pos, 1);
	        else
	        	C.set(pos, 0);
		return C;
	}
	
	public Matrix biggertheni(double t){
		return biggerthen(t, this);
	}
	
	public Matrix lessthen(double t){
		Matrix C = new Matrix(numRows, numColumns);
		return lessthen(t, C);
	}
	
	public Matrix lessthen(double t, Matrix C){
		for (int pos = 0; pos < data.length; pos++) 
	        if(get(pos) < t)
	        	C.set(pos, 1);
	        else
	        	C.set(pos, 0);
		return C;
	}
	
	public Matrix lesstheni(double t){
		return lessthen(t, this);
	}
	
	public Matrix sum() {
		return Options.operations.sum(this);
	}
	
	public Matrix sum(int axis) {
		return Options.operations.sum(this, axis);
	}	
	
	public Matrix sum(int axis, Matrix C) {
		return Options.operations.sum(this, axis, C);
	}
		
	public Matrix T() {
		Matrix C = new Matrix(numColumns, numRows);
		return T(C);
	}
	
	public Matrix T(Matrix C){
		for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	
            	C.set(col, row, get(row, col)); 		
		return C;	
	}
	
	public Matrix muli(Matrix B){
		if(B.isScalar()) {
			return mul(B.get(0), this);
		}		
		return mul(B, this);
	}
	
	public Matrix muli(double value){
		return mul(value);
	}
	
	private Matrix mul_inrow(Matrix B, Matrix C){
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)		
				C.set(row, col, get(row, col) * B.get(col));
		return C;
	}
	
	private Matrix mul_incol(Matrix B, Matrix C){
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)		
				C.set(row, col, get(row, col) * B.get(row));
		return C;
	}
	
	public Matrix mul(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return mul_inrow(B, C);
		} else if(B.isColVector()){
			return mul_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) * B.get(pos));							
			return C;
		}
	}
	
	public Matrix mul(Matrix B){
		Matrix C = new Matrix(numRows, numColumns);
		if(B.isScalar()) {
			return mul(B.get(0), C);
		}		
		return mul(B, C);
	}
	
	public Matrix mul(double value){
		Matrix C = new Matrix(numRows, numColumns);   			       
		return mul(value, C); 
	}
	
	public Matrix mul(double value, Matrix C){		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) * value);						
		return C;
	}

	public Matrix plus(Matrix B){
		if(B.isScalar()) {
			return plus(B.get(0), B);
		}   
		return Options.operations.plus(this, B);
	}
	
	public Matrix plusi(Matrix B){
		if(B.isScalar()) {
			return plus(B.get(0), this);
		}    		
		return Options.operations.plusi(this, B);
	}
	
	public Matrix plusi(double value){   			       
		return plus(value, this); 
	}
	
	private Matrix plus_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) + B.get(col));
		return C;
	}
	
	private Matrix plus_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) + B.get(row));
		return C;
	}
	
	public Matrix plus(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return plus_inrow(B, C);
		} else if(B.isColVector()){
			return plus_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) + B.get(pos));  							
			return C;
		}
	}
	
	public Matrix plus(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return plus(value, C);
	}
	
	public Matrix plus(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) + value);							
		return C;
	}		
	
	public Matrix minus(Matrix B){
		return Options.operations.minus(this, B);
	}
	
	public Matrix minusi(Matrix B){
		if(B.isScalar()) {
			return minus(B.get(0), this);
		}		
		return Options.operations.minusi(this, B);
	}
	
	public Matrix minusi(double value){
		return minus(value, this);
	}
	
	private Matrix minus_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) - B.get(col));
		return C;
	}
	
	private Matrix minus_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) - B.get(row));
		return C;
	}
	
	public Matrix minus(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return minus_inrow(B, C);
		} else if(B.isColVector()){
			return minus_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) - B.get(pos));  							
			return C;
		}
	}
	
	public Matrix minus(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return minus(value, C);
	}
	
	public Matrix minus(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) - value);  							
		return C;
	}	
	
	public Matrix divi(double value){		
		return div(value, this);	
	}
	
	public Matrix divi(Matrix B){
		if(B.isScalar()) {
			return div(B.get(0), this);
		}    		
		return div(B, this);
	}
	
	private Matrix div_inrow(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) / B.get(col));
		return C;
	}
	
	private Matrix div_incol(Matrix B, Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, col, get(row, col) / B.get(row));
		return C;
	}
	
	public Matrix div(Matrix B, Matrix C){
		if(B.isRowVector()) {
			return div_inrow(B, C);
		} else if(B.isColVector()){
			return div_incol(B, C);
		} else {		
			for (int pos = 0; pos < numRows*numColumns; pos++) 		
				C.set(pos, get(pos) / B.get(pos));  							
			return C;
		}
	}
	
	public Matrix div(Matrix B){
		Matrix C = new Matrix(numRows, numColumns);
		if(B.isScalar()) {
			return div(B.get(0), C);
		}
		return div(B, C);
	}
	
	public Matrix div(double value){
		Matrix C = new Matrix(numRows, numColumns);
		return div(value, C);
	}
	
	public Matrix div(double value, Matrix C){
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(pos, get(pos) / value);						
		return C;				
	}

	public Matrix dot(Matrix B){
		return Options.operations.dot(this, B);
	}
	
	public Matrix dot(Matrix B, Matrix C){
		return Options.operations.dot(this, B, C);
	}
	
	public Matrix dot(double value, Matrix B){
		return Options.operations.dot(value, this, B);
	}
	
	public Matrix dot(double value, Matrix B, Matrix C){
		return Options.operations.dot(value, this, B, C);
	}

	public Matrix Tdot(Matrix B){
		return Options.operations.Tdot(this, B);
	}
	
	public Matrix Tdot(Matrix B, Matrix C){
		return Options.operations.Tdot(this, B, C);
	}
	
	public Matrix Tdot(double value, Matrix B){
		return Options.operations.Tdot(value, this, B);
	}
	
	public Matrix Tdot(double value, Matrix B, Matrix C){
		return Options.operations.Tdot(value, this, B, C);
	}	
	
	public Matrix dotT(Matrix B){
		return Options.operations.dotT(this, B);
	}
	
	public Matrix dotT(Matrix B, Matrix C){
		return Options.operations.dotT(this, B, C);
	}
	
	public Matrix dotT(double value, Matrix B){
		return Options.operations.dotT(value, this, B);
	}
	
	public Matrix dotT(double value, Matrix B, Matrix C){
		return Options.operations.dotT(value, this, B, C);
	}
	
	public Matrix TdotT(Matrix B){
		return Options.operations.TdotT(this, B);
	}
	
	public Matrix TdotT(Matrix B, Matrix C){
		return Options.operations.TdotT(this, B, C);
	}
	
	public Matrix TdotT(double value, Matrix B){
		return Options.operations.TdotT(value, this, B);
	}
	
	public Matrix TdotT(double value, Matrix B, Matrix C){
		return Options.operations.TdotT(value, this, B, C);
	}

	public Matrix negi(){
		return neg(this);
	}
	
	public Matrix neg(){
		Matrix C = new Matrix(numRows, numColumns);
		return neg(C);
	}
	
	public Matrix neg(Matrix C){		
		for (int pos = 0; pos < data.length; pos++)
			C.set(pos, -get(pos));
		return C;
	}
	
	public Matrix mean(){
		return Options.operations.mean(this);
	}
	
	public Matrix mean(int axis, Matrix C){
		return JavaOperations.instance.mean(axis, this, C);
	}
	
	public Matrix mean(int axis){
		return Options.operations.mean(this, axis);
	}	
	
	public Matrix pow2i(){
		return pow2(this);
	}
	
	public Matrix pow2(){
		Matrix C = new Matrix(numRows, numColumns);
		return pow2(C);
	}
	
	public Matrix pow2(Matrix C) {
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, get(pos) * get(pos));		
		return C;
	}
	
	public Matrix powi(double exponent){
		return pow(exponent, this);
	}
	
	public Matrix pow(double exponent){
		Matrix C = new Matrix(numRows, numColumns);
		return pow(exponent, C);
	}
	
	public Matrix pow(double exponent, Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.pow(get(pos), exponent));		
		return C;
	}
	
	public Matrix sqrti(){
		return sqrt(this);
	}
	
	public Matrix sqrt(){
		Matrix C = new Matrix(numRows, numColumns);
		return sqrt(C);
	}
	
	public Matrix sqrt(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.sqrt(get(pos)));		
		return C;			
	}
	
	public Matrix expi(){
		return exp(this);
	}
		
	public Matrix exp(){
		Matrix C = new Matrix(numRows, numColumns);
		return exp(C);
	}
	
	public Matrix exp(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.exp(get(pos)));		
		return C;
	}
	
	public Matrix tanhi(){
		return tanh(this);
	}
	
	public Matrix tanh(){
		Matrix C = new Matrix(numRows, numColumns);
		return tanh(C);
	}
	
	public Matrix tanh(Matrix C){
		for (int pos = 0 ; pos < data.length ; pos++)
			C.set(pos, Math.tanh(get(pos)));		
		return C;			
	}
	
	private Matrix var(int axis, int div, int d, Matrix C) {		
		Matrix mean = mean(axis);
		Matrix aux  = minus(mean, C).powi(2);
		mean.zero();		
		aux.sum(axis, mean);
		return mean.divi(div-d);
	}
	
	public Matrix var(int axis, int d){
		Matrix C = new Matrix(numRows, numColumns);
		if(axis == 0) {    		
    		return var(axis, numRows, d, C);    		
    	}else if(axis == 1){    		
    		return var(axis, numColumns, d, C);    		
    	}else {
			throw new IllegalArgumentException("Invalid axis");
		}    	
	}
	
	private Matrix std(int axis, int div, int d, Matrix C) {				
		Matrix var = var(axis, div, d, C);	
		return var.sqrti();				
	} 
	
	public Matrix std(int axis, int d){
		Matrix C = new Matrix(numRows, numColumns);
		if(axis == 0) {
    		return std(axis, numRows, d, C);    		
    	}else if(axis == 1){
    		return std(axis, numColumns, d, C);    	
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}    	 
	}
	
	private Matrix max_inrow(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(col, Math.max(get(row, col), C.get(col)));
		return C;
	}
	
	private Matrix max_incol(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, Math.max(get(row, col), C.get(row)));
		return C;
	}
	
	private Matrix max(Matrix C){		
		if(C.isRowVector()) {
			return max_inrow(C);
		} else if(C.isColVector()){
			return max_incol(C);
		}		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(0, Math.max(C.get(0), get(pos)));	                      
		return C;    	
	}
	
	public Matrix max(){
		Matrix C = new Matrix(1, 1);
		C.fill(Double.MIN_VALUE);
		return max(C);
	}
	
	public Matrix max(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		C.fill(Double.MIN_VALUE);
    		return max_inrow(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		C.fill(Double.MIN_VALUE);
    		return max_incol(C);	
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}       	
	}
	
	public Matrix max(double value, Matrix C){		
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.max(get(pos), value));		            	        
		return C;		
	}
	
	public Matrix maxi(double value){
		return max(value, this);
	}	
	
	private Matrix min_inrow(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(col, Math.min(get(row, col), C.get(col)));
		return C;
	}
	
	private Matrix min_incol(Matrix C) {
		for (int row = 0; row < numRows; row++) 
			for (int col = 0; col < numColumns; col++)	
				C.set(row, Math.min(get(row, col), C.get(row)));
		return C;
	}
	
	private Matrix min(Matrix C){		
		if(C.isRowVector()) {
			return min_inrow(C);
		} else if(C.isColVector()){
			return min_incol(C);
		}		
		for(int pos = 0 ; pos < numRows*numColumns ; pos++)
			C.set(0, Math.min(C.get(0), get(pos)));                      
		return C;    	
	}
	
	public Matrix min(){
		Matrix C = new Matrix(1, 1);
		C.fill(Double.MAX_VALUE);
		return min(C);
	}
	
	public Matrix min(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		C.fill(Double.MAX_VALUE);
    		return min_inrow(C);  		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		C.fill(Double.MAX_VALUE);
    		return min_incol(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}       	
	}
	
	public Matrix min(double value, Matrix C){
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.min(get(pos), value));		            	        
		return C;		
	}
	
	private Matrix colargmax(Matrix C) {		
		Matrix aux = new Matrix(numRows, 1);		
		aux.fill(Double.MIN_VALUE);		
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)
            	if(get(row, col) > aux.get(row)) {            		
            		aux.set(row, get(row, col));            	    
            		C.set(row, col);            		            		
            	}    	    	    	    	
		return C;		
    }
	
	private Matrix rowargmax(Matrix C) {
		Matrix aux = new Matrix(1, numColumns);		
		aux.fill(Double.MIN_VALUE);
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	                    
            	if(get(row, col) > aux.get(col)) {            		
            		aux.set(col, get(row, col));            	    
            		C.set(col, row);            		            		
            	}    	    	    	           
		return C;		   	
    }
	
	public Matrix argmax(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		return rowargmax(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		return colargmax(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}     
	}
	
	private Matrix colargmin(Matrix C) {		
		Matrix aux = new Matrix(1, numColumns);		
		aux.fill(Double.MIN_VALUE);		
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)
            	if(get(row, col) < aux.get(row)) {            		
            		aux.set(row, get(row, col));            	    
            		C.set(row, col);            		            		
            	}    	    	    	    	
		return C;		
    }
	
	private Matrix rowargmin(Matrix C) {
		Matrix aux = new Matrix(numRows, 1);		
		aux.fill(Double.MIN_VALUE);
    	for (int row = 0; row < numRows; row++) 
            for (int col = 0; col < numColumns; col++)            	                    
            	if(get(row, col) < aux.get(col)) {            		
            		aux.set(col, get(row, col));            	    
            		C.set(col, row);            		            		
            	}    	    	    	           
		return C;		   	
    }
	
	public Matrix argmin(int axis){
		Matrix C;
    	if(axis == 0) {
    		C = new Matrix(1, numColumns);
    		return rowargmin(C);    		
    	}else if(axis == 1){
    		C = new Matrix(numRows, 1);
    		return colargmin(C);    		
    	} else {
    		throw new IllegalArgumentException("Invalid axis");
    	}     
	}
	
	public Matrix sigmoid(Matrix C){
		for(int pos = 0 ; pos < data.length ; pos++) 
			C.set(pos, Math.min(get(pos), 1.0/(1.0 + Math.exp(-get(pos)))));		            	        
		return C;		
	}
	
	public Matrix sigmoidi(){
		return sigmoid(this);
	}
	
	public Matrix rand(){		
		for(int pos = 0 ; pos < data.length ; pos++)
			set(pos, Random.instance.nextDouble());
		return this;
	}
	
	public Matrix randnorm(){
		for(int pos = 0 ; pos < data.length ; pos++)
			set(pos, Random.instance.nextGaussian());
		return this;
	}
	
	public static Matrix rand(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.rand();
		return C;
	}
	
	public static Matrix randn(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.randnorm();
		return C;		
	}
	
	public static Matrix ones(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		C.one();
		return C;		
	}
	
	public static Matrix zeros(int numRows, int numColumns){
		Matrix C = new Matrix(numRows, numColumns);
		return C;		
	}
	
}
