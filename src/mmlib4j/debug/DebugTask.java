package mmlib4j.debug;

public class DebugTask extends Debug{
	
	public static void newInstance() {					
		instance = new DebugTask();		
	}
	
	@Override
	public void start() {}
	
	@Override
	public void end() {
		System.out.println();
	}
	
	@Override
	public void show(String msg) {		
		System.out.print(msg);		
	}	

}
