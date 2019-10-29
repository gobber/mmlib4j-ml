package mmlib4j.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import mmlib4j.models.datastruct.Matrix;


public class DataWriter{

	private String extension = ".csv";
	private String separator = ";";	
	private PrintWriter output;
	
	public DataWriter create(String fileName) {
		
		try {			
			output = new PrintWriter( new FileOutputStream( new File(fileName + extension) ) );			
		} catch ( FileNotFoundException e ) {						
			e.printStackTrace();			
		}	
		
		return this;
		
	}
	
	public DataWriter write(Matrix sample) {		
		sample.setSeparator(separator);
		output.println(sample.toString());
		return this;
	}
	
	public DataWriter write(String line) {		
		output.println(line);
		return this;
	}
	
	public DataWriter close() {		
		output.close();
		return this;
	}

	public String getExtension() {
		return extension;
	}

	public String getSeparator() {
		return separator;
	}
	
	public DataWriter setSeparator(String separator) {
		this.separator = separator;
		return this;
	}
	
	public DataWriter setExtension(String extension) {
		this.extension = extension;
		return this;
	}
	
}
