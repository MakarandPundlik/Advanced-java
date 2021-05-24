import java.awt.*;
import java.awt.event.*;

//child Frame
	class Frame2 extends Frame implements ActionListener
	{
		Button btnclose;
		//IMP - do not use main()
		//main() should be only associated with starting frame of application
		
		//constructor
		Frame2()
		{
			setTitle("Child Frame");
			setBounds(400,275,200,200);
			setFont(new Font("Times New Roman",Font.BOLD,25));
			setLayout(new FlowLayout());
			btnclose = new Button("Close");
			add(btnclose);
			
			btnclose.addActionListener(this);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent ae)
		{
			dispose(); //close this frame and go back to calling/parent frame
		}
	}//end of child frame