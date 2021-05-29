//write an RMI application in which server sends string message on invocation of method of object on server

//interface on the server
import java.rmi.*;

public interface Prog01I extends Remote
{
	//a method to send a welcome message to the circuit 
	//interface contains abstract methods only
	
	public String getMessage() throws RemoteException;
	//all methods of interface are abstract 
	//RemoteException is a checked exception
}
