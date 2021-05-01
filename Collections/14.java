//an example of stack collection
//this collection works on LIFO principle
import java.util.*;
class Prog14
{
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		s.push("Makarand");
		s.push("Chogi");
		s.push("Tanmay");
		s.push("Kaustubh");
		s.push("Odu");
		
		System.out.println("Contents of stack are:-");
		for(int i=s.size()-1;i>=0;i--)
			System.out.print(s.get(i)+"\t");
	}
}