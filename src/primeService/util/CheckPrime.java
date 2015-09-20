package primeService.util;

/** CheckPrime --  To check if given value is prime
 * Author-- 	Pravin Nagare
 */

public class CheckPrime {	
	
	Debug debug = Debug.getInstance();
	public CheckPrime(){
		debug.printToStdout(1, "Constructor of CheckPrime class is called");
	}
	/**@return		String	 		
	 * @param 		Integer
	 * @exception 	No Exception
	 */ 	
	public String isPrime(int n) {
		debug.printToStdout(3, "isPrime of CheckPrime class is called");
	    if (n%2==0) return "false";
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return "false";
	    }
	    return "true";
	}
}