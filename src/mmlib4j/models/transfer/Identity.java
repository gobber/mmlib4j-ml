package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Identity implements Transfer {
	
	public Identity() {}
	
	@Override
	public Matrix activate(Matrix z) {		
		return z;		
	}
	
}
