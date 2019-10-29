package mmlib4j.models.transfer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TransferFactory {
	
	private static final Map<String, Class<? extends Transfer>> registeredTransfers = new HashMap<String, Class<? extends Transfer>>();
	
	static {
		registeredTransfers.put("logistic", Logistic.class);
		registeredTransfers.put("relu", Relu.class);
		registeredTransfers.put("identity", Identity.class);
		registeredTransfers.put("softmax", Softmax.class);
		registeredTransfers.put("tanh", Tanh.class);		
	}
	
	public static Transfer create(String ac){			
		Transfer transfer = null;		
		try {
			transfer = registeredTransfers.get(ac.toLowerCase()).getConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}	
		return transfer;
	}
	
}
