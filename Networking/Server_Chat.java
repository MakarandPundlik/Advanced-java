//server program for one-one chatting 
//chatting should continue till either one of them says bye

import java.net.*;
import java.io.*;

class Server_Chat
{
	public static void main(String[] arsg) throws IOException
	{
		ServerSocket ss = new ServerSocket(5003);
		System.out.println("Now listening to the server "+ss.getLocalPort());
		
		Socket cs = ss.accept();
		System.out.println("Client with address "+cs.getInetAddress()+" is now connect to the port "+cs.getLocalPort());
		
		//reserve the buffer to accept/send data at/from server
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(System.in));//messaged it to bw e typed on the server
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));//message from client
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(),true);//send messages to cleint
		
		//now client has communicated & server should pass him/her a welcome message
		toclient.println("Welcome to the chat application");
		
		//now client will respond followed by server and this cycle will continue
		while(true)
		{
			String c = fromclient.readLine();
			System.out.println("Client:- "+c);
			if(c.equalsIgnoreCase("bye"))
				break;
			
			System.out.print("Server :-");
			String s = fromserver.readLine();
			toclient.println(s);
			
			if(s.equalsIgnoreCase("bye"))
				break;
		}
		toclient.close();
		fromclient.close();
		fromserver.close();
		
	}
}