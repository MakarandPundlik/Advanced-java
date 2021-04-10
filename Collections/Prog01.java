//example -1 of Vector collection to store the elements, data of an employee

import java.util.Vector;

class Prog01
{
	public static void main(String[] args)
	{
		Vector v = new Vector(3);//it can accept "n" elements
		//Because vectors are exapandable at runtime
		//Initial capacity is 3 elements, however when 4th element is added capacity automatically becomes double
		
		v.add(123);//to stiore empid
		//However Collections are designed to operate on Object Types & not PDT
		//Upto version jdk 1.4 we used to get compile error because 123 is an int & not Integer
		//v.add(new Integer(123));
		//from jdk 1.5 the java product was reengineeredwith a feature called "auto boxing"
		//in which int PDT was automatically converted into Object Type
		
		v.add("Amit");//as String is Object type 
		v.add("Pune");
		v.insertElementAt("Joshi",2);
		v.addElement(10000.35);//auto boxing to convert PDT to Double (Object)
		//v.removeElementAt(1);//to delete name i.e Amit
		//v.removeAllElements();//emoty vectors
		
		System.out.println("Elements of vector v are "+v);
		// to access and display each element of vector 
		System.out.println("Elements of vector v are ");
		for(int i=0;i<v.size();i++)
			System.out.println(v.elementAt(i));
			
		
	}
}