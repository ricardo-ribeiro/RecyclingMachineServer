import com.perisic.beds.*;
import org.apache.xmlrpc.*;
import uk.ricardoribeiro.GMain;
import uk.ricardoribeiro.xmlapi;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *
 */
public class SimpleTester {
	
	public static void main(String [] args) { 
		
		try {
			   System.out.println("Starting the Server..."); 
			   WebServer server = new WebServer(3333);
			   GMain main = new GMain();
			   xmlapi api = new xmlapi(main);
			   api.getReceipts();
			   server.addHandler("GMain", api);
			   server.start();
		} catch (Exception exception) {
			   System.err.println("JavaServer: " + exception);
		}
	
	}
}
