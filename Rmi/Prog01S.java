//server

import java.rmi.*;//RemoteException,Remote Interface
import java.rmi.server.*;//UnicastRemoteObject
import java.rmi.registry.*;

public class Prog01S extends UnicastRemoteObject implements Prog01I
{
	//default constructor
	public Prog01S() throws RemoteException
	{
		System.out.println("Server object has been created");
	}
	
	//override the method of interface
	public String getMessage() throws RemoteException
	{
		System.out.println("A method on the server has been called.");
		return "Welcome to the RMI programming";
	}
	
	//create an object of server class and make it available for RMI registry
	public static void main(String[] args) 
	{
		try
		{
			Registry reg = LocateRegistry.createRegistry(5455);
			Prog01S obj = new Prog01S();
			
			reg.rebind("refvar1",obj);//Object of Prog01S is now available in RMI registry eith name refvar1
			
			System.out.println("Server object successfully bound to RMI registry");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}