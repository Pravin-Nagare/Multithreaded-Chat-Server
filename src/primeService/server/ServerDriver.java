package primeService.server;
import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

/** ServerDriver--	  	Creates Thread for PrimeServerSocket and calls client menu
 * 
 * Author-- 	Pravin Nagare
 */

public class ServerDriver {
		
		Debug debug = Debug.getInstance();
		int port;
		public ServerDriver(int port){
			debug.printToStdout(1, "Constructor of ServerDriver class is called");
			this.port=port;
		}

		/** Method to create thread for PrimeServerSocket
		 * @param 		No Arguments
		 * @exception 	No Exception
		 */

		public void callServerDriver() {
			debug.printToStdout(3, "callServerDriver of ServerDriver class is called");
			PrimeServerSocket ps = new PrimeServerSocket(port);
			Thread T = new Thread(ps);
			//ps.createSocket(port);
			T.start();

			ServerMenu srMenu = new ServerMenu();
			srMenu.display();
		}
}
