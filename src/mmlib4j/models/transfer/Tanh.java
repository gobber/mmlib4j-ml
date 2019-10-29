package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Tanh implements Transfer{
	
	public Tanh() {}
	
	@Override
	public Matrix activate(Matrix z) {			
        return z.tanhi();        
	}
	
}
