//design the hashtable to store the name/percentage pair of students and display the all records
//along with the data of the students whi has scored maximum percentage

import java.util.*;

class Prog07
{
	public static void main(String[] args)
	{
		//use generics for safety
		Hashtable<String,Double> ht = new Hashtable<String,Double>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number if records:-");
		int nor = sc.nextInt();
		
		for(int i=0;i<nor;i++)
		{
			System.out.print("Enter the name of student:-");
	
			String name = sc.nextLine();
			System.out.print("Enter the percentage of student:-");
			double per = sc.nextDouble();
			
			//Hashtable uses put() to store data and not add() which stores data sequencially 
			//put() will internally request the hash() to place the name in unique location
			
			ht.put(name,per);//auto boxing pdt double->Object Double
		}
		
		/*
		Hashtable does not have its own method to iterate over collection
		So we use Enumeration interface to collect the keys from hashtable
		*/
		
		Enumeration<String> e = ht.keys();
		String name1="";
		double per1=0;
		while(e.hasMoreElements())
		{
			String name = e.nextElement();
			double per = ht.get(name);//pass key to hashtable to get values
			
			if(per>per1)
			{
				per1=per;
				name1=name;
			}
			System.out.println(name+"\t"+per);
		}
		System.out.println(name1+" has scored maximum percentage with "+per1);
		}
} 