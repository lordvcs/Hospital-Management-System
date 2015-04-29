import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class AboutUs
{
	
	AboutUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//created aboutusframe frame
		JFrame aboutusframe = new JFrame("About Us");
		aboutusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutusframe.setVisible(true);
		aboutusframe.setLayout(null);
		//int width = aboutusframe.getSize().width;
		
		//created headerpanel
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(5,5,screenSize.width-10,100);
		headerpanel.setBackground(Color.cyan);
		
		
		JLabel heading = new JLabel("XXX Hospital");
		heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
		heading.setBackground(Color.red);
		heading.setBounds(screenSize.width-550,30,500,50);
		
		JButton logo = new JButton();
		logo.setBackground(Color.black);
		ImageIcon icon = new ImageIcon("C:\\Users\\Sreeram\\Desktop\\Project\\Images\\logo.png");
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
