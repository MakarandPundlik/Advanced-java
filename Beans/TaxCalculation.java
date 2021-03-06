//a bean to perform conversions and backend calculations regarding taxes in billing system

public class TaxCalculation implements java.io.Serializable //shortcut method
{
	private int total;
	private double taxes;
	
	//setter and getter methods
	public void setTotal(String ttl) //Taking string as an input
	{
		total = Integer.parseInt(ttl);
	}
	public void setTaxes(String tx)
	{
		taxes = Double.parseDouble(tx);
	}
	
	public int getTotal()
	{
		return total;
	}
	public double getTaxes()
	{
		return taxes;
	}
	
	//additional method to calculate tax amount and net amount payable
	public double getTaxamount()
	{
		return total*taxes/100;
	}
	public double getTotalamount()
	{
		return getTaxamount()+total;
	}
}