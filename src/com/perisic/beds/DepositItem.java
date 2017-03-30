package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 * Abstract Class DepositItem - A abstract class 
 *
 */
public abstract class DepositItem {
	int number; 
	public static int value; 
	



	protected String itemName;
	
	/**
	 * Get name method returns a string that corresponds to the Class name that an instantiated object
	 * @return String 
	 */
	public String getName()
	{
		return this.getClass().getSimpleName();
	}
	
}
