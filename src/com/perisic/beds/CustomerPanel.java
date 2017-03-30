package com.perisic.beds;

import uk.ricardoribeiro.MachineEmptyException;
import uk.ricardoribeiro.MachineFullExecption;
import uk.ricardoribeiro.PrinterInterface;

/**
 * Customer Panel Class initialises a deposit item receiver calss
 * The Customer panel takes a printer interface object and initialises
 * the Deposit Item receiver with the received printer object 
 * 
 * @author Marc Conrad, Ricardo Ribeiro
 *
 */
public class CustomerPanel {
	DepositItemReceiver receiver = new DepositItemReceiver(); 
	
	public CustomerPanel(PrinterInterface printer)
	{
		receiver = new DepositItemReceiver(printer);
	}
	public void setPrinter(PrinterInterface printer)
	{
		receiver.setPrinter(printer);
	}
	
	
	/**
	 * 
	 * @param slot 
	 */
	public void itemReceived(int slot) { 
		try {
			receiver.classifyItem(slot);
		} catch (MachineFullExecption e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
	}
	/**
	 * @throws MachineEmptyExecption 
	 * 
	 */
	public void printReceipt() throws MachineEmptyException { 
		receiver.printReceipt();
	}
}
