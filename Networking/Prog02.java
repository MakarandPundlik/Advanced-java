//accept a domain name of any website and display its IP address

import java.net.*;
class Prog02
{
	public static void main(String[] args)
	{
		try
		{
			InetAddress ipadr = InetAddress.getByName(args[0]);
			String adr = ipadr.getHostAddress();
			System.out.println("IP address of "+args[0]+" is "+adr);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please enter the domain name");
		}
		catch(UnknownHostException e)
		{
			System.out.println(e.getMessage());
		}
	}
}