//an example on LinkedHashSet Collection
/*This collection is similar to the hasset but returns the elements in same order
in which they were stired in the collection */

import java.util.*;

class Prog11
{
	public static void main(String[] args)
	{
		LinkedHashSet<Character> hs = new LinkedHashSet<Character>();
		
		
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