import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class AboutUs
{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	AboutUs()
	{
		
		JFrame aboutus = new JFrame("About Us");
		// aboutus.setFont("TimesNewRoman",Font.BOLD,50);
		/* aboutus.setLayout(null); */
		aboutus.setLayout(new FlowLayout());
		aboutus.setSize(1000,1000);
		
		
		
		
		
		aboutus.getContentPane().setBackground(Color.BLACK);
		// aboutus.setLayout(new BorderLayout());
		
		// aboutus.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JLabel jlab1 = new JLabel("TEXT");
		// aboutus.add(jlab1);
		
		
		// aboutus.setUndecorated(true);
		 // aboutus.setOpacity(0.5f);
		JLabel jlab = new JLabel(new ImageIcon("aboutus.jpg"));
		jlab.setBounds(0,0,1000,1000);
		// jlab.setOpacity(0.5f);
		aboutus.setContentPane(jlab);
		aboutus.setVisible(true);
	}
	
	
	public static void main(String a[])
	{
		// SwingUtilities.invokeLater(new Runnable()
		// {
			// public void run()
			// {
				new AboutUs();
			// }
		// });
	}

}
