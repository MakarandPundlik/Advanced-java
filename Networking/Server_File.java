//a java program which accepts a filename from client and it file exists sends its content to the client
import java.net.*;
import java.io.*;

class Server_File
{
	public static void main(String[] args) throws IOException
	{
		//reserve port for this service
		ServerSocket ss = new ServerSocket(6969);
		
		//to check not compulsory
		System.out.println("Listening to the port "+ss.getLocalPort());
		
		//now server is waiting for client to connect
		Socket cs = ss.accept();//here serversocket is listener waits for client to connect
		//once it connects it returns the Socket object through which both can communicate
		System.out.println("Client with address "+cs.getInetAddress()+" is now communicating through port no "+cs.getPort());
		
		//client sents filename collect its buffer in the server 
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));//filename comes from client socket i.e. cs
		
		String filename = fromclient.readLine();
		//to store the contents of file
		String content = "";
		
		try
		{
			FileInputStream fin = new FileInputStream(filename);
			System.out.println("File "+filename+" found on the server");
			while(true)
			{
				int no = fin.read();
				if(no==-1)
					break;
				
				content+=(char)no;
			}
		}
		catch(FileNotFoundException e)
		{
			content="File "+filename+" not found on server";
		}
		
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(),true);
		toclient.println(content);
		toclient.close();
		cs.close();
		ss.close();
	}
}