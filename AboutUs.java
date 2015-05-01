import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class AboutUs
{
	
	AboutUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//create aboutusframe Jframe
		JFrame aboutusframe = new JFrame("About Us");
		aboutusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutusframe.setVisible(true);
		aboutusframe.setLayout(null);
		//int width = aboutusframe.getSize().width;
		
		//creat headerpanel JPanel
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(5,5,screenSize.width-10,100);
		headerpanel.setBackground(Color.cyan);
		
		
		//create JLabel for heading
		JLabel heading = new JLabel("Hospital Heading");
		heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
		heading.setBounds(screenSize.width-(screenSize.width/4),30,500,50);
		
		
		//create logo button JButton
		JButton logo = new JButton();
		logo.setBackground(Color.black);
<<<<<<< HEAD
		ImageIcon icon = new ImageIcon("Images\\logo.png");
=======
		ImageIcon icon = new ImageIcon("Images//logo.png");
>>>>>>> 60cd1893a37b58042612c15d8e36abfe7a8e8d69
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon = new ImageIcon(newimg);
		logo.setIcon(logoicon);
		logo.setBounds(50,0,100,100);
		
		
		//create mainbodypanel JPanel
		JPanel mainbodypanel = new JPanel();
		mainbodypanel.setLayout(null);
		mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		mainbodypanel.setBackground(Color.black);
		
		//create mainbodypanel background image
		// JLabel 
		
		
		//create Founder1 image
		JLabel founder1 = new JLabel();
		founder1.setOpaque(true);
		founder1.setBackground(Color.red);
		founder1.setBounds(3*screenSize.width/4,screenSize.height/2,150,150);
		
		
		//add headerpanel
		aboutusframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		//add mainbodypanel
		aboutusframe.add(mainbodypanel);
		mainbodypanel.add(founder1);
		
		
		
		
		
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
