//a client side program which sends filename to the server and fetches its contents

import java.net.*;
import java.io.*;

class Client_File
{
	public static void main(String[] args) throws IOException,UnknownHostException
	{
		//connect to the port for availing this service
		Socket cs = new Socket("DESKTOP-R1N41NB",6969);
		
		//to confirm,not compulsory
		System.out.println("Client is communicating from port no "+cs.getLocalPort());
		
		//reserve the memory in client side to send the filename
		//use either commandline arg/scanner class/BufferedReader
		 BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Enter filename :- ");
		 String filename = fromclient.readLine();
		 
		 //dispatch filename to the server
		 PrintWriter toserver = new PrintWriter(cs.getOutputStream(),true);
		 toserver.println(filename);
		 
		//client is expecting content from server so to get the conetent reserve the memory
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		System.out.println("Message from server is :- ");
		while(true)
		{
			String line = fromserver.readLine();
			
			if(line==null)
				break;
			System.out.println(line);
		}
		
		fromserver.close();
		fromclient.close();
		cs.close();
	}
}