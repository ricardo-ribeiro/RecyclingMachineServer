package com.perisic.beds;

/**
 * The Crate class extends the DepositItem abstract class 
 * Therefore the DepositItem class is the base class for this class.
 * Since it extends the DepositItem it has its properties 
 * @author Marc Conrad
 *
 */
public class Crate extends DepositItem {
	static int weight = 1516; 
	static int size = 90; 
	/**
	 * 
	 */
	public Crate() { 
		value = 42; 
	}
}
