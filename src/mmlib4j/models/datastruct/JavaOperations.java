package mmlib4j.models.datastruct;

import mmlib4j.options.Options;

public class JavaOperations implements Operations{

	public static final JavaOperations instance = new JavaOperations();
	
	// Row major
	@Override
	public int getIndex(int row, int col, int numRows, int numColumns) {
		return col + row * numColumns;
	}
	
	@Override
	public Matrix sum(Matrix A) {
		Matrix C = new Matrix(1, 1); 
		return sum(A, C);
	}

	@Override
	public Matrix sum(Matrix A, int axis) {
		Matrix C;
    	if(axis == 0) {    		
    		C = new Matrix(1, A.numColumns());
    		return sum_inrow(A, C);    		
    	}else if(axis == 1){    
    		C = new Matrix(A.numRows(), 1);
    		return sum_incol(A, C);    		
    	}else {			
			 throw new IllegalArgumentException("Invalid axis");			
		}		
	}

	@Override
	public Matrix sum(Matrix A, int axis, Matrix C) {
		if(axis == 0) {    		
    		return sum_inrow(A, C);
    	}else if(axis == 1){    
    		return sum_incol(A, C);
    	}else {			
			 throw new IllegalArgumentException("Invalid axis");			
		}		
	}
	
	private Matrix plus_inrow(Matrix A, Matrix B, Matrix C) {
		for (int row = 0; row < A.numRows(); row++) 
			for (int col = 0; col < A.numColumns(); col++)	
				C.set(row, col, A.get(row, col) + B.get(col));		
		return C;
	}
	
	private Matrix plus_incol(Matrix A, Matrix B, Matrix C) {
		for (int row = 0; row < A.numRows(); row++) 
			for (int col = 0; col < A.numColumns(); col++)	
				C.set(row, col, A.get(row, col) + B.get(row));		
		return C;
	}
	
	@Override
	public Matrix plusi(Matrix A, Matrix B) {		
		if(B.isRowVector()) {
			return plus_inrow(A, B, A);
		} else if(B.isColVector()) {
			return plus_incol(A, B, A);	
		}		
		for (int pos = 0; pos < A.numRows()*A.numColumns(); pos++) 	
			A.plus(pos, B.get(pos));  							
		return A;  
	}

