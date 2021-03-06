import java.util.Scanner;

class Prog02 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the total amount :- ");
		String ttl = sc.next();
		
		System.out.print("Enter the tax rate in your region :- ");
		String tax = sc.next();
		
		//create an object of TaxCalculation interface
		TaxCalculation tx = new TaxCalculation();
		
		tx.setTotal(ttl);
		tx.setTaxes(tax);
		
		System.out.println("Total tax payable Rs"+tx.getTaxamount());
		System.out.println("Your total bill is Rs"+tx.getTotalamount());
	}
}