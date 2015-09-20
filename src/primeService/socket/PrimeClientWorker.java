package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.util.Debug;

/** PrimeClientWorker --  Class communicates with server
 * Author-- 	Pravin Nagare
 */

public class PrimeClientWorker {
		
	Debug debug = Debug.getInstance();
	Socket clientSocket = null;
	BufferedReader inFromServer = null;
	PrintWriter outToServer = null;

	public PrimeClientWorker(Socket socket){ 
		debug.printToStdout(1, "Constructor of PrimeClientWorker class is called");
		clientSocket = socket;
	}

	/**To communicate with server
	 * @param 		String
	 * @exception 	IOException
	 * @return 		String
	 */ 	
	public String sendToServer(String message) {
		debug.printToStdout(2, "sendToServer of PrimeClientWorker class is called");
		String fromServer = null;
		
		try{
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
			
			outToServer.println(message);
			outToServer.flush();
			
			fromServer = inFromServer.readLine();
			debug.printToStdout(4, "Server Message: " + fromServer);
		}catch(IOException ie){
			//ie.printStackTrace();
			try {
				clientSocket.close();
			} catch (IOException e1) {
				
				System.err.println("Error in socket closing"); System.exit(1);
			}
			System.err.println("Error: Lost connectiom to server");
			System.exit(0);
		}
		finally{
			
		}
		return fromServer;
	}	
}
