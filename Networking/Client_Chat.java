//a client side program for chatting with server

import java.net.*;
import java.io.*;

class Client_Chat
{
	public static void main(String[] args) throws IOException,UnknownHostException
	{
		Socket cs = new Socket("DESKTOP-R1N41NB",5003);
		System.out.println("Client is now connected to the port "+cs.getLocalPort());
		
		//reserver the buffer for sending/accepting messages
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		PrintWriter toserver = new PrintWriter(cs.getOutputStream(),true);
		
		//client had communicated woth server and server has dipatched welcome message to the client to be displayed
		//this communication of client and server will continue 
		
		while(true)
		{
			String s = fromserver.readLine();
			System.out.println("Server:- "+s);
			if(s.equalsIgnoreCase("bye"))
				break;
			
			System.out.print("Client:- ");
			String c = fromclient.readLine();
			toserver.println(c);
			if(c.equalsIgnoreCase("bye"))
				break;
			
		}
		toserver.close();
		fromserver.close();
		fromclient.close();
	}
}