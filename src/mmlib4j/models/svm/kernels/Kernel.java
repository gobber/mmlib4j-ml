package mmlib4j.models.svm.kernels;

import mmlib4j.models.datastruct.Matrix;

public interface Kernel {
	
	public Matrix trick(Matrix x, Matrix vectors);
	
}
