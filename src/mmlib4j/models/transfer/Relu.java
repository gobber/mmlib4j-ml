package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Relu implements Transfer {

	public Relu() {}
	
	@Override
	public Matrix activate(Matrix z) {
        return z.maxi(0);        
	}	
	
}