	@Override
	public Matrix plus(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), A.numColumns());
		if(B.isRowVector()) {
			return plus_inrow(A, B, C);
		} else if(B.isColVector()) {
			return plus_incol(A, B, C);	
		}		
		for (int pos = 0; pos < A.numRows()*A.numColumns(); pos++) 	
			C.set(pos, A.get(pos) + B.get(pos));  							
		return C;    
	}
	
	private Matrix minus_inrow(Matrix A, Matrix B, Matrix C) {
		for (int row = 0; row < A.numRows(); row++) 
			for (int col = 0; col < A.numColumns(); col++)	
				C.set(row, col, A.get(row, col) - B.get(col));		
		return C;
	}
	
	private Matrix minus_incol(Matrix A, Matrix B, Matrix C) {
		for (int row = 0; row < A.numRows(); row++) 
			for (int col = 0; col < A.numColumns(); col++)	
				C.set(row, col, A.get(row, col) - B.get(row));		
		return C;
	}
	
	@Override
	public Matrix minusi(Matrix A, Matrix B) {
		if(B.isRowVector()) {
			return minus_inrow(A, B, A);
		} else if(B.isColVector()) {
			return minus_incol(A, B, A);	
		}		
		for (int pos = 0; pos < A.numRows()*A.numColumns(); pos++) 	
			A.minus(pos, B.get(pos));  							
		return A;   
	}

	@Override
	public Matrix minus(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), A.numColumns());
		if(B.isRowVector()) {
			return minus_inrow(A, B, C);
		} else if(B.isColVector()) {
			return minus_incol(A, B, C);	
		}		  				
		for (int pos = 0; pos < A.numRows()*A.numColumns(); pos++) 	
			C.set(pos, A.get(pos) - B.get(pos));  
		return C;  
	}
	
	// Inspired in EJML
	
	public Matrix dot_vec_reorder(double alpha, Matrix A, Matrix B, Matrix C) {
		double valB;
	    int endOfKLoop = A.numColumns()*A.numRows();	    
	    int indexB = 0;
	    int indexA = 0;
	    int indexC = 0;
	    int end = indexA + A.numRows();

	    valB = alpha*B.get(indexB++);

	    while( indexA < end ) {
	       C.set(indexC++, valB*A.get(indexA++));	        
	    }

	    while( indexA != endOfKLoop ) { 
	    	indexC = 0;
	    	end = indexA + A.numRows();
	    	valB = alpha*B.get(indexB++);
	    	while( indexA < end ) { 
	    		C.plus(indexC++, valB*A.get(indexA++));
	    	}
	    }	   
	    
	    return C;
	}

	
	public Matrix dot_vec_reorder(Matrix A, Matrix B, Matrix C) {
		double valB;
	    int endOfKLoop = A.numColumns()*A.numRows();
	    
	    int indexB = 0;

	    int indexA = 0;
	    int indexC = 0;
	    int end = indexA + A.numRows();

	    valB = B.get(indexB++);

	    while( indexA < end ) {
	       C.set(indexC++, valB*A.get(indexA++));	        
	    }

	    while( indexA != endOfKLoop ) { 
	    	indexC = 0;
	    	end = indexA + A.numRows();

	    	valB = B.get(indexB++);

	    	while( indexA < end ) { 
	    		C.plus(indexC++, valB*A.get(indexA++));
	    	}
	    }	   
	    
	    return C;
	}

	public Matrix Tdot_vec_small(double alpha, Matrix A, Matrix B, Matrix C) {
        int indexA = 0;
        int cIndex = 0;
        double b0 = B.get(0);
        for( int i = 0; i < A.numColumns(); i++ ) {
            double total = alpha * A.get(indexA++) * b0;

            for( int j = 1; j < A.numRows(); j++ ) {
                total += A.get(indexA++) * B.get(j);
            }

            C.set(cIndex++, total);
        }
        return C;
	}
	
	public Matrix Tdot_vec_small(Matrix A, Matrix B, Matrix C) {
        int indexA = 0;
        int cIndex = 0;
        double b0 = B.get(0);
        for( int i = 0; i < A.numColumns(); i++ ) {
            double total = A.get(indexA++) * b0;

            for( int j = 1; j < A.numRows(); j++ ) {
                total += A.get(indexA++) * B.get(j);
            }

            C.set(cIndex++, total);
        }
        return C;
	}
	
	public Matrix dot_reorder(double alpha, Matrix A, Matrix B, Matrix C) {
		double valB;
	    int indexCbase= 0;
	    int endOfKLoop = A.numRows()*A.numColumns();

	    for( int i = 0; i < B.numColumns(); i++ ) {
	    	 
	    	 int indexB = i*B.numRows();

	         int indexA = 0;
	         int indexC = indexCbase;
	         int end = indexA + A.numRows();

	         valB = alpha*B.get(indexB++);

	         while( indexA < end ) {
	           C.set(indexC++, valB*A.get(indexA++));	        
	         }

	         while( indexA != endOfKLoop ) { 
	        	 indexC = indexCbase;
	        	 end = indexA + A.numRows();

	        	 valB = alpha*B.get(indexB++);

	        	 while( indexA < end ) { 
	        		 C.plus(indexC++, valB*A.get(indexA++));
	        	 }
	         }
	         indexCbase += C.numRows();
	    }
	    return C;
	}

	
	public Matrix dot_reorder(Matrix A, Matrix B, Matrix C) {
		double valB;
	    int indexCbase= 0;
	    int endOfKLoop = A.numRows()*A.numColumns();

	    for( int i = 0; i < B.numColumns(); i++ ) {
	    	 
	    	 int indexB = i*B.numRows();

	         int indexA = 0;
	         int indexC = indexCbase;
	         int end = indexA + A.numRows();

	         valB = B.get(indexB++);

	         while( indexA < end ) {
	           C.set(indexC++, valB*A.get(indexA++));	        
	         }

	         while( indexA != endOfKLoop ) { 
	        	 indexC = indexCbase;
	        	 end = indexA + A.numRows();

	        	 valB = B.get(indexB++);

	        	 while( indexA < end ) { 
	        		 C.plus(indexC++, valB*A.get(indexA++));
	        	 }
	         }
	         indexCbase += C.numRows();
	    }
	    return C;
	}

	public Matrix dot_small(Matrix A, Matrix B, Matrix C) {				
		for(int rowA = 0; rowA < A.numRows() ; rowA++) {
			for(int colB = 0 ; colB < B.numColumns() ; colB++) {
				double total = 0;
				for(int colA = 0; colA < A.numColumns() ; colA++) {
					total += A.get(rowA, colA) * B.get(colA, colB);
				}				
				C.set(rowA, colB, total);
			}
		}		
		return C;
	}
	
	public Matrix dot_small(double alpha, Matrix A, Matrix B, Matrix C) {
		for(int rowA = 0; rowA < A.numRows() ; rowA++) {
			for(int colB = 0 ; colB < B.numColumns() ; colB++) {
				double total = 0;
				for(int colA = 0; colA < A.numColumns() ; colA++) {
					total += A.get(rowA, colA) * B.get(colA, colB);
				}				
				C.set(rowA, colB, alpha*total);
			}
		}		
		return C;
	}
	
	//
	
	@Override
	public Matrix dot(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numColumns());
		return dot(A, B, C);
	}

	@Override
	public Matrix dot(Matrix A, Matrix B, Matrix C) {		
		if(B.numColumns() == 1) {			
			if(A.numRows() >= Options.MULT_ROW_SWITCH) {
				return dot_vec_reorder(A, B, C);
			}else {
				return dot_small(A, B, C);
			}
			
		}if(A.numRows() >= Options.MULT_ROW_SWITCH) {
			return dot_reorder(A, B, C);
		} else {
			return dot_small(A, B, C);
		}
	}

	@Override
	public Matrix dot(double alpha, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numColumns());
		return dot(alpha, A, B, C);
	}
	
	@Override
	public Matrix dot(double alpha, Matrix A, Matrix B, Matrix C) {			
		if(B.numColumns() == 1) {
			if(A.numRows() >= Options.MULT_ROW_SWITCH) {
				return dot_vec_reorder(alpha, A, B, C);
			}else {
				return dot_small(alpha, A, B, C);
			}
			
		}if(A.numRows() >= Options.MULT_ROW_SWITCH) {
			return dot_reorder(alpha, A, B, C);
		} else {
			return dot_small(alpha, A, B, C);
		}
	}

	@Override
	public Matrix Tdot(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numColumns());
		return Tdot(A, B, C);
	}

	@Override
	public Matrix Tdot(Matrix A, Matrix B, Matrix C) {
		if(B.numColumns() == 1) {
			return Tdot_vec_small(A, B, C);
		}
		for(int colA = 0; colA < A.numColumns() ; colA++) {							
			for(int colB = 0; colB < B.numColumns() ; colB++) {
				double total = 0;
				for(int rowA = 0; rowA < A.numRows() ; rowA++) {
					total += A.get(rowA, colA) * B.get(rowA, colB);
				}
				C.set(colA, colB, total);
			}									
		}
		return C;
	}

	@Override
	public Matrix Tdot(double alpha, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numColumns());		
		if(B.numColumns() == 1) {
			return Tdot_vec_small(alpha, A, B, C);
		}
		return Tdot(alpha, A, B, C);
	}

	@Override
	public Matrix Tdot(double alpha, Matrix A, Matrix B, Matrix C) {
		for(int colA = 0; colA < A.numColumns() ; colA++) {							
			for(int colB = 0; colB < B.numColumns() ; colB++) {
				double total = 0;
				for(int rowA = 0; rowA < A.numRows() ; rowA++) {
					total += A.get(rowA, colA) * B.get(rowA, colB);
				}
				C.set(colA, colB,  alpha * total);
			}									
		}
		return C;		
	}

	@Override
	public Matrix dotT(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numRows()); 		
		return dotT(A, B, C);
	}

	@Override
	public Matrix dotT(Matrix A, Matrix B, Matrix C) {
		if(B.numRows() == 1 && A.numRows() >= Options.MULT_ROW_SWITCH) {
			return dot_vec_reorder(A, B, C);					
		}
		for(int rowA = 0; rowA < A.numRows() ; rowA++) {
			for(int rowB = 0 ; rowB < B.numRows() ; rowB++) {
				double total = 0;
				for(int colA = 0; colA < A.numColumns() ; colA++) {
					total += A.get(rowA, colA) * B.get(rowB, colA);
				}
				C.set(rowA, rowB, total);
			}
		}		
		return C;
	}

	@Override
	public Matrix dotT(double alpha, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numRows(), B.numRows());
		if(B.numRows() == 1 && A.numRows() >= Options.MULT_ROW_SWITCH) {
			return dot_vec_reorder(alpha, A, B, C);			
		}
		return dotT(alpha, A, B, C);
	}

	@Override
	public Matrix dotT(double alpha, Matrix A, Matrix B, Matrix C) {
		for(int rowA = 0; rowA < A.numRows() ; rowA++) {
			for(int rowB = 0 ; rowB < B.numRows() ; rowB++) {
				double total = 0;
				for(int colA = 0; colA < A.numColumns() ; colA++) {
					total += A.get(rowA, colA) * B.get(rowB, colA);
				}
				C.set(rowA, rowB, alpha * total);
			}
		}		
		return C;
	}

	@Override
	public Matrix TdotT(Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numRows()); 	
		return TdotT(A, B, C);
	}

	@Override
	public Matrix TdotT(Matrix A, Matrix B, Matrix C) {
		if(B.numRows() == 1) {
			return Tdot_vec_small(A, B, C);
		}
		for(int colA = 0; colA < A.numColumns() ; colA++) {							
			for(int rowB = 0; rowB < B.numRows() ; rowB++) {
				double total = 0;
				for(int rowA = 0; rowA < A.numRows() ; rowA++) {
					total += A.get(rowA, colA) * B.get(rowB, rowA);
				}
				C.set(colA, rowB, total);
			}									
		}
		return C;	
	}

	@Override
	public Matrix TdotT(double alpha, Matrix A, Matrix B) {
		Matrix C = new Matrix(A.numColumns(), B.numRows());
		if(B.numRows() == 1) {
			return Tdot_vec_small(alpha, A, B, C);
		}
		return TdotT(alpha, A, B, C);
	}

	@Override
	public Matrix TdotT(double alpha, Matrix A, Matrix B, Matrix C) {
		for(int colA = 0; colA < A.numColumns() ; colA++) {							
			for(int rowB = 0; rowB < B.numRows() ; rowB++) {
				double total = 0;
				for(int rowA = 0; rowA < A.numRows() ; rowA++) {
					total += A.get(rowA, colA) * B.get(rowB, rowA);
				}
				C.set(colA, rowB, alpha * total);
			}									
		}
		return C;	
	}
	
	
	private Matrix sum_inrow(Matrix A,  Matrix C){
		for (int row = 0; row < A.numRows(); row++) 
            for (int col = 0; col < A.numColumns(); col++)     
            	C.plus(col, A.get(row, col));            	         
		return C;    
	}
	
	private Matrix sum_incol(Matrix A,  Matrix C){
		for (int row = 0; row < A.numRows(); row++) 
            for (int col = 0; col < A.numColumns(); col++)     
            	C.plus(row, A.get(row, col));            	         
		return C;    
	}
	
	private Matrix sum(Matrix A,  Matrix C){		
		for (int pos = 0; pos < A.numRows()*A.numColumns(); pos++) 
            C.plus(0, A.get(pos));            	         
		return C;    
	}

	@Override 
	public Matrix mean(Matrix A) {
		Matrix C = new Matrix(1, 1);
		sum(A, C).div(0, A.numRows()*A.numColumns());
		return C;
	}
		
	@Override
	public Matrix mean(int axis, Matrix A, Matrix C){
		if(axis == 0) {			
			return sum_inrow(A, C).divi(A.numRows());					
		}else if(axis == 1){
			return sum_incol(A, C).divi(A.numColumns());    	
		} else {
			throw new IllegalArgumentException("Invalid axis");
		}    	  
	}

	@Override
	public Matrix mean(Matrix A, int axis) {
		Matrix C;		
		if(axis == 0) {		
			C = new Matrix(1, A.numColumns());			
			return sum_inrow(A, C).divi(A.numRows());			
			
		}else if(axis == 1){			
			C = new Matrix(A.numRows(), 1);			
			return sum_incol(A, C).divi(A.numColumns());    	
		} else {
			throw new IllegalArgumentException("Invalid axis");
		} 
	}
	
}
