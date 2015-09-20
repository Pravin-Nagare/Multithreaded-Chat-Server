package primeService.client;


import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;
/**ClientDriver -- Creates thread for PrimeClientSocket
 * @author pravin
 */
public class ClientDriver {

	int port;	
	String hostName;
	Debug debug = Debug.getInstance();
	public ClientDriver(String hostName, int port) {
		this.port = port;
		this.hostName = hostName;
		debug.printToStdout(1, "Constructor of ClientDriver class is called");
	}

	/** Method to create thread for PrimeClientSocket
	 * @param 		No Arguments
	 * @exception 	No Exception
	 */
	public void callClientDriver() {
		debug.printToStdout(2, "callClientDriver method of ClientDriver class is called");
		PrimeClientSocket pm = new PrimeClientSocket(hostName, port);
		Thread T = new Thread(pm);
		T.start();
		

	}
}

