package mmlib4j.files;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DataFile {
	
	private List<File> files = new LinkedList<>();

	public List<File> getFiles() {
		return files;
	}

	public DataFile setFiles(List<File> files) {
		this.files = files;
		return this;
	}			
	
	public File filter(String pattern) {		
		for(File f : files) {			
			if(f.getName().contains(pattern)) {				
				return f.getAbsoluteFile();				
			}			
		}		
		return null;		
	}
	
}