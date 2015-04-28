import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AboutUs
{
	AboutUs()
	{
		JFrame aboutus = new JFrame("About Us");
		aboutus.setLayout(null);
		aboutus.setSize(500,500);
		aboutus.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutus.setVisible(true);
		
		
	}
	
	public static void main(String a[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new AboutUs();
			}
		});
	}
}
