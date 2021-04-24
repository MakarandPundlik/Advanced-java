//define a hastable to store the empid,name, salary and age of employee
/*
	This seams impossible initially because hashtable can only store key value pairs
	However here we can use empid as a key (as they are unique) and value can be represented as a object of user defined
	class Employee with attributes name,age and salary
*/

import java.util.*;

class Employee
{
	private String name;
	private int age;
	private double salary;
	
	public Employee(String n,int a,double s)
	{
		name = n;
		age = a;
		salary = s;
	}
	
	public String toString()
	{
		return name+" "+age+" "+salary;
	}
}

class Prog09
{
	public static void main(String[] args)
	{
		Hashtable<Integer,Employee> ht = new Hashtable<Integer,Employee>();
		
		ht.put(1,new Employee("Suresh",35,60000.32));
		ht.put(2,new Employee("Bhausaheb",23,18000.32));
		ht.put(3,new Employee("Sandesh",37,50000.32));
		ht.put(4,new Employee("Paresh",20,46000.32));
		ht.put(5,new Employee("Makarand",26,63000.32));
		ht.put(6,new Employee("Ramesh",27,61000.32));
		ht.put(7,new Employee("Adesh",25,65000.32));
		
		Enumeration<Integer> e = ht.keys();
		
		while(e.hasMoreElements())
		{
			Integer key = e.nextElement();
			Employee emp = ht.get(key);
			System.out.println(key+" "+emp);
		}
	}

}