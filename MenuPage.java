import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuPage 
{
	MenuPage()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				
		//create menupageframe JFrame
		JFrame menupageframe = new JFrame("Menu Page");
		menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menupageframe.setVisible(true);
		menupageframe.setLayout(null);
		
		//create Background Image for JFrame
		// JLabel bgimage = new JLabel(new ImageIcon("Images//aboutus.jpg"));
		// menupageframe.setContentPane(bgimage);
		
		
		//create headerpanel JPanel
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(5,5,screenSize.width-10,100);
		headerpanel.setBackground(new Color(0,0,200));
		
		
		//create JLabel for heading
		JLabel heading = new JLabel("Hospital Heading");
		heading.setFont(new Font("TimesNewRoman",Font.PLAIN,40));
		heading.setBounds(screenSize.width-(screenSize.width/4),30,500,50);
		
		
		//create logo button JButton
		JButton logo = new JButton();
		logo.setBackground(Color.black);
		ImageIcon icon = new ImageIcon("Images//logo.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon = new ImageIcon(newimg);
		logo.setIcon(logoicon);
		logo.setBounds(50,0,100,100);
		
		logo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				menupageframe.setVisible(false);
				new HomePage();
			}
		});
		
		//create mainbodypanel JPanel
		JPanel mainbodypanel = new JPanel();
		mainbodypanel.setLayout(null);
		mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		mainbodypanel.setBackground(new Color(0,0,0,0));
		
		menupageframe.pack();
			
		//add headerpanel
		menupageframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		//add mainbodypanel
		menupageframe.add(mainbodypanel);
		
		
	}
	
	public static void main(String a[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new MenuPage();
			}
		});
	}
}
