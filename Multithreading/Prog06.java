//design a frame which displays a dynamic clock
import java.awt.*;
import java.util.Date;
class Prog06 extends Frame implements Runnable
{
	Thread t;//so that there can be shared reference to Thread object
	public static void main(String[] args)
	{
		new Prog06();
	}
	public Prog06()
	{
		setBounds(250,125,500,500);
		setFont(new Font("Calibri",Font.BOLD,25));
		t = new Thread(this); //important
		t.start();
		setVisible(true);
	}
	public void run()
	{
		while(true) //run() will execute only once
		{
			try
			{
				t.sleep(1000);//after every one second
				
			}
			catch(InterruptedException e)
			{
				
			}
			repaint();
		}
		
	}
	public void paint(Graphics g)
		{
			Date d = new Date();
			//g.drawString(d.toString(),100,200);
			int hrs = d.getHours();
			int min = d.getMinutes();
			int secs = d.getSeconds();
			//g.drawString(hrs+":"+min+":"+secs,150,150);
			
			//set AM and PM 
			String status = "AM";
			if(hrs>12)
			{
				hrs-=12;
				status="PM";
			}
			else if(hrs==12)
				status="PM";
			else if(hrs==0)
			{
				hrs=12;
				status="AM";
			}
			//g.drawString(hrs+":"+min+":"+secs+" "+status,150,150);
			
			//remove redundancy by converting single digit numbers to double digit
			String tmin=Integer.toString(min),tsecs=Integer.toString(secs);
			if(min<10)
				tmin=Integer.toString(0)+min;
			if(secs<10)	
				tsecs=Integer.toString(0)+secs;
				
			g.drawString("Digital Clock",150,120);
			g.drawString(hrs+":"+tmin+":"+tsecs+" "+status,150,150);	
		}
}