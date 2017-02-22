package uk.ricardoribeiro;

public class MachineFullExecption extends Exception{
	public MachineFullExecption()
	{
		System.err.println("ERROR::USER::There is no computational power for me to hold more than 100 items upsi");
		SpeechPrint speechPrint = new SpeechPrint();
		speechPrint.print("The machine is FULL!");
	}
}
