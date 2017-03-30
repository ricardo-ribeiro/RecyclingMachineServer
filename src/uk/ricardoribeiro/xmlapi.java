package uk.ricardoribeiro;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.perisic.beds.Bottle;
import com.perisic.beds.Can;
import com.perisic.beds.Crate;
import com.perisic.beds.CustomerPanel;
import com.perisic.beds.ReceiptBasis;

public class xmlapi {
	// Constructor
	private GMain mainObject;
	private Users usersObject;
	private String sessionCookie = "NotSet"+ Math.random();
	private TechnicalInterventions technicalInterventions;
	public xmlapi(GMain main, Users users, TechnicalInterventions techInterventions)
	{
		this.mainObject = main;
		this.usersObject = users;
		this.technicalInterventions = techInterventions;
	}


	public String saveFontColour(int col){
		this.mainObject.printerDisplay.setTextColour(new Color(col));
		this.mainObject.printerFrame.setTextColour(new Color(col));
		this.mainObject.printerDisplay.update_the_settings();
		this.mainObject.printerFrame.update_the_settings();
		System.out.println(col);
		return "ACK::OK";
	}
	public String saveFont(int size, String font, int style){
		this.mainObject.printerDisplay.setTextFont(font);
		this.mainObject.printerDisplay.setTextSize(size);
		this.mainObject.printerDisplay.setTextStyle(style);
		this.mainObject.printerFrame.setTextFont(font);
		this.mainObject.printerFrame.setTextSize(size);
		this.mainObject.printerFrame.setTextStyle(style);
		this.mainObject.printerDisplay.update_the_settings();
		this.mainObject.printerFrame.update_the_settings();
		System.out.println(size);
		return "ACK::OK";
	}
	public String saveBackgroundColour(int col){
		this.mainObject.printerDisplay.setBgColour(new Color(col));
		this.mainObject.printerDisplay.update_the_settings();
		this.mainObject.printerFrame.setBgColour(new Color(col));
		this.mainObject.printerFrame.update_the_settings();
		System.out.println(col);
		return "ACK::OK";
	}


	public Vector<Vector<Object>> retrieveCurrentStatus()
	{
		Vector<Vector<Object>> bVector = new Vector<Vector<Object>>();
		Vector<Object> sVector = new Vector<Object>();
		
		// First Location of Vector - Vector with int's
		sVector.add(getCurrentLevels());
		sVector.add(getReceipts());
		
		
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
		
		
		//this.usersObject.verifyUser(username,password)
		if(this.usersObject.verifyUser(username,password)) { // Needs some more sophisticated mechanism such encryption and database etc etc!!!!
			sessionCookie = "Cookie"+Math.random(); 
			return sessionCookie; 
		} else { 
			return "ACK::NOT"; // Let's come to this point later. 
		}
	}
	public String remeberPassword(String username) { 

		return this.usersObject.forgot_password(username);
	}
	
	public String logout() { 
		sessionCookie = "NotSet"+Math.random(); 
		return "OK"; 
	}
	public Vector<Integer> getItemsValue()
	{
		Vector<Integer> currentValues = new Vector<Integer>();
		currentValues.add(new Can().value);
		currentValues.add(new Bottle().value);
		currentValues.add(new Crate().value);
		currentValues.add(new Newspaper().value);
		
		System.out.println(currentValues);
		return currentValues;
	}
	public Integer getMaximumItems()
	{
		return ReceiptBasis.Limit;
	}
	public Integer setMaximumItems(int limit)
	{
		return ReceiptBasis.Limit = limit;
	}
	public String changeItemsValue(Vector<Integer> newValues)
	{
		System.out.println(newValues);
		
		Can.value = newValues.get(0);
		Bottle.value =  newValues.get(1);
		Crate.value =  newValues.get(2);
		Newspaper.value =  newValues.get(3);
		
		return "ACK::OK";
	}
	public String speak(String toSpeak)
	{
		SpeechPrint talk = new SpeechPrint();
		talk.print(toSpeak);
		return "ACK::OK";
	}
	public Vector<Vector> getTechnicalInterventions(){
		return technicalInterventions.techAccess;
	}
	public Vector<String> getReceipt(String receiptName)
	{
		
		File file = new File(System.getProperty("user.dir")+File.separator+receiptName+".receipt");
		FileReader read = null;
		 // This will reference one line at a time
		String line=null;
		Vector<String> receipt = new Vector();
		try {
			read = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(read);
				
	            try {
					while((line = bufferedReader.readLine()) != null) {
					    //System.out.println(line);
					    receipt.add(line);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   

	            // Always close files.
	            try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}         
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return receipt;
	}
	public Boolean resetMachine()
	{
		//Resetting the mchine and the status progress bars
		mainObject.currentStatusFrame.resetProgressBars();
		PrinterInterface printerDisplay = new PrinterDisplay();
		mainObject.myPanel = new CustomerPanel(printerDisplay );
		return true;
	}
	
	public Vector<String> getReceipts()
	{
		
		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".receipt");
		    }
		});
		
		Vector<String> receipts = new Vector();
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			
		  System.out.println("File " + listOfFiles[i].getName().replace(".receipt",""));
		  receipts.add(listOfFiles[i].getName().replace(".receipt",""));
		    	System.out.println(getReceipt(listOfFiles[i].getName().replace(".receipt","")));
		}
		
		return receipts;
	}

}
