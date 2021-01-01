//an interface in sings to maintain customer records
 import java.awt.*; //for colour,font etc
 import java.awt.event.*; //swing uses awt listener for managing the events
 import javax.swing.*;//Jframe,JButton,JTextField 
 import java.sql.*; //for sql drivers
 
 
 class Prog10 extends JFrame implements ActionListener
 {
	//declare components globally
	JLabel l1,l2;
	JTextField txtfn,txtcid;
	JButton btnnext,btnprev,btnfirst,btnlast,btnnew,btnsave,btnupdate,btndelete;
	
	//declare sql components
	Connection conn;
	ResultSet rs;
	Statement stmt;
	
	public static void main(String[] args)
	{
		new Prog10();
	}
	public Prog10()
	{
		setTitle("Customer Records");
		setBounds(250,125,500,500);
		//setFont(new Font("Arial",Font.BOLD,20));
		setLayout(null); //manuak layout
		
		//this method is only applicable to swing frames
		setDefaultCloseOperation(EXIT_ON_CLOSE); //for parent frame
		
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE); //for child frame
		
		//create components
		l1 = new JLabel("Customer id:- ");
		l2 = new JLabel("Full Name:- ");
		
		txtcid = new JTextField();
		txtfn = new JTextField();
		
		btnnext = new JButton("Next");
		btnprev = new JButton("Prev");
		btnfirst = new JButton("First");
		btnlast = new JButton("Last");
		btnnew = new JButton("New");
		btnsave = new JButton("Save");
		btnupdate = new JButton("Update");
		btndelete = new JButton("Delete");
		
		//determine position of each component
		l1.setBounds(50,50,100,30);
		l2.setBounds(50,100,100,30);
		
		txtcid.setBounds(170,50,50,30);
		txtfn.setBounds(170,100,150,30);
		
		btnnext.setBounds(50,200,80,30);
		btnprev.setBounds(140,200,80,30);
		btnfirst.setBounds(230,200,80,30);
		btnlast.setBounds(320,200,80,30);
		
		btnnew.setBounds(50,250,80,30);
		btnsave.setBounds(140,250,80,30);
		btnupdate.setBounds(230,250,80,30);
		btndelete.setBounds(320,250,80,30);
		
		//add components to the frame
		add(l1);
		add(l2);
		add(txtcid);
		add(txtfn);
		add(btnnext);
		add(btnprev);
		add(btnfirst);
		add(btnlast);
		
		add(btnnew);
		add(btndelete);
		add(btnsave);
		add(btnupdate);
		
		//register each button with event
		
		btnnext.addActionListener(this);
		btnprev.addActionListener(this);
		btnfirst.addActionListener(this);
		btnlast.addActionListener(this);
		btnnew.addActionListener(this);
		btnsave.addActionListener(this);
		btnupdate.addActionListener(this);
		btndelete.addActionListener(this);
		
		//to connect to the database write a method ,
		//the process can be written here also , but it is always better to separate presentation logic from business logic
		
		 getConn(); //user defined method
		setVisible(true);
	}//end of constructor
	
	void getConn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/company_info";
			String un = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url,un,pass);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//before cretating a rs object we are setting its properties
			//the defaultsetting allows dB cursor to move inly in forward direction in rs;
			
			//also if we use sensitive cursor it means if several persons are accessing the db ,
			//changes made by the one person will be visible to all
			
			//also the second property allows us to post changes to rs object
			//these properties need to be set before crearing rs object
			
			String sql = "select * from customers";
			rs = stmt.executeQuery(sql);
			
			//display the first record , by default the dB cursor is at Beggining of File 
			rs.next();
			
			showRec(); //user defined ,method to display the records
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.getMessage(),"Customer records",JOptionPane.INFORMATION_MESSAGE);
		}
	}//end of getConn()
	
	void showRec()
	{
		//txtcid.setText(rs.getInt(1)); //error , incompatible types , found int reqd string
		
		//use wrapper class
		try
		{
			txtcid.setText(Integer.toString(rs.getInt(1)));
		txtfn.setText(rs.getString(2));
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.getMessage(),"Customer records",JOptionPane.INFORMATION_MESSAGE);
		}
	}//end of showRec();
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			//analyse the clicked button
			
			if(ae.getSource()==btnnext)
			{
				if(rs.isLast())
				JOptionPane.showMessageDialog(this,"Already at last record","Customer Records",JOptionPane.INFORMATION_MESSAGE);
				
				//1 - posotion of dialog box , this - at the centre of frame , null - centre of screen
				//2 - message to be displayed
				//3 - title
				//4 - icons to be shown
				
				else
				{
					rs.next();
					showRec();
				}
			}
			
			else if(ae.getSource()==btnprev)
			{
				if(rs.isFirst())
				JOptionPane.showMessageDialog(this,"Already at first record","Customer Records",JOptionPane.INFORMATION_MESSAGE);
				
				else
				{
					rs.previous();
					showRec();
				}
			}
			
			else if(ae.getSource()==btnfirst)
			{
				rs.first();
				showRec();
			}
			
			else if(ae.getSource()==btnlast)
			{
				rs.last();
				showRec();
			}
			
			else if(ae.getSource()==btnnew)
			{
				txtcid.setText("");
				txtfn.setText("");
			}
			
			else if(ae.getSource()==btnsave)
			{
				//append the blank roq at the end of rs
				rs.moveToInsertRow();
				
				//update the contents of blank row using the data from textfield
				//1 st field in rs is an int whose value is to be updated 
				rs.updateInt(1,Integer.parseInt(txtcid.getText()));
				rs.updateString(2,txtfn.getText());
				
				//transfer the data from rs to mysql dB
				
				rs.insertRow(); //this will auto run insert query
				
				JOptionPane.showMessageDialog(this,"Record has been inserted","Customer records",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ae.getSource()==btnupdate)
			{
				//update the record on the screen
				rs.updateInt(1,Integer.parseInt(txtcid.getText()));
				rs.updateString(2,txtfn.getText());
				
				rs.updateRow();
				JOptionPane.showMessageDialog(this,"Record has been updated","Customer records",JOptionPane.INFORMATION_MESSAGE);
			}
			
			//delete button
			else
			{
				//get confirmation from the user before proceeding with deletetion of record
				
				int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to deelete this record?","Question Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(response == JOptionPane.NO_OPTION)
				return; //terminate the deletion process
				
				//check which record is active 
				//if ot is last record then show the previous otherwise shoe next record
				
				boolean flag = false;
				if(rs.isLast())
				flag=true; //last record is active

				rs.deleteRow();
				JOptionPane.showMessageDialog(this,"Record has been deleted successfully","Delete information",JOptionPane.INFORMATION_MESSAGE);
				
				//refresh the gui with earlier or next record
				
				if(flag)
				rs.previous();
				
				else
				{
					rs.next();
					rs.previous();
					
					//after deleting a record 
					//the next record takes its place
					//but its not refreshed hence to refresh we neeed to move between records
					//rs.refreshRow(); //mysql does not support this
				}
				showRec();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.getMessage(),"Customer records",JOptionPane.INFORMATION_MESSAGE);
		}
	}
 }