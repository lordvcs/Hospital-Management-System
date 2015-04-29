import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HomePage
{	
	JButton about, contact;
	

	HomePage()
	{
		JFrame homepageframe = new JFrame("Welcome to XXX Hospital");
		
		homepageframe.setLayout(new GridLayout());
		
		homepageframe.setSize(700,700);
		
		homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		about = new JButton("About Us");
		contact = new JButton("Contact Us");		
		
		about.setSize(20,20);
		contact.setSize(40,40);
		
		homepageframe.add(about);
		homepageframe.add(contact);
		
		homepageframe.add(test);
		
		about.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				homepageframe.setVisible(true);
			}
		});
		
		homepageframe.setVisible(true);
		
	}

	public static void main(String ar[])
	{
		new HomePage(); 
	}

	
}////
