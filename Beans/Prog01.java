//a profram which makes use of beans

class Prog01
{
	public static void main(String[] args)
	{
		//create an object of Person
		Person p = new Person();
		
		p.setName("Narednra Modi");
		p.setDeceased(false);//alive
		
		System.out.println("My favourite politician is "+p.getName());
		System.out.println("Status "+(p.getDeceased()?"Dead":"Alive"));
	}
}