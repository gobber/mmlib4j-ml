package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Tanh implements Transfer{
	
	@Override
	public Matrix activate(Matrix z) {			
        return z.tanhi();        
	}
	
}
