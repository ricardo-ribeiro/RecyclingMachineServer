package uk.ricardoribeiro;

import java.io.File;
import java.util.Vector;

public class xmlapi {
	// Constructor
	private GMain mainObject;
	private String sessionCookie = "NotSet"+ Math.random();
	public xmlapi(GMain main)
	{
		this.mainObject = main;
	}
	
	public Vector<Vector<Object>> retrieveCurrentStatus()
	{
		Vector<Vector<Object>> bVector = new Vector<Vector<Object>>();
		Vector<Object> sVector = new Vector<Object>();
		
		// First Location of Vector - Vector with int's
		sVector.add(getCurrentLevels());
		
		
		
		bVector.add(sVector);
		
		
		return bVector;
	}
	private Vector<Object> getCurrentLevels()
	{
		return this.mainObject.getCurrentMachineStatus();
	}
	
	public String testConnection() { 
		return "ACK::OK"; 
	}
	
	public String login(String username, String password) { 
		if(password.equals("123")) { // Needs some more sophisticated mechanism such encryption and database etc etc!!!!
			sessionCookie = "Cookie"+Math.random(); 
			return sessionCookie; 
		} else { 
			return "ACK::NOT"; // Let's come to this point later. 
		}
	}
	
	public String logout() { 
		sessionCookie = "NotSet"+Math.random(); 
		return "OK"; 
	}
	
	public Vector<String> getReceipts()
	{
		
		File folder = new File("./");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			 String[] parts = listOfFiles[i].getName().split(".");
			 for(int d = 0; d<parts.length;d++)
			 {
				 System.out.print(parts[d].toString());
			 }
			 
		      if (listOfFiles[i].isFile() && parts.length == 2) 
		      {
		    	if(parts[1] == "receipt")
		    	{
		    		System.out.println("File " + parts[1].toString());
		    	}
		        
		      }
		}
		
		return new Vector();
	}

}
