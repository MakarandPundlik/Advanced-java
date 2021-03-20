//an example of methods of block state
//yeild() - the thread on which this method is called which surrender its turn
//and join other methods at the end of the queue
//sleep( time in mS) - the thread in which this method is called will pause the thread from executing for given
//time period after which the thread again ebters into runnable state
//join() - the thread on which this method is called will pause the execution of other thread till its execution is over

class Five extends Thread
{
	public void run()
	{
		System.out.println("Start of Five thread");
		for(int i=1;i<=10;i++)
			{
				System.out.println("5x"+i+" = "+5*i);
				/*if(i==5)
				yield();*/
			}
			
		System.out.println("End of Five thread");	
	}
}

class Seven extends Thread
{
	public void run()
	{
		System.out.println("Start of Seven thread");
		for(int i=1;i<=10;i++)
			{
				System.out.println("7x"+i+" = "+7*i);
				if(i==3)
				try
				{
					sleep(2000);//2 sec
				}
				catch(InterruptedException e)
				{
				}
			}
		System.out.println("End of Seven thread");	
	}
}

class Thirteen extends Thread
{
	public void run()
	{
		System.out.println("Start of Thirteen thread");
		for(int i=1;i<=10;i++)
			System.out.println("13x"+i+" = "+13*i);
			
		System.out.println("End of Thirteen thread");	
	}
}

class Prog04
{
	public static void main(String[] args) throws InterruptedException
	{
		Five t5 = new Five();
		Seven t7 = new Seven();
		Thirteen t13 = new Thirteen();
		
		t5.start();
		t5.join();
		t7.start();
		t7.join();
		t13.start();
	}
}