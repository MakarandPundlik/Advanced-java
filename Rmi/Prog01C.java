//client side program

import java.rmi.*;

class Prog01C
{
	public static void main(String[] args)
	{
		try
		{
			//obtain a refernce to the server object from RMI registry using interface implemented bu Server class
		
		Prog01I obj = (Prog01I)Naming.lookup("rmi://localhost:5455/refvar1"); //typecasting
		
		//now invoke the method of server object 
		System.out.println("Message from server is:-");
		System.out.println(obj.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}