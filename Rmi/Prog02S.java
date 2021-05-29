//server

import java.rmi.*;
import java.rmi.registry.*;//to create local registry 
import java.rmi.server.*;//UnicastRemoteObject 

public class Prog02S extends UnicastRemoteObject implements Prog02I
{
	public Prog02S() throws RemoteException
	{
		
	}
	
	public int getSum(int a,int b) throws RemoteException
	{
		System.out.println("A server method has been called.");
		return a+b;
	}
	
	public static void main(String[] args)
	{
		try
		{
			Registry reg = LocateRegistry.createRegistry(5455);//local registry
			Prog02S obj = new Prog02S();
			reg.rebind("refvar2",obj);
			System.out.println("Server object successfully bound to registry.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}