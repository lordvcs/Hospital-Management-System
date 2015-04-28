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
		contactus.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contactus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactus.setLayout(new BorderLayout());
		contactus.setContentPane(new JLabel(new ImageIcon("aboutus_image.jpg")));
		contactus.setLayout(new FlowLayout());
		
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
