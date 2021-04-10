//an example of synchrinized method
class Call
{
	synchronized public void callMe()
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
		objc.callMe();
	}
}
class Prog09 
{
		public static void main(String[] args)
		{
			Call objc = new Call();
			ThreadSync t1 = new ThreadSync(objc);
			ThreadSync t2 = new ThreadSync(objc);
		}
}