//an example of synchronized object
/*
	In previous example the developer of class Call and ThreadSync was the same 
	Hence the addiotion of word synchonized would be done.
	Howerver many times we create threads and we ewant to us eit on object of different classes deveoped by other, in this case the source code of that class is unavailable
	So how to call methods in a Synchronized context?
	To achieve this we can synchronized objects aand call its methods
*/

class Call
{
	 public void callMe()
	{
		System.out.print("[ "+Thread.currentThread().getName()+" is inside");
		//to represent process ewhich takes some time, we will use sleep()
		try
		{
			Thread.sleep(3000);//3 secs important
		}
		catch(InterruptedException e)
		{
			//do nothing
		}
		System.out.print(" and its process is completed ] ");
	}
}
class ThreadSync extends Thread
{
	Call objc;
	ThreadSync(Call objc)
	{
		this.objc = objc;
		start();
	}
	public void run()
	{
		//invoke a method of class Call using its object
		synchronized(objc)
		{
			objc.callMe();
		}
	}
}
class Prog10
{
		public static void main(String[] args)
		{
			Call objc = new Call();
			ThreadSync t1 = new ThreadSync(objc);
			ThreadSync t2 = new ThreadSync(objc);
		}
}