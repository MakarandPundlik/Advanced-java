//client side program - a frame

import java.awt.*;
import java.awt.event.*;
import java.rmi.*;

class Prog02C extends Frame implements ActionListener
{
	//declare objects globally 
	Label l1,l2;
	TextField txtno1,txtno2;
	String msg = "";
	Prog02I obj;//reference to server objects

	public static void main(String[] args)
	{
		new Prog02C();
	}
	
	Prog02C()
	{
		setBounds(250,150,500,500);//	left top width height
		setFont(new Font("Times New Roman",Font.BOLD,22));
		setLayout(null);
		
		//create components
		l1 = new Label("No1:-");
		l2 = new Label("No2:-");
		txtno1 = new TextField();
		txtno2 = new TextField();
		
		//determine the placement
		l1.setBounds(50,50,120,30);
		l2.setBounds(50,110,120,30);
		txtno1.setBounds(190,50,120,30);
		txtno2.setBounds(190,110,120,30);
		
		
		//add the components to Frame
		add(l1);
		add(l2);
		add(txtno1);
		add(txtno2);
		
		
		//register textfiekds for events
		txtno1.addActionListener(this);
		txtno2.addActionListener(this);
		
		
		//obtain a reference variable to server object from registry
		try
		{
			obj = (Prog02I)Naming.lookup("rmi://localhost:5455/refvar2");
			
		}
		catch(Exception e)
		{
			msg = e.getMessage();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			int no1 = Integer.parseInt(txtno1.getText());
			int no2 = Integer.parseInt(txtno2.getText());
			
			msg = "The addition of two numbers is "+obj.getSum(no1,no2);
		}
		catch(NumberFormatException e)
		{
			msg = "Please enter whole numbers only";
		}
		catch(Exception e)
		{
			msg = e.getMessage();
		}
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.drawString(msg,50,200);
	}
}