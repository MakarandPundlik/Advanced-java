//to display the scrolling action window in applet i.e. text in animation

import java.awt.*;
import java.applet.*;

/*<applet code="Prog07.class" height="600" width="600"></applet>*/
public class Prog07 extends Applet implements Runnable
{
	//define variables globally so they can be accessible to all the sandard methods of the class to be overriden
	Thread t;
	String msg;
	boolean stopFlag;
	
	public void init()
	{
		msg="Databyte computer trainig center, Pune-4  ";
		setFont(new Font("Times New Roman",Font.ITALIC,25));
		setBackground(Color.black);
		setForeground(Color.white);
		
	}
	//called initially after init() and at the end when user returns to the applet web page
	public void start()
	{
		stopFlag = false;
		t = new Thread(this);
		t.start();
	}
	public void run()
	{
		//run method exceutes only once for a Thread and thread goes to the dead state after its execution
		while(true)
		{
			char ch = msg.charAt(0);
			msg = msg.substring(1);
			msg+=ch;
			
			//display the msg after every 0.3 sec
			try
			{
				t.sleep(300);//0.3 sec
			}
			catch(InterruptedException e)
			{
				
			}
			if(stopFlag)
				break;
				
			repaint();
		}
	}
	//when the application is minimized , switching of tabs takes place in browser stop() gets called automatically
	public void stop()
	{
		stopFlag=true;
		t = null;
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,50,350);
	}
}