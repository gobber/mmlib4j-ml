package mmlib4j.debug;

public class DebugTime extends Debug{
	
	private long ti;
	
	public static void newInstance() {				
		instance = new DebugTime();		
	}

	@Override
	public void show(String msg) {		
		System.out.print(msg);		
	}

	@Override
	public void start() {
		ti = System.currentTimeMillis();		
	}

	@Override
	public void end() {
		
		long tf = System.currentTimeMillis();		
		System.out.printf("\t [Time: %.8fs]\n", ((tf - ti) /1000.0));
		
	}
		
}
