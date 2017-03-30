package uk.ricardoribeiro;

/**
 * This Class implements PrinterInterface therefore 
 * the definition of the method print is implied
 * In this class the method print is creating a need SpeechThread parsing the text
 * to be spoken.
 * It starts the task. The task self destroys when finished
 * 
 * @author Ricardo Ribeiro
 * @implements PrinterInterface
 */
public class SpeechPrint implements PrinterInterface {
	 @Override
	public void print(String receipt) {
		SpeechThread spt = new SpeechThread(receipt);
		// Starts the thread -> this way once the voice processing is dispatched the system will speak without hanging the overall system
		spt.start();
	}

}
