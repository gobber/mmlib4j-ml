package mmlib4j.debug;

public abstract class Debug {

	public static Debug instance = new DebugNone();	
	
	public static Debug getInstance() {			
		return instance;		
	}
	
	public abstract void show(String msg);
	
	public abstract void start();	
	
	public abstract void end();
	
}
