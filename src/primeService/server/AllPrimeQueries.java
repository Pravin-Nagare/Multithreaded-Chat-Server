package primeService.server;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import primeService.util.Debug;


/** AllPrimeQueries --  Singleton class to create data structure and store user data
 * Author-- 	Pravin Nagare
 */

public class AllPrimeQueries {
	
	Debug debug = Debug.getInstance();
	ConcurrentMap<String, List<Integer>> hash = new ConcurrentHashMap<String, List<Integer>>();
	private volatile static AllPrimeQueries uniqueInstance;
	    	
	private AllPrimeQueries() { 
		debug.printToStdout(1, "Constructor of AllPrimeQueries class is called");
	}
	
	/**
	 * @param 		No Arguments
	 * @exception 	No Exception
	 * @return		AllPrimeQueries
	 */ 
	public static AllPrimeQueries getInstance() {
			if(uniqueInstance == null){
				synchronized (AllPrimeQueries.class){
					uniqueInstance = new AllPrimeQueries();
				}
			}
			return uniqueInstance;
	 }

	/**
	 * @param 		No Arguments
	 * @exception 	No Exception
	 */ 
	public void displayAllEntries(){
		debug.printToStdout(3, "displayAllEntries of AllPrimeQueries class is called");
		for(Map.Entry<String, List<Integer>> entry: hash.entrySet()){
			String key = entry.getKey();
			List<Integer> val = entry.getValue();
			System.out.println( key + ": " + val);
		}
	}
	
	/**
	 * @param 		String
	 * @exception 	No Exception
	 */ 
	public void displaySingleEntry(String name){
		debug.printToStdout(3, "displaySingleEntry of AllPrimeQueries class is called");
		if(hash.get(name) == null){
			System.out.println(name + "not present in hash table");
			return;
		}		
		System.out.println(name+" " + hash.get(name));
	}
	
	/**
	 * @param 		String, Integer
	 * @exception 	No Exception
	 */ 
	public void addEntry(String name, Integer val){
		debug.printToStdout(3, "addEntry of AllPrimeQueries class is called");
		if(hash.containsKey(name)){
			hash.get(name).add(val);
		}else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(val);
			hash.put(name, list);
		}		
	}
}
