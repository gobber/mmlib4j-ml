package mmlib4j.models.postprocessing;

import mmlib4j.models.datastruct.Matrix;

public interface PostProcessing {

	public Matrix execute(Matrix output);
	
}
