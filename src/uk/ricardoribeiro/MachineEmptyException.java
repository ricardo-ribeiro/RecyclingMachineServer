package uk.ricardoribeiro;
/**
 * MachineEmptyExecption Class 
 * Creates the Main gui window and initialises all the required to function with the recycling machine.
 * This class extends JFrame Class.
 * @author Ricardo Ribeiro
 * @extends Exception
 */
public class MachineEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6974760133249479829L;

	public MachineEmptyException()
	{
		System.err.println("ERROR::USER::There is no computational porpuse to create an empty receipt. Think like a machine first");
		System.err.println("ERROR::USER::There's only one bugging here, and is you!");
		SpeechPrint speechPrint = new SpeechPrint();
		speechPrint.print("The machine is empty!");
	}
}
