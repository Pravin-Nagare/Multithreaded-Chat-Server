package primeService.socket;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

import primeService.client.ClientMenu;
import primeService.util.Debug;

/** PrimeClientSocket --  Class ovverides run method of runnable interface and creates
 * 							thread for PrimeClientWorker
 * Author-- 	Pravin Nagare
 */
public class PrimeClientSocket implements Runnable {

	String hostName;
	Integer port;
	Debug debug = Debug.getInstance();
	public PrimeClientSocket(String hostName,int port){
		debug.printToStdout(1, "Constructor of PrimeClientSocket class is called");
		this.hostName = hostName;
		this.port = port;
	}


	/**@param 		No Arguments
	 * @exception 	IOException, UnknownHostException
	 */ 	
	@SuppressWarnings("null")
	public void run() {
		debug.printToStdout(2, "run method of PrimeClientSocket class is called");
		Socket clientSocket=null;
		
		
		try{
			clientSocket = new Socket(this.hostName,this.port);
			debug.printToStdout(4, "Client socket created");
		}catch(UnknownHostException uh){
			System.err.println("Error: Unkown Host.");System.exit(1);
		}catch (IOException e)  { 
			try {
				clientSocket.close();
			} catch (IOException e1) {
				
				System.err.println("Error in socket closing"); System.exit(1);
			}
		    System.err.println("Could not connect on port:" +  port); System.exit(1); 
		}
		finally {
		   
		 }
		
		PrimeClientWorker clientWorker = new PrimeClientWorker(clientSocket);
		ClientMenu clMenu = new ClientMenu(clientWorker);
		clMenu.display();		
	}	
}