import.java.awt.*;
import.java.awt.events.*;
import.java.swing.*;

class HomePage
{	
	JButton about, contact; 

	HomePage()
	{
		Jframe homepageframe = new JFrame("Welcome to XXX Hospital");
		
		homepageframe.setLayout(null);
		
		homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		about = new JButton("About Us");
		contact = new JButton("Contact Us");
		
		about.addActionListener (new ActionListener())
		
	}	
}
