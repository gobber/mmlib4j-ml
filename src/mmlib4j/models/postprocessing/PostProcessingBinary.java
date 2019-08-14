package mmlib4j.models.postprocessing;

import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.postprocessing.PostProcessing;

public class PostProcessingBinary implements PostProcessing {	
	@Override
	public Matrix execute(Matrix output) {
		return output.biggertheni(0.5);
	}
}
