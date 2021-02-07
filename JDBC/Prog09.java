//design a gui for login screen

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Prog09 extends Frame implements ActionListener
{
	//it is better to declare components globally , so that they are accessible by standard methods
	
	Label l1,l2,lblinfo;
	TextField txtun,txtpass;
	Button btnlogin,btncancel;
	
	public static void main(String[] args)
	{
		new Prog09();
	}
	public Prog09()
	{
		setTitle("Login Page");
		setFont(new Font("Arial",Font.BOLD,20));
		setBounds(250,125,500,500);
		setLayout(null); //manual layout
		
		l1 = new Label("Username :- ");
		l2 = new Label("Password :- ");
		lblinfo = new Label("");
		
		txtun = new TextField();
		txtpass = new TextField();
		
		txtpass.setEchoChar('*'); //masking the textfield
		
		btnlogin = new Button("Login");
		btncancel = new Button("Cancel");
		
		//determine the position and size of each component
		l1.setBounds(50,50,120,30); //l,t,w,h
		l2.setBounds(50,120,120,30);
		
		txtun.setBounds(190,50,120,30);
		txtpass.setBounds(190,120,120,30);
		
		btnlogin.setBounds(50,170,90,30);
		btncancel.setBounds(160,170,90,30);
		
		lblinfo.setBounds(50,250,250,30);
		
		add(l1);
		add(l2);
		add(txtun);
		add(txtpass);
		add(btnlogin);
		add(btncancel);
		add(lblinfo);
		
		//register the components for event handling
		
		btnlogin.addActionListener(this);
		btncancel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//check which button is clicked
		if(ae.getSource()==btncancel)
		System.exit(0);
		
		else
		{
			try
			{
				//login vuttin clicked , access the table user and 
			//check if username and passwords are correct
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/company_info";
			String username = "root";
			String pass = "1234";
			Connection conn = DriverManager.getConnection(url,username,pass);
			
			//design the query first
			String sql = "select * from users where name = ? and password = ?";
			
			//create an ibhect of PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//pass the parameters
			ps.setString(1,txtun.getText());
			ps.setString(2,txtpass.getText());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				lblinfo.setText("Login successful!");
				//disclose(); for child frame
				//new Frame2();
			}
			else
			lblinfo.setText("Login unsuccessful!");
			
			rs.close();
			ps.close();
			conn.close();
			}//end of try
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}//end of if else
	}//end of actionPerformed
}//end of class