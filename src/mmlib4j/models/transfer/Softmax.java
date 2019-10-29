package mmlib4j.models.transfer;

import mmlib4j.models.datastruct.Matrix;

public class Softmax implements Transfer {

	public Softmax() {}
	
	@Override
	public Matrix activate(Matrix z) {					
		Matrix max = z.max(1);				
		Matrix sum = z.minusi(max).expi().sum(1);						
		return z.divi(sum);
	}	
	
}
