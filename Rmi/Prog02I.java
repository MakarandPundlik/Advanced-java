//write a GUI application to add 2 numbers

import java.rmi.*;

public interface Prog02I extends Remote
{
	public int getSum(int a,int b) throws RemoteException;
}
 