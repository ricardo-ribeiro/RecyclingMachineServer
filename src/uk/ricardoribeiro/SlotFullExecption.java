package uk.ricardoribeiro;

/**
 * @author Ricardo Ribeiro
 * This class extends the class Exception and its subclasses are a form of Throwable (class of all errors and exceptions) that indicates a condition that a
 *  application might want to catch.
 *  When any of the slots in the machine are full they throw this exception
 *  SlotFullExecption will print a error to the console and will also initialise a speech print object and say that the slot if full
 */
public class SlotFullExecption extends Exception{
	public SlotFullExecption()
	{
		System.err.println("ERROR::USER::STOP Please Stop i'm full");
		SpeechPrint speechPrint = new SpeechPrint();
		speechPrint.print("Hey that slot is Full");
	}
}
