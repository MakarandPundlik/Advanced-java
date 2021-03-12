//an example of a bean class  to store the simple message and display it in JSP application
//Remember to store these classes in special folder of classes
//for our class application we will make bean subfolder 
//because "classes" is reserved for servlets

package beans;

public class Message implements java.io.Serializable
{
	private String msg;
	
	//public constructor
	public Message() 
	{
		
	}
	//getter and setter methods
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public String getMsg()
	{
		return msg;
	}
}