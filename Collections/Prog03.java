//an example of LinkedList collection to store the data of an employee
import java.util.*;

class Prog03
{
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		
		l.add(123);//auto boxing
		l.addLast("Joshi");// add() and addLast() are same, the advantage of add() is that it is overloaded and we can add	
						   // data/node in between
						   
		l.add(1,"sunil");
		//l.addFirst(123);//ok in case if we want to add it later OR l.add(123);
		
		//to display all the items of l 
		System.out.println(l);
		l.addLast(1000.35);//auto boxing pdt double->Object Double
		
		l.removeFirst();
		
		//to confirm by dusplaying each node
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i));
	}
}