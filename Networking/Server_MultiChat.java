/*
	A server program to chat with multiple clients 
	Herer client program is the same.
	Also instead of chatting this time the server will echo the message sent by the client
	The conversation with particular client is terminated if client says bye
*/

import java.net.*;
import java.io.*;

public class Server_MultiChat
{
	//reserve a port on a server
	ServerSocket ss = new ServerSocket(5003);
	int id = 0;//new unique id will be assigned to each client to identify him
	
	public static void main(String[] args) throws IOException
	{
		new Server_MultiChat();
	}
	
	/*If the input and output operations are done in called method i.e. in this case the constructor
	then even the calling method should hanle the checked exception*/
	Server_MultiChat() throws IOException
	{
		//new clients are visiting continuosly to the server 
		
		while(true)
		{
			id++;
			//accept a request of client and create a reference for him using new Thread
			ClientThread ct = new ClientThread(ss.accept(),id);//return type of accept() is Socket
			Thread t = new Thread(ct);
			t.start();
		}
	}
}

/*As ClientThread is implementing Runnable interface it is eligible to be used with the constructor of Thred class
Also in above code creating a Thread using Thread class is not required is ClientThread inherits the Thread
In practice it is good habit to implement Runnable as java does not support multiple inheritance*/

class ClientThread implements Runnable
{
	Socket cs ;//every client will get same reference of the ServerSocket
	int id;
	
	ClientThread(Socket cs,int id)
	{
		this.cs = cs;
		this.id = id;
	}
	
	public void run()
	{
		try
		{
			//reserve the buffer on server for message to be received from client
			BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintWriter toclient = new PrintWriter(cs.getOutputStream(),true);
			
			//now the client has been connected to the server so send him a welcome message
			toclient.println("Welcome to the chatcord client"+id);
			
			//now the client will send a message to the server which is to be eched back, and this goes on
			while(true)
			{
				String c = fromclient.readLine();
				System.out.println("Client"+id+" :- "+c);
				
				if(c.contains("bye"))
					break;
				
				toclient.println(c);
			}
			System.out.println("Conversation with client"+id+" is terminated");
			toclient.close();
			fromclient.close();
			cs.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}