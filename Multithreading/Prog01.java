//an example on threads
//define 3 threads in which each thread prints from 1-15

class A extends Thread //Thread class is part and parcel of java.lang pac
{
	//compulsory to override run()
	//this method of 2 or more threads will run concurrently
	
	public void run()
	{
		System.out.println("Start of thread A");
		for(int i=1;i<16;i++)
		System.out.println("i = "+i);
		System.out.println("End of A's run()");
	}
}
class B extends Thread 
{
	
	public void run()
	{
		System.out.println("Start of thread B");
		for(int j=1;j<16;j++)
		System.out.println("j = "+j);
		System.out.println("End of B's run()");
	}
}
class C extends Thread 
{
	public void run()
	{
		System.out.println("Start of thread C");
		for(int k=1;k<16;k++)
		System.out.println("k = "+k);
		System.out.println("End of C's run()");
	}
}

class Prog01 
{
	public static void main(String[] args)
	{
		//newnborn sate i.e. object of class which inherits 
		//Thread is ben created
		
		A ta = new A();
		B tb = new B();
		C tc = new C();
		
		//runnable state i.e objects are placed in queue
		//and waiting for their turn turn
		
		ta.start();
		tb.start();
		tc.start();
		
		System.out.println("End of main() thread");
		
	}
	
}

/*
	Here the JRE has allocated different time slices to each Thread
	and after that time period it is switching to the next thread
	
	here,we are calling start which in turn calls run(), because when to call run()
	is not decided by the developer bt by the JRE
*/