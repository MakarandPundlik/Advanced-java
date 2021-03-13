//an example of a bean cart which stores an info of an item from shopping cart

package beans;
public class Items implements java.io.Serializable
{
	private String name;
	private int total,qty,rate;
	
	public Items()
	{
		
	}
	//getter and setter methods
	public void setName(String n)
	{
		name=n;
	}
	public void setQty(int q)
	{
		qty = q;
	}
	public void setTotal(int ttl)
	{
		total = ttl;
	}
	public void setRate(int r)
	{
		rate = r;
	}
	
	public String getName()
	{
		return name;
	}
	public int getRate()
	{
		return rate;
	}
	public int getQty()
	{
		return qty;
	}
	public int getTotal()
	{
		return total;
	}
}