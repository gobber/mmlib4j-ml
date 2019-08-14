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
	
	public void create(String fileName) {
		
		try {			
			output = new PrintWriter( new FileOutputStream( new File(fileName + extension) ) );			
		} catch ( FileNotFoundException e ) {						
			e.printStackTrace();			
		}	
		
	}
	
	public void write(Matrix sample) {		
		sample.setSeparator(separator);
		output.println(sample.toString());		
	}
	
	public void write(String line) {		
		output.println(line);		
	}
	
	public void close() {		
		output.close();		
	}

	public String getExtension() {
		return extension;
	}

	public String getSeparator() {
		return separator;
	}
	
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
