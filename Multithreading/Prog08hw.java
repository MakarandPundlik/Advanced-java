//bouncing ball program
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//<applet code="Prog08hw.class" width="600" height="600"></applet>
public class Prog08hw extends Applet implements ActionListener
{
	Button btnstart;
	int cntr=0;
	Ball b1,b2,b3;//ball is user defined class
	
	public void init()
	{
		btnstart = new Button("Start");
		
		add(btnstart);
		btnstart.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(cntr==0)
		{
			cntr++;
			b1 = new Ball(10,20,50,50); //left,top,width,height
		}
		else if(cntr==1)
		{
			cntr++;
			b2 = new Ball(20,20,50,50);//gap of 25 px
		}
		else {
			btnstart.setEnabled(false);
			b3 = new Ball(30,20,50,50);
		}
	}
	
	/*
		Class Ball has to be an inner class because it has to refer the members of outer class
		to draw the ball in applet window we need to call its pain(), it should implement Runnable
	*/
	
	class Ball implements Runnable //generally it is safe to use Runnable interface because Ball has to inherit some other class
	{
		int top,left,width,height,inc_y,inc_x;
		
		Thread th;
		
		//constructor
		Ball(int l,int t,int w,int h)
		{
			left = l;
			top = t;
			width = w;
			height = h;
			inc_x = 1;
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
				top+=inc_y;
				left+=inc_x;
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
				
				if(top==getSize().height-height || top==0)
				inc_y=-inc_y;
				
				if(left==getSize().width-width || left==0)
				inc_x=-inc_x;
				
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
		
		g.setColor(Color.BLUE);
		g.fillOval(b3.left,b3.top,b3.width,b3.height);
		}
		catch(NullPointerException e)
		{
			//do nothing
		}
	}
}