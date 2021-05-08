//client program which will communicate with server to get date and time

import java.net.*;//Socket class
import java.io.*;//PW IoException


class Client_Dt
{
	public static void main(String[] args) throws IOException
	{
		//create a client socket to communicate back and forth with server
		Socket cs = new Socket("DESKTOP-R1N41NB",9090);//both programs are developed by same developer 
		
		//to confirm- not compulsory
		System.out.println("Connected to port"+cs.getLocalPort());
		
		//once client communicate with server the server will respond immediately by sending message
		//collect this message in client's buffer (special memory)
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		//getInputStream() returns the byte stream whereas the bufferedreader constructor accepts only
		//character stream 
		String msg = fromserver.readLine();
		System.out.println(msg);
		fromserver.close();
		cs.close();
	}
}