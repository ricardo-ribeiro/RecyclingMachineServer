package uk.ricardoribeiro;

/**
 * 
 * The console class implements the PrinterInterface therefore implements the method
 * print. The method print whenever called prints into the debugger console
 * @author ricardo
 *
 */
public class Console implements PrinterInterface{

	public void print(String receipt)
	{
		System.out.println(receipt);
	}
}
