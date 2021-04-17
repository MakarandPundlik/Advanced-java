//define an ArrayList to store a record of a student and display it in either directions

import java.util.ArrayList;

class Prog06
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add(10);//auto boxing
		al.add("Sunil");//String - Object type
		al.add("Joshi");
		al.add(90.35);//auto boxing
		al.add("A+");
		
		//displaying elements from left to right
		//behaviour is like Queue(FIFO)
		int i;
		for(i=0;i<al.size();i++)
			System.out.print(al.get(i)+"\t");
		
		System.out.println();
		
		//displaying elements from right to left
		//behaviour is like stack(LIFO)
		for(i=al.size()-1;i>=0;i--)
			System.out.print(al.get(i)+"\t");
		
		/*
		We have learnt that ArrayList uses internally aray to store its elements.The elements stored in al are heterogenous
		whereas array can store homogenous elements only.So it means, they are using dynamic method dispatch principle
		which says "A superclass reference can refer to a subclass object"
		*/
		
		//To get this data in an array defined by us use toArray()
		Object[] arr  = al.toArray();
		
		//to prove that this array store only references 
		System.out.println("Array arr contains:-");
		for(i=0;i<arr.length;i++)
			System.out.println(arr[i]+"\t"+arr[i].getClass().getName());//original type seen
		
		//to copy elements of array into arraylist
		ArrayList al1 = new ArrayList();
		for(i=0;i<arr.length;i++)
			al1.add(arr[i]);
		
		System.out.println("Elements if al1 are:-"+al1);
	}
}