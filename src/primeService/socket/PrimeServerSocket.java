package primeService.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import primeService.util.Debug;


/** PrimeServerSocket --  Class ovverides run method of runnable intrface and creates
 * 							thread for PrimeServerWorker
 * Author-- 	Pravin Nagare
 */
public class PrimeServerSocket implements Runnable {
	Debug debug = Debug.getInstance();
	int port;
	public PrimeServerSocket(int port){
		debug.printToStdout(1, "Constructor of PrimeServerSocket class is called");
		this.port = port;
	}


	/**@param 		No Arguments
	 * @exception 	IOException
	 */ 	
	@SuppressWarnings("resource")
	public void run(){ 
		debug.printToStdout(3, "run of PrimeServerSocket class is called");
		ServerSocket serverSocket = null;
		Socket handle2Client = null;
		
		try{
			serverSocket = new ServerSocket(port);
			debug.printToStdout(4, "Server socket created");
		}catch (IOException e)  { 
		   System.err.println("Could not listen on port:"+ port); System.exit(1); 
		 }finally {
		 }
				
		while(true){
			try { 
				  handle2Client = serverSocket.accept();
				  PrimeServerWorker pm = new PrimeServerWorker(handle2Client);
				  //pm.callServerWorker();
				  Thread th = new Thread(pm);
				  th.start();
			}catch (IOException e) { 
				try{
					handle2Client.close();
				} catch (IOException e1) {
					System.err.println("Error in socket closing"); System.exit(1);
				}
				System.err.println("Error in socket accept");
				System.exit(1);
			}finally {
				
			}			
		}
	}
}