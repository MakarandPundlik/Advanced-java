//a client program which dispatches the filenames to the server to check availability of files

import java.net.*;
import java.io.*;

class Client_Files
{
	public static void main(String[] args) throws IOException,UnknownHostException
	{
		Socket cs = new Socket("DESKTOP-R1N41NB",5002);
		
		System.out.println("Client is now connected to the port "+cs.getLocalPort());
		
		//reserve the buffer to accept the filenames
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the filenames with space:-");
		String filenames = fromclient.readLine();
		
		//dispatch the filename to the server
		PrintWriter toserver = new PrintWriter(cs.getOutputStream(),true);
		toserver.println(filenames);
		
		//the moment filename reaches the server it will immediately respond with the message & sned the message
		//collect this message in the buffer of client
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		//we are unware as to how much data is sent by the server
		while(true)
		{
			String line = fromserver.readLine();
			
			if(line==null)
				break;
			
			System.out.println(line);
		}
		fromserver.close();
		toserver.close();
		fromclient.close();
		cs.close();
	}
}