package com.perisic.beds;

import uk.ricardoribeiro.PrinterDisplay;
import uk.ricardoribeiro.PrinterFrame;
import uk.ricardoribeiro.Console;
import uk.ricardoribeiro.MachineEmptyException;
import uk.ricardoribeiro.MachineFullExecption;
import uk.ricardoribeiro.Newspaper;
import uk.ricardoribeiro.PrinterInterface;


/**
 * The deposit item receiver class defines methods to classify the items inputed by the user
 * and adds them to the to the receipt basis which stores the current entered items.
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	PrinterInterface printer = null;
	public PrinterInterface getPrinter() {
		return printer;
	}
	public void setPrinter(PrinterInterface printer) {
		this.printer = printer;
	}
	public DepositItemReceiver(PrinterInterface printer)
	{
		this.printer = printer;
	}
	public DepositItemReceiver()
	{
		this.printer = new Console();
	}
	
	
	ReceiptBasis theReceiptBasis = new ReceiptBasis();
	//ReceiptPrinter printer = new ReceiptPrinter(); 
	//printer = new PrinterDisplay();
	
	/**
	 * 
	 * Creates a new receipt basis object
	 * 
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	/**
	 * This method takes a int number which represents the slot generates a new object of the inputed item
	 * and 
	 * @param slot
	 * @throws MachineFullExecption 
	 */
	public void classifyItem(int slot) throws MachineFullExecption { 
		DepositItem item = null; 
		if( slot == 1 ) { 
			item = new Can(); 
		} else if( slot == 2 ) { 
			item = new Bottle(); 
		} else if ( slot == 3 ) { 
			item = new Crate(); 
		} 
		else if ( slot == 4 ) { 
			item = new Newspaper(); 
		} 
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item); 
	}
	/**
	 * This method calls a method that computes
	 * all the items sum and call the printing method.
	 * @throws MachineEmptyExecption 
	 */
	public void printReceipt() throws MachineEmptyException { 
		String str = "";
		try {
			str = theReceiptBasis.computeSum();
			printer.print(str);
		} catch (NullPointerException e) {
			throw new MachineEmptyException();
		} 
		theReceiptBasis = null; 
	}
}
