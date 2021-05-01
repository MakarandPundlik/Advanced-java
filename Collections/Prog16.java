//we can declare Generic method as static
//define a method which accepts arrays of different types from main() and displays them

class Prog16
{
	public static void main(String[] args)
	{
		String[] arrstring = {"Makarand","Tanmay","Chogi","Kaustubh","Odu"};
		Character[] arrchar = {'A','b','c','d','E'};
		Integer[] arrint = {10,20,30,40,50,60};
		int[] arr = {10,20,30,40,50,60};
		//use single method to display all arrays
		display(arrstring);
		display(arrint);
		display(arrchar);
		//display(arr);//inference variable T has incompatible bounds
	}
	static <T>void display(T[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
}