package com.perisic.beds;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

import uk.ricardoribeiro.FilePrint;
import uk.ricardoribeiro.MachineEmptyException;
import uk.ricardoribeiro.MachineFullExecption;
import uk.ricardoribeiro.Newspaper; 

/**
 * Receipt Basis class. is the base class where we define where the items are stored in the program memory
 * In this class we define the methods to generate the output for the different print methods.
 * 
 * @author Marc Conrad, Ricardo Ribeiro
 *
 */

public class ReceiptBasis {
	/**
	 *  Items added are being stored on this vector. 
	 *  The vector stores an "Array" of objects that implement the DepositItem class.
	 *  (bottle,can.crate)
	 *  
	 */
	public static int Limit = 80;
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * Add item method. Receives an DepositItem object
	 * and it adds it into the items vector
	 * @param item
	 * @throws MachineFullExecption 
	 */
	public void addItem(DepositItem item) throws MachineFullExecption { 
		// Adding the item into the Vector of Items
		if(myItems.size() < Limit)
		{
			myItems.add(item); 
			// Retrieving the index of the added item and asssigning it to the number value
			item.number = myItems.indexOf(item); 		
		}else
		{
			throw new MachineFullExecption();
		}
		
		
	}
	/**
	 * Compute Sum -> Basic method to compute sum
	 * Loops trough the myItems Object Vector and returns a string with all the items in the vector
	 * @return String 
	 */
	public String computeSumX() { 
		String receipt = ""; 
		int sum = 0; 
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			receipt = receipt + item.number +": "+item; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value; 
		}
		receipt = receipt + "Total: "+sum; 
		return receipt; 
	}
	/**
	 * Compute Sum -> Second try of the method to compute sum
	 * Loops trough the myItems Object Vector and returns a string with all the items in the vector
	 * this method adds the item name line number and  the current system date
	 * @return String 
	 */
	public String computeSumZ() { 
		String receipt = "------------------------------------------\n"; 
		receipt += "\tRecycling Machine         \n";
		receipt += "\nDate: ";
		receipt += new Date().toString();
		receipt += "\n\n------------------------------------------\n"; 
		receipt += "Line Nº\tItem\t\tValue\n"; 
		receipt += "------------------------------------------\n"; 

		int sum = 0; 
		
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			// COllections frequency doesnt work with an vector of objects
			//int occurrences = Collections.frequency(myItems,item);
			//System.out.println(occurrences);
			
			receipt = receipt + "" + item.number + "\t" + item.getName() +"\t\t"+item.value; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value; 
		}
		receipt += "------------------------------------------\n"; 
		receipt = receipt + "\t\t    Total: "+sum; 
		
		
		return receipt; 
	}
	
	/**
	 * Compute Sum -> Detailed Compute sum
	 * This method on the other side  make use of a loop to generate  the receipt
	 * but instead counts the frequency of each of the items and then prints them in a organised manner 
	 * Counts the frequency  
	 * @return String 
	 * @throws  MachineEmptyException
	 */
	public String computeSum() throws MachineEmptyException { 
		String receipt = "------------------------------------------\n"; 
		if(myItems != null)// if the machine is not empty
		{
			receipt += "\tRecycling Machine         \n";
			receipt += "\nDate: ";
			receipt += new Date().toString();// Add Date
			receipt += "\n\n------------------------------------------\n"; 
			receipt += "Line Nº\tItem\t\tValue\n"; 
			receipt += "------------------------------------------\n"; 
			int sum = 0; 
			
			// This classNames object will be used to store temporarily a copy of the names (only the name) of the 
			// objects contained in the myItems Vector
			
			// object of the class Vector (Array of objects) in this case strings
			Vector<String> classNames = new Vector<String>();
			// The For loop iterates trough the index 0 until the size of the Vector myItems
			for(int i=0; i < myItems.size(); i++ )
			{
				// Add the name of the Object in the current index to the className Vector
				classNames.add(myItems.get(i).getName());	
			}
			
			// Counts the frequency of a string in a vector
			int canOccur = Collections.frequency(classNames,"Can");
			int bottleOccur = Collections.frequency(classNames,"Bottle");
			int crateOccur = Collections.frequency(classNames,"Crate");
			int newsPaperOccur = Collections.frequency(classNames,"Newspaper");
			// Line counter --- we start counting now, in order to know which line number to assign.
			// in case theres missing objects to add
			// Composing the receipt
			int lineCounter = 0;
				if(canOccur != 0)
					receipt = receipt + "" + lineCounter++ + "\t" + "Can" +"\t"+ canOccur +"\t"+ new Can().value * canOccur + "\n"; 
				if(bottleOccur != 0)
					receipt = receipt + lineCounter++ + "\t" + "Bottle" +"\t"+ bottleOccur +"\t"+ new Bottle().value * bottleOccur+ "\n"; 
				if(crateOccur != 0)
					receipt = receipt + lineCounter++ + "\t" + "Crate" +"\t"+ crateOccur +"\t"+ new Crate().value * crateOccur+ "\n"; 
				if(newsPaperOccur != 0)
					receipt = receipt  + lineCounter++ + "\t" + "Newspaper" +"\t"+ newsPaperOccur +"\t"+ new Newspaper().value * newsPaperOccur+ "\n"; 	
				receipt = receipt + System.getProperty("line.separator");
				sum = new Can().value * canOccur + new Bottle().value * bottleOccur + new Crate().value * crateOccur +new Newspaper().value * newsPaperOccur;
			
			receipt += "------------------------------------------\n"; 
			receipt = receipt + "Number of items: "+ (canOccur+ bottleOccur + crateOccur + newsPaperOccur) +"\t    Total: "+sum; 
		}
		FilePrint p = new FilePrint();
		p.print(receipt);
		return receipt; 
		
		
	}
}
