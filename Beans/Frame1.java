//example on parent and child frame

import java.awt.*;
import java.awt.event.*;

class Frame1 extends Frame implements ActionListener
{
	Button btnchild,btnexit;
	public static void main(String[] args)
	{
		new Frame1();
	}
	 Frame1()
	{
		
		setTitle("Parent Frame");
		setBounds(250,125,500,500);
		setFont(new Font("Times New Roman",Font.BOLD,25));
		setLayout(null);
		btnchild = new Button("open child");
		btnexit = new Button("exit");
		
		btnchild.setBounds(50,400,150,30);
		btnexit.setBounds(220,400,100,30);
		
		add(btnexit);
		add(btnchild);
		
		btnchild.addActionListener(this);
		btnexit.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnchild)
		{
			dispose(); //if next frame is not child
			new Frame2();//call the child frame using constructor
		}
		else
		System.exit(0);
	}
	
	
}//end of parent frame