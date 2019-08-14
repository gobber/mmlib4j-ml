package mmlib4j.models.svm.kernels;

import mmlib4j.models.datastruct.Matrix;

public class Linear implements Kernel {

	@Override
	public Matrix trick(Matrix x, Matrix vectors) {
		return vectors.dotT(x);
	}
	
}
