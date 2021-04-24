//an example on TreeMap collection

/*This collection is similar to the Hashtable which stores the data in key/value pair
but returns data in ascending order*/
//Design a TreeMap to store the name and balance in the account of a customer
//store the data of few customer and alter the balance of 1 of the customers

import java.util.*;

class Prog13
{
	public static void main(String[] args)
	{
		TreeMap<String,Double> tm = new TreeMap<String,Double>();
		tm.put("Ramesh",10000.34);
		tm.put("Suresh",14000.36);
		tm.put("Beenaji",16700.12);
		tm.put("Rahul",15600.60);
		tm.put("Meghana",10600.34);
		tm.put("Arun",40045.34);
		
		System.out.println("Tm contains "+tm);
		
		//eg to alter the balance if beenaji
		//double bal = tm.get("Bina");//NullPointerException - Object not found
		double bal = tm.get("Beenaji");
		bal+=bal*10;
		tm.put("Beenaji",bal);
		System.out.println("After modification tm contains "+tm);
		
		/*To access the individual record the problem is that TreeMap does not support iterator.So work around is obtain the keys 
		of TreeMap on set and then use Iterator on set*/
		Set<String> hs = tm.keySet();
		Iterator<String> it = hs.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			System.out.println(key+"\t"+tm.get(key));
		}
	}
}