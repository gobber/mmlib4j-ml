package mmlib4j.models.svm.kernels;
import mmlib4j.models.datastruct.Matrix;

public class Rbf implements Kernel {

	private double gamma;

	public Rbf(double gamma) {
		this.gamma = gamma;
	}
	
	@Override
	public Matrix trick(Matrix x, Matrix vectors) {			
		Matrix vsq = vectors.pow2().sum(1);
        Matrix xsq = x.pow2().sum(1);                
        Matrix aux = new Matrix(x.numRows(), 1);
        aux.one();
        
        Matrix sum = vsq.dotT(aux);        
        Matrix aux2 = new Matrix(vectors.numRows(), 1);
        aux2.one();
        
        aux2.dotT(xsq, sum);        
        vectors.dotT(-2, x, sum);        
        return sum.muli(gamma).negi().expi();        		
	}

}
