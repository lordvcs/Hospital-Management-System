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
		ImageIcon icon = new ImageIcon("C:\\Users\\Sreeram\\hms\\Images\\logo.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon = new ImageIcon(newimg);
		logo.setIcon(logoicon);
		logo.setBounds(50,0,100,100);
		
		
		aboutusframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		
		
		
		
		
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
