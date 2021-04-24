//an example on TreeSet Collection
/*This collection is similar to the hashset but returns the elements ascending order*/

import java.util.*;

class Prog12
{
	public static void main(String[] args)
	{
		TreeSet<Character> hs = new TreeSet<Character>();
		
		
		hs.add('C');
		hs.add('O');
		hs.add('N');
		hs.add('T');
		hs.add('A');
		hs.add('I');
		hs.add('N');
		hs.add('E');
		hs.add('R');
		
		
		Iterator it = hs.iterator();
		
		System.out.println("Elements of set are:-");
		while(it.hasNext())
			System.out.println(it.next());
	}
}