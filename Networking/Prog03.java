//URL uniform resource locator
//an example of WEB URL class and its uniform methods 
//live connnection is not required

import java.net.*;
class Prog03
{
	public static void main(String[] args) throws MalformedURLException
	{
		String url_adr = "http://www.microsoft.com:8080/aboutus.html";
		URL url = new URL(url_adr);
		
		System.out.println("Protocol used is:- "+url.getProtocol());
		System.out.println("Host name is:- "+url.getHost());
		System.out.println("Port used is:- "+url.getPort());
		System.out.println("File name is:- "+url.getFile());
	}
}