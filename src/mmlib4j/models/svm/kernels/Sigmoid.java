package mmlib4j.models.svm.kernels;
import mmlib4j.models.datastruct.Matrix;

public class Sigmoid implements Kernel {

	private double coef0;
	private double gamma;
	
	public Sigmoid(double gamma, double coef0) {
		this.gamma  = gamma;
		this.coef0  = coef0;
	}

	@Override
	public Matrix trick(Matrix x, Matrix vectors) {
		return vectors.dotT(gamma, x).plusi(coef0).tanhi();
	}	
	
}
