//a server program which sends current date and time to the client

import java.net.*;//ServerSocket,Socket class
import java.io.*;//PrintWriter, IoException
import java.util.Date;

public class Server_Dt
{
	public static void main(String[] args) throws IOException
	{
		//reserve a port on server for this customized service
		ServerSocket ss = new ServerSocket(9090);//any number > 1024 and <65536 will do
		
		//to comfirm - not compulsory
		System.out.println("Server has been reserved by port "+ss.getLocalPort()+" for this service");
		
		//create a client socket for client to communicate
		Socket cs = ss.accept();//client socket is only created when client communicates with server
		
		//to confirm - not compulsory
		System.out.println("Client with IP address "+cs.getInetAddress()+" is communicating from "+cs.getLocalPort()+" port");
		
		//now the server has to deliver current date and time to the client
		Date d = new Date();
		String msg = "Current date and time at server is "+d.toString();
		System.out.println(msg);
		//generate the o/p stream to dispatch ti the client
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(),true);//the 2nd parameter is boolean flush 
		//it set to true means send/dispatch data immediately as soon as generated
		//if set to false data is stored in the buffer and can be sent to client using toclinet.flush()
		
		//dispatch data to the client
		toclient.println(msg);
		//close the buffer so that the memory on server becomes free
		toclient.close();
		cs.close();
		ss.close();
		//references are stored on stack ,hence to close in reverse order
	}
}