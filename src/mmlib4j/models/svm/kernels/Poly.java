package mmlib4j.models.svm.kernels;
import mmlib4j.models.datastruct.Matrix;

public class Poly implements Kernel {
	
	private double coef0;
	private double gamma;
	private double degree;

	public Poly(double gamma, double degree, double coef0) {
		this.gamma  = gamma;
		this.degree = degree;
		this.coef0  = coef0;
	}

	@Override
	public Matrix trick(Matrix x, Matrix vectors) {
		return vectors.dotT(gamma, x).plusi(coef0).powi(degree);
	}

}
