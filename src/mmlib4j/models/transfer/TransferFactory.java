package mmlib4j.models.transfer;

public class TransferFactory {

	public static Transfer create(String ac){		
		Transfer transfer;
		if(ac.equalsIgnoreCase("Logistic")) {
			transfer = new Logistic();	
		} else if(ac.equalsIgnoreCase("Relu")){
			transfer = new Relu();
		} else if(ac.equalsIgnoreCase("Identity")) {
			transfer = new Identity();
		} else if(ac.equalsIgnoreCase("Softmax")) {
			transfer = new Softmax();
		}else if(ac.equalsIgnoreCase("Tanh")) {
			transfer = new Tanh();
		} else {
			throw new IllegalArgumentException("Illegal transfer type.");
		}		
		return transfer;
	}
	
}
