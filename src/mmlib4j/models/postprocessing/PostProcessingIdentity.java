package mmlib4j.models.postprocessing;

import mmlib4j.models.datastruct.Matrix;

public class PostProcessingIdentity implements PostProcessing{
	@Override
	public Matrix execute(Matrix output) {
		return output;
	}
}
