package mmlib4j.options;

import mmlib4j.models.datastruct.Operations;

public class Options {
	
	public static Operations operations = Operations.NO_NATIVE;
	
	// Number of rows to choose to do better dot algorithms in some cases
	
	public static int MULT_ROW_SWITCH = 15;
	
	//
	public static boolean IGNORE_HIDDEN_FILES = true;
	
}
