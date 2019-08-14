package mmlib4j.files;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mmlib4j.options.Options;

public class DataReader {

	private Map<String, DataFile> listOfFiles;
	private String extensions[] = {".gif", ".png", ".jpg", ".csv", ".txt"};
	private String pattern = "*";
	
	public DataReader(){
		listOfFiles = new TreeMap<>();
	}
	
	public boolean valid(File f) {
		for(String e : extensions) {
			if(f.getName().endsWith(e)) {
				if(Options.IGNORE_HIDDEN_FILES)
					if(!f.getName().startsWith("."))
						return true;
				else
					return true;
			}
			
		}
		return false;
	}
	
	public DataReader pattern(String pattern) {
		this.pattern = pattern;
		return this;
	}
	
	private void explore(File folder) {		
		if(valid(folder)) {							
			Pattern p = Pattern.compile(pattern);					
			Matcher matcher = p.matcher(folder.getName());
			if(matcher.find()) {
				String key = matcher.group();					
				DataFile dFile = listOfFiles.get(key);
			
				if(dFile == null)
					dFile = new DataFile();
			
				dFile.getFiles().add(folder);					
				listOfFiles.put(key, dFile);
			}					
		}		
		File children [] = folder.listFiles();
		if(children != null)
			for(File child : children) 						
				explore(child);			
	}
	
	public DataReader group(File ... files) {				
		for(File dir : files) {
			explore(dir);
		}		
		return this;		
	}
	
	public Collection<DataFile> get(){
		return listOfFiles.values();
	}
	
}
