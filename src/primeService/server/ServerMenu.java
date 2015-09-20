package primeService.server;

import java.util.InputMismatchException;
import java.util.Scanner;

import primeService.util.Debug;


/** ServerMenu --  To display menu on server side
 * Author-- 	Pravin Nagare
 */
public class ServerMenu implements ServerMenuInterface {

	Debug debug = Debug.getInstance();
	public ServerMenu(){
		debug.printToStdout(1, "Constructor of SereverMenu class is called");
	}
	/**Display menu on server side
	 * @param 		No Arguments
	 * @exception 	NumberFormatException, InputMismatchException
	 */
	public void display() {
			String name;
			Integer choice=0;
			Scanner sc = new Scanner(System.in);
			AllPrimeQueries allPQ = AllPrimeQueries.getInstance();
			while(true){
				try{
				System.out.println("[1] Client name \n[2] All Client Queries \n[3] Quit");
		
				choice = sc.nextInt();
				
				switch(choice){
					case 1: System.out.println("Enter Name:");
							name = sc.next();
							allPQ.displaySingleEntry(name);
							break;
					case 2: allPQ.displayAllEntries();
							break;
					case 3: System.out.println("Exiting...");
							sc.close();
							
							System.exit(0);
					default: System.out.println("Invalid Input");break;
				}
				}catch(InputMismatchException ie){
					System.out.println("Invalid Input Type"); System.exit(1);
				}catch(NumberFormatException ie){
					System.out.println("Invalid Input. Select correct option");System.exit(1);
				}
			}
	}
}