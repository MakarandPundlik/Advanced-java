//an example of a bean class to store data of employee
package beans;

public class Emp implements java.io.Serializable
{
	private String empname;
	private int empid;
	
	public Emp()
	{
	
	}
	//getter and setter methods
	public void setEmpid(int id)
	{
		empid = id;
	}
	public void setEmpname(String name)
	{
		empname = name;
	}
	
	public int getEmpid()
	{
		return empid;
	}
	public String getEmpname()
	{
		return empname;
	}
}