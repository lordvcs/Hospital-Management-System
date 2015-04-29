import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ContactUs
{
	ContactUs()
	{
		JFrame contactus = new JFrame("About Us");
		contactus.setLayout(null);
		contactus.setSize(500,500);
		// contactus.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		contactus.setExtendedState(contactus.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contactus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// contactus.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		contactus.setVisible(true);
		
		
	}
	
	public static void main(String a[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new ContactUs();
			}
		});
	}
}
