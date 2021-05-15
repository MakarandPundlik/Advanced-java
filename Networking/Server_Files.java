//a server program which accepts list of filename from client & will dispatch the message about
//the availability of file on server

import java.net.*;
import java.io.*;

class Server_Files
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(5002);
		System.out.println("Now listening to the server "+ss.getLocalPort());
		
		Socket cs = ss.accept();//client socket
		System.out.println("CLient with address "+cs.getInetAddress()+" is connected through port "+cs.getLocalPort());
		
		//reserve the buffer to accept the filenames
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		String filenames = fromclient.readLine();
		System.out.println(filenames);
		
		//the filenames sent by client are in string with space delimiter
		//so to create an array of filenames from given string use split() of String class
		
		String[] arr_files = filenames.split(" ");
		
		String content = "Status of files is:-\n";
		
		for(int i=0;i<arr_files.length;i++)
		{
			//create a file object using filename
			File f = new File(arr_files[i]);
			
			if(f.exists())//boolean method
				content+="File "+arr_files[i]+" is available on server\n";
			
			else 
				content+="File "+arr_files[i]+" is unavailable on server\n";
		}
		//now dispatch the status to the client
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(),true);
		toclient.println(content);
		toclient.close();
		fromclient.close();
		cs.close();
		ss.close();
	}
}