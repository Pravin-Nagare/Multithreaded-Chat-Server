package primeService.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import primeService.socket.PrimeClientWorker;
import primeService.util.Debug;


/** ClientMenu --  To display menu for client
 * Author-- 	Pravin Nagare
 */

public class ClientMenu implements ClientMenuInterface{
	PrimeClientWorker clientWorker = null;
	Debug debug = Debug.getInstance();
	public ClientMenu(PrimeClientWorker clientWorker) {
		debug.printToStdout(1, "Constructor of ClientMenu class is called");
		this.clientWorker = clientWorker;
	}
	
	/**Display menu for client
	 * @param 		No Arguments
	 * @exception 	NumberFormatException, InputMismatchException
	 */
	public void display() {
		debug.printToStdout(2, "display of ClientMenu class is called");
		String name = null,  response=null;
		Integer num=0;
		Integer choice;
		Scanner sc = new Scanner(System.in);
		while(true){
		try{		
		System.out.println("[1] Set client name \n [2] Enter number to query for prime \n [3] What is the server response? \n [4] Quit");
		
		choice = sc.nextInt();
		switch(choice){
			case 1: System.out.println("Enter Name:");
					name = sc.next();break;
			case 2: System.out.println("Enter Number:");
					try{
						num = sc.nextInt();
					}catch(InputMismatchException ie){
						System.err.println("Invalid Input Type");
						System.exit(1);
					}
					response = clientWorker.sendToServer(name+":"+num.toString());
						
					break;
			case 3: System.out.println("<Value> " + num + " <Response> " + response);
					break;
			case 4: System.out.println("Exiting...");
					sc.close();
					System.exit(0);
 		}
		}catch(NumberFormatException nm){
			System.err.println("Invalid Input Type");
			 System.exit(1);
		}catch(InputMismatchException ie){
			System.err.println("Invalid Input. Select correct option");
			System.exit(1);
		}
		
	}
  }
}