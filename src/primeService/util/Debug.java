package primeService.util;

/** Debug --  To check the flow of program
 * Author-- 	Pravin Nagare
 */
public class Debug {
	
	public static int DEBUG_VALUE;
	
	private volatile static Debug debug;
	private Debug(){
		
	}
	
	/**@return		Debug	 		
	 * @param 		No Arguments
	 * @exception 	No Exception
	 */
	public static Debug getInstance() {
			if(debug == null){
				synchronized (Debug.class){
					debug = new Debug();
				}
			}
			return debug;
	 }
	
	/**		
	 * @param 		Integer, String
	 * @exception 	No Exception
	 */
	
	public void printToStdout(int level,String debugMessage){
	if(level==DEBUG_VALUE){
		System.out.println(debugMessage);
	}
	
	}
}