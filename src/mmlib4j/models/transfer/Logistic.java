package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Logistic implements Transfer {
	
	public Logistic() {}

	@Override
	public Matrix activate(Matrix z) {                          
        return z.sigmoidi();        
	}
	
}
