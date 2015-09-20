package primeService.driver;

import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;


/** Driver-- 	Driver class to drive the program
 * 
 * @author Pravin Nagare
 */

public class PrimeDriver {
	public static void main(String args[]){
		
		if(args.length < 3) {
			System.err.println("Error: <Server/Client> <hostname/port> <port>\n");
			System.exit(1);
		}

		if(args[0].equals("server")){
			ServerDriver sd = null;
			try {
					sd = new ServerDriver(Integer.parseInt(args[1]));
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Error: Enter integer port number");
				System.exit(1);
			}
			Debug.DEBUG_VALUE = Integer.parseInt(args[2]);
			sd.callServerDriver();
		}
		else if(args[0].equals("client") && (args.length > 3)){
			ClientDriver cd = null;
			try {
				cd = new ClientDriver(args[1], Integer.parseInt(args[2]));
			} catch (ArrayIndexOutOfBoundsException e){
				System.err.println("Error: Enter integer port number");
				System.exit(1);
			}			
			Debug.DEBUG_VALUE = Integer.parseInt(args[3]);
			cd.callClientDriver();
		}
		else{
			System.err.println("Error: <Server/Client> <hostname/port> <port>\n");
			System.exit(1);
		}			
	}
}
