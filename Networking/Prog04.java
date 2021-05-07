//to accept domain name from user and display all its contents 
//live connection is required

import java.net.*;
import java.io.*;//data will flow in the form of stream from website to user's machine
import java.util.Scanner;
import java.util.Date;

class Prog04 
{
	public static void main(String[] args) throws IOException,MalformedURLException
	{
		//create an object of Scanner class to get webaddress from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the URL to the website:- ");
		String url_adr = sc.next();
		
		//create an URL object
		URL url = new URL(url_adr);
		//open connection
		URLConnection urlc = url.openConnection();
		
		//validation - whether the resouce is available or not
		int len = urlc.getContentLength();
		
		if(len!=0)
		{
			System.out.println("Resource found");
			System.out.println("Length of the response is "+len);
			System.out.println("Date of the response if "+new Date(urlc.getDate()));//getDate() returns a particular number
																					//which may be number of seconds passed after particular date
																					
	
			//to display content get i/p stream
			InputStream ip = urlc.getInputStream();
			System.out.println("Resources are");
			while(true)
			{
				int no = ip.read();
				if(no==-1)//EOF
					break;
				
				System.out.print((char)no);
				
			}
				ip.close();
		}
		else System.out.print("No resource found");
	}
}