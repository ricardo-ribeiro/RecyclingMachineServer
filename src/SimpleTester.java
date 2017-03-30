import com.perisic.beds.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import org.apache.xmlrpc.*;
import uk.ricardoribeiro.GMain;
import uk.ricardoribeiro.TechnicalInterventions;
import uk.ricardoribeiro.Users;
import uk.ricardoribeiro.rmiInterface;
import uk.ricardoribeiro.rmiapi;
import uk.ricardoribeiro.xmlapi;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *
 */
public class SimpleTester  {
	
	public static void main(String [] args) { 
		Users users = new Users();
		TechnicalInterventions techInterventions = new TechnicalInterventions();
		
		try {
			   System.out.println("Starting the Server..."); 
			   WebServer server = new WebServer(3333);
			   GMain main = new GMain();
			   xmlapi api = new xmlapi(main,users,techInterventions);
	
			   // Bind the remote object's stub in the registry
	           Registry registry = LocateRegistry.createRegistry(5555);
			   //Registry registry = LocateRegistry.getRegistry();
			   rmiInterface rmiapi = new rmiapi(main, users, techInterventions);
			   //rmiInterface stub = (rmiInterface) UnicastRemoteObject.exportObject(rmiapi,0);
			   //Naming.rebind("rmi://localhost:5555/Hello", rmiapi);
	            //rmiInterface rmiI = rmiapi;
	           registry.bind("RMIAPI", rmiapi);
			   
			   //api.getReceipts();
			  
			   server.addHandler("GMain", api);
			   server.start();
		} catch (Exception exception) {
			   System.err.println("JavaServer: " + exception);
		}
		
		
		
	
	}

	
}
