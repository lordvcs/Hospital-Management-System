import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ContactUs
{
	ContactUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//created contactusframe frame
		JFrame contactusframe = new JFrame("Contact Us");
		contactusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contactusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactusframe.setVisible(true);
		contactusframe.setLayout(null);
		//int width = contactusframe.getSize().width;
		
		//created headerpanel
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(5,5,screenSize.width-10,100);
		headerpanel.setBackground(Color.cyan);
		
		//created jlabel for hospital name
		JLabel heading = new JLabel("XXX Hospital");
		heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
		heading.setBackground(Color.red);
		heading.setBounds(screenSize.width-550,30,500,50);
		
		//created jbutton for logo
		JButton logo = new JButton();
		logo.setBackground(Color.black);
		ImageIcon icon = new ImageIcon("C:\\Users\\Sreeram\\Desktop\\Project\\Images\\logo.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon = new ImageIcon(newimg);
		logo.setIcon(logoicon);
		logo.setBounds(50,0,100,100);
		
		//adding components
		contactusframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		
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
