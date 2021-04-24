//an example on hashset
/*This collection is backed by the hashtable and can be used to store single value only without duplicats
not pairs like hashtable*/

import java.util.*;

class Prog10
{
	public static void main(String[] args)
	{
		HashSet<Character> hs = new HashSet<Character>();
		//being a set we have use set.add() and not set.put() like hashtable
		
		hs.add('C');
		hs.add('O');
		hs.add('N');
		hs.add('T');
		hs.add('A');
		hs.add('I');
		hs.add('N');
		hs.add('E');
		hs.add('R');
		
		System.out.println("Set contains "+hs);//like hashtable elements of hashset may not be 
		//displayed in the order in which they were stored
		
		//in case we need to refer to every element of a set then obtain a iterator
		Iterator it = hs.iterator();
		
		System.out.println("Elements of set are:-");
		while(it.hasNext())
			System.out.println(it.next());
	}
}