package EventCalendar;

import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class FileWriter {
	
	protected final static String DEFAULT_FILE_NAME = "Untitled⁩/⁨Users⁩/matthewslazak⁩/⁨Documents⁩/Events.txt";
	private static String fileName;
	

	public FileWriter() {
		fileName = DEFAULT_FILE_NAME; 
	}
	
	public FileWriter(String fileName) {
		FileWriter.fileName = fileName; 
	}


 
	@Override
	public String toString() {
		return "FileWriter [fileName=" + fileName + "]";
	}

	/** 
	 * NOTE: we just "overloaded" the public writeTo() method with a different signature 
	 * @param aFile
	 * @param data
	 * @param append
	 */
	protected static  void writeTo(File aFile, String data, boolean append) {
		
		    try {
		    	  FileOutputStream fileOut = new FileOutputStream(aFile, append);
		    	  BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut); 
			      PrintStream printStream = new PrintStream(bufferedOut);
			      
			      printStream.println(data); // what we've all used with System.out 
			      
			      printStream.close();
	
		    } 
		    catch (Exception ex) {
			      System.err.println(ex );
		    }
		    
	}
	  
	/**
	   * Writes "data" to file assigned to this Class - 
	   * control whether files gets over-written with "append" flag 
	   * @param data
	   * @param append
	*/
	public static void writeTo(String data, boolean append) {
		  File file = new File(fileName);
		  // call "internal" method of the same name 
		  writeTo(file,  data, append);
	}
		    
	  
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		
		FileWriter fileWriter = new FileWriter();
		
		
		System.exit(0); 
	}
	*/




}

