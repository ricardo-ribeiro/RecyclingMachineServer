package uk.ricardoribeiro;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public interface rmiInterface extends Remote{

	Vector<Vector<Object>> retrieveCurrentStatus() throws RemoteException;

	String testConnection()  throws RemoteException;

	String login(String username, String password)  throws RemoteException;

	String logout()  throws RemoteException;

	Vector<Integer> getItemsValue()  throws RemoteException;

	Integer getMaximumItems()  throws RemoteException;

	Integer setMaximumItems(int limit)  throws RemoteException;

	String changeItemsValue(Vector<Integer> newValues)  throws RemoteException;

	String speak(String toSpeak)  throws RemoteException;

	Vector<String> getReceipt(String receiptName)  throws RemoteException;

	Boolean resetMachine()  throws RemoteException;

	Vector<String> getReceipts()  throws RemoteException;

	Vector<Vector> getTechnicalInterventions() throws RemoteException;
	
	String saveFontColour(int col)  throws RemoteException;

	String saveBackgroundColour(int col)  throws RemoteException;

	String saveFont(int size, String font, int style)  throws RemoteException;
	
    String remeber_password(String username) throws RemoteException;


}