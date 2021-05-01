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
		
		System.out.println();
		
		//to search for a name in stack
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name :-");
		String name = sc.next();
		
		int pos = s.search(name);
		if(pos==-1)
			System.out.println("Name "+name+" not found in stack");
		
		else
			System.out.println("Name "+name+" found at position "+pos+" from top");
		
		while(!s.isEmpty())
		System.out.println(s.pop());
	}
}