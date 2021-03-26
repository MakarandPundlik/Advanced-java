//write a profram to explain life cycle of a Thread in java i.e. show all states and make every state sleep for random
//period of time
//create 3 threads and demonstrate

//logic - as all the threads are dealing with the same process there is no need to create 3 different classes as done previously

class ThreadCycle extends Thread
{
	String tname;
	ThreadCycle(String tname)
	{
		this.tname = tname;
		System.out.println("Thread "+tname+" is in newborn state");
		System.out.println("Thread "+tname+" is in runnable state");
		start();
	}
		
	public void run()
	{
		int t = (int)(Math.random()*5000);
		try
		{
			sleep(t);
		}
		catch(InterruptedException e)
		{
		}
		System.out.println("Thread "+tname+" is slept for "+t+" milliseconds");
	}
	
}
class Prog05
{
	public static void main(String[] args)
	{
		/*
			no use of assigning these names to the constructor on LHS as they are local to the main()
			and ThreadCycle class will not be able to pass the name of the objects through the constructor to the Thread class 
		*/
		new ThreadCycle("ta");
		new ThreadCycle("tb");
		new ThreadCycle("tc");
	}
}