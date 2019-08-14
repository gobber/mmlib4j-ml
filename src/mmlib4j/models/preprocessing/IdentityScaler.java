package mmlib4j.models.preprocessing;
import mmlib4j.models.datastruct.Matrix;

public class IdentityScaler implements Scaler {	
	
	@Override
	public Matrix normalize(Matrix A) {
		return A;
	}

}
