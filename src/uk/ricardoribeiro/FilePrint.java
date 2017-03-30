package uk.ricardoribeiro;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

/**
 * This Class implements the PrinterInterface therefore implements the method print 
 * specified on the PrinterInterface class. This class provides the ability to print the receipt into a file in the file system.
 * 
 * @author Ricardo Ribeiro
 * 
 *
 */
public class FilePrint implements PrinterInterface {
	// This method overrides the print method defined in PrinterInterface
	@Override
	public void print(String receipt) {
		// Try catch --- exception handling is necessary when dealing with files
	    try{
	    	File file = new File(System.getProperty("user.dir")+File.separator+new Date().toString().replace(":", "-")+".receipt");
	    	// object of the Class PrintWriter. This Class writes a file onto the system
		    PrintWriter writer = new PrintWriter(file, "UTF-8");
		    // print the receipt string into the file.
		    writer.print(receipt);
		    // close the file
		    writer.close();
		} catch (Exception e) {
		   // catch the exception
			System.err.println(e);
		}
	}
	
}
