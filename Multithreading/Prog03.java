//create 3 threads each to print the tables of 5,7 and 13 respectively
//use Runnable interface

class Five implements Runnable
{
	public void run()
	{
		System.out.println("Start of Five thread");
		for(int i=1;i<=10;i++)
			System.out.println("5x"+i+" = "+5*i);
			
		System.out.println("End of Five thread");	
	}
}

class Seven implements Runnable
{
	public void run()
	{
		System.out.println("Start of Seven thread");
		for(int i=1;i<=10;i++)
			System.out.println("7x"+i+" = "+7*i);
			
		System.out.println("End of Seven thread");	
	}
}

class Thirteen implements Runnable
{
	public void run()
	{
		System.out.println("Start of Thirteen thread");
		for(int i=1;i<=10;i++)
			System.out.println("13x"+i+" = "+13*i);
			
		System.out.println("End of Thirteen thread");	
	}
}

class Prog03 
{
	public static void main(String[] args)
	{
		Five f = new Five();
		//f.start();//compiler error no such method
		//Yetserday we had created an object of Thread class
		/*
			Thread class is very intelligent class which contains a lot of code
			which JRE uses to determine whether the CPU is idle or not and uses it to process a thread
			On the other hand today we have implemented 'Runnable'.An interface contains only abstract methods i.e. no code at all
			So how can we expect it to control a process
			Then why to implement it ?
			By implementing the Runnable interface we are actually making the object of class Five eligible to be used with constructor of
			Thread class to create Thread object 
		*/
		
		//Long cut
		Thread t5 = new Thread(f);
		//t5.start(); //ok
		Thread t7 = new Thread(new Seven());//shortcut methods
		Thread t13 = new Thread(new Thirteen());
		
		//set priority to each Thread before it goes to the Runnable state
		//priority levels are 1-10, 1-min ,10-max
		t5.setPriority(3); //absolute priority
		t7.setPriority(t5.getPriority()+1);//relative
		t13.setPriority(Thread.MAX_PRIORITY);
		
		t5.start();
		
		t13.start();
		t7.start();
		
		System.out.println("End og main thread");
	}
}