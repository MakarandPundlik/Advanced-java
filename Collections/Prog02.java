//Design 2 vectors 1 to hold names ie Strings and other to hold int values only
//sort desc and display
//also display max and min no.s from 2nd vector

import java.util.Vector;
import java.util.Collections;

class Prog02
{
	public static void main(String[] args)
	{
		Vector<String> v1 = new Vector<String>();
		
		v1.add("Makarand");
		v1.add("Swapnali");
		v1.add("Divya");
		v1.add("Shivani");
		v1.add("Akash");
		v1.add("Dhanesh");
		//v1.add(123); //error v1 is designed ti accept strings only and not integer
		v1.add("123");//ok because 123 in enclosed in a string
		
		System.out.println("V1 contains "+v1);
		Collections.sort(v1);//sort is a static() of class Collections
		System.out.println("Names in ascending order are "+v1);
		Collections.reverse(v1);
		System.out.println("In descending order "+v1);
		
		Vector<Integer> v2 = new Vector<Integer>();
		v2.add(45);
		v2.add(-90);
		v2.add(111);
		v2.add(74);
		//v2.add("Mak");//error
		System.out.println("V2 contains :"+v2);
		System.out.println("Maximum element from v2 is: "+Collections.max(v2));
		System.out.println("Minimum element from v2 is: "+Collections.min(v2));
	}
}