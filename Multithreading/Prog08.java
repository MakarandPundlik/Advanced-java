//bouncing ball program
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//<applet code="Prog08.class" width="600" height="600"></applet>
public class Prog08 extends Applet implements ActionListener
{
	Button btnstart;
	int cntr=0;
	Ball b1,b2;//ball is user defined class
	
	public void init()
	{
		btnstart = new Button("Start");
		//btnstart.setBounds(100,100,100,100);
		add(btnstart);
		btnstart.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(cntr==0)
		{
			cntr++;
			b1 = new Ball(0,0,50,50); //left,top,width,height
		}
		else 
		{
			btnstart.setEnabled(false);
			b2 = new Ball(0,75,50,50);//gap of 25 px
		}
	}
	
	/*
		Class Ball has to be an inner class because it has to refer the members of outer class
		to draw the ball in applet window we need to call its pain(), it should implement Runnable
	*/
	
	class Ball implements Runnable //generally it is safe to use Runnable interface because Ball has to inherit some other class
	{
		int top,left,width,height,inc_y;
		
		Thread th;
		
		//constructor
		Ball(int l,int t,int w,int h)
		{
			left = l;
			top = t;
			width = w;
			height = h;
			inc_y = 1;//+ve because top margin should increase so that the ball descends
			
			//keep the new ball created on a new Thread
			th = new Thread(this);
			th.start();
		}
		
		public void run()
		{
			//to display the animation continuously use a loop
			while(true)
			{
				left+=inc_y;
				//now shift the ball to new location after every delay period 
				
				try
				{
					th.sleep(10);//milliseconds
				}
				catch(InterruptedException e)
				{
					//do nothing
				}
				repaint();
				
				if(left==getSize().width-width || left==0)
				inc_y=-inc_y;
			}//end of while
		}//wnd of run()
	}//end of Ball
	
	public void paint(Graphics g)
	{
		try
		{
		g.setColor(Color.RED);
		g.fillOval(b1.left,b1.top,b1.width,b1.height);
		
		g.setColor(Color.GREEN);
		g.fillOval(b2.left,b2.top,b2.width,b2.height);
		}
		catch(NullPointerException e)
		{
			//do nothing
		}
	}
}