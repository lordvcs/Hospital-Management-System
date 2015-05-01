import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HomePage 
{
	HomePage()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// HOME PAGE FRAME
		JFrame homepageframe = new JFrame("test frame");
		homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//homepageframe.setSize(900,900);
		
		// WRAPPER 
		JPanel wrapper = new JPanel();
		// wrapper.setPreferredSize(new Dimension(800,600));
		wrapper.setLayout(null);
        wrapper.setBackground(Color.green);
		
		//create headerpanel JPanel
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(5,5,screenSize.width-10,100);
		headerpanel.setBackground(Color.cyan);
		
		//create heading JLabel
		JLabel heading = new JLabel("Hospital Heading");
		heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
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
		
		// MAIN CONTENT JPANEL
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.YELLOW);
		mainpanel.setBounds(5, 110, 500, 11000);
		
		//create tester JLabel
		JLabel tester = new JLabel("Hoasfadasgsfgspital Heading");
		tester.setFont(new Font("TimesNewRoman",Font.BOLD,40));
		tester.setBounds(screenSize.width-(screenSize.width/4),30,500,10000);
		
		// ADD
		headerpanel.add(logo);
		headerpanel.add(heading);
		mainpanel.add(tester);
		wrapper.add(headerpanel);
		wrapper.add(mainpanel);		
		homepageframe.add(wrapper);	
				
		homepageframe.pack();
		
		// SCROLLBARS
		JScrollPane pane = new JScrollPane(wrapper);
		homepageframe.add(pane);
        
		// HOMEPAGE VISIBILITY
		homepageframe.setVisible(true);
	}
	
	public static void main(String ar[])
	{
		new HomePage();		
	}
	
	
}