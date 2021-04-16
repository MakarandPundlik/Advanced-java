//using generics to store the data of user defined types in a linkedlist

import java.util.*;

class Student //user defined class
{
	int roll_no;
	String name;
	double per;
	
	public Student(int r,String n,double p)
	{
		roll_no=r;
		name=n;
		per=p;
	}
	//override toStriing() of an Object class
	public String toString()
	{
		return roll_no+","+name+","+per;
	}
}

class Prog04
{
	public static void main(String[] args)
	{
		LinkedList<Student> l = new LinkedList<Student>();
		l.add(new Student(1,"Ramesh",35.90));
		l.add(new Student(2,"Suresh",90.35));
		l.add(new Student(3,"Mohit",76.45));
		l.add(new Student(4,"Rohit",90.35));
		l.add(new Student(5,"Paresh",76.45));
		
		System.out.println("l contains "+l);
		//to display record of each student on separate line
		//foreach loop - the advantage if this loop is that we need not to mention fot how
		//many times it has to iterate
		
		for(Student s:l) //for every s in l which is of type Student do following
			System.out.println(s);
		/*
			Here we cannot print the data of object of undefined type directly
			because it contains multiple value and JRE will not know which values are to be displayed and in what order
			Here toString() of an Object clas (super class of all classes) is called which prints address of object in
			its memory and not its data
		*/
	}
}