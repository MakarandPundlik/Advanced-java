//an example of a simple bean which stores information about a person

import java.io.Serializable;//interface

public class Person implements Serializable
{
	//define attributes
	private String name;
	private boolean deceased;// deceased is a property which determines whther the person is alive or not
	
	//default constructor
	public Person()
	{
		//nothing here as of now
	}
	
	//define getter and setter methods
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDeceased(boolean d)
	{
		deceased = d;
	}
	
	public String getName()
	{
		return name;
	}
	public boolean getDeceased()
	{
		return deceased;
	}
}