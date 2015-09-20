package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;

import primeService.server.AllPrimeQueries;
import primeService.util.CheckPrime;
import primeService.util.Debug;


/** PrimeServerWorker --  Class communicates with client
 * Author-- 	Pravin Nagare
 */
public class PrimeServerWorker implements Runnable {

	Debug debug = Debug.getInstance();
	Socket handle2Client;
	String fromClient=null, num=null, message=null;
	String[] name=null;
	final Integer THRESHOLD = 3;
	BufferedReader inFromClient = null;
	PrintWriter out = null;
	AllPrimeQueries allPQ = AllPrimeQueries.getInstance();
	
	public PrimeServerWorker(Socket handle2Client) {
		debug.printToStdout(1, "Constructor of PrimeServerWorker class is called");
		this.handle2Client = handle2Client;
	}
	
	

	/**@param 		No Arguments
	 * @exception 	IOException
	 */ 	
	public void run() {
		
		debug.printToStdout(3, "run of PrimeServerWorker class is called");
		CheckPrime chkPrime = new CheckPrime();
		String isPrime;		
		while(true){
			try{
				
				inFromClient = new BufferedReader(new InputStreamReader(handle2Client.getInputStream()));
				out = new PrintWriter(handle2Client.getOutputStream(), true);
			
			message = inFromClient.readLine();
			debug.printToStdout(4, "Client message: " + message);
			name = message.split(":");
			
			allPQ.addEntry(name[0], Integer.parseInt(name[1]));
			
			//System.out.println("From Client:" + message);
			if(Integer.parseInt(name[1]) < THRESHOLD){
				out.println("Not Valid");
			}
			else{
				isPrime = chkPrime.isPrime(Integer.parseInt(name[1]));
				if(isPrime.equals("true")){
					out.println("Prime");
					out.flush();
				}
				else{
					out.println("Not Prime");
					out.flush();
				}
			}
		}catch(Exception ie){
			break;
		}finally{
			
		
		}
	}
		Thread.currentThread().interrupt();
	}
}