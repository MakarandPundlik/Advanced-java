//an example of a generic class which holds a single value of particular type only

import java.util.*;
class General<T>
{
	T type;
	//constructor
	General(T val)
	{
		type=val;
	}
	
	//gneric method
	T getVal()
	{
		return type;
	}
	
	//normal method
	void display()
	{
		System.out.println("Type of T is "+type.getClass().getName());
		System.out.println("Class of T is "+type.getClass().getSimpleName());
	}
}
class Prog15
{
	public static void main(String[] args)
	{
		//General<int> objint = new General<int>(100);//error,generics are designed to work with Object types only
		General<Integer> objint = new General<Integer>(100);//auto boxing
		System.out.println("Value of objint is"+objint.getVal());
		objint.display();
		
		General<String> objstring = new General<String>("Hello World");
		System.out.println("Value of objint is"+objstring.getVal());
		objstring.display();
	}
}