package mmlib4j.models.svm.kernels;

public class KernelFactory {
	
	public static Kernel create (String KernelType, double gamma, double degree, double coef0) {
		Kernel kernel;
		switch(KernelType.toUpperCase()){		
			case "LINEAR":
				kernel = new Linear();
				break;
			case "POLY":
				kernel = new Poly(gamma, degree, coef0);
				break;
			case "SIGMOID":
				kernel = new Sigmoid(gamma, coef0);
				break;
        	case "RBF":
        		kernel = new Rbf(gamma);
        		break;
			default:
				throw new IllegalArgumentException("Invalid kernel type");		
		}			
		return kernel;
	}
	
}
