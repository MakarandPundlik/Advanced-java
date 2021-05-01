//write a program to find out the IP address of a current machine

import java.net.*;
class Prog01
{
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress ipadr = InetAddress.getLocalHost();//factory method
		//localhost is the name assigned by the OS to the local machine
		System.out.println("IP address of this machine is :-"+ipadr);
		String name = ipadr.getHostName();
		String adr = ipadr.getHostAddress();
		
		System.out.println("Name of this machine is:-"+name);
		System.out.println("IP address of this machine is:-"+adr);
	}
}