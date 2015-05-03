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
		mainpanel.setBounds(20, 110, 850, 600);
		
		// LOGIN PANEL
		JPanel loginpanel = new JPanel();	
		loginpanel.setBounds(900, 110, 450, 600);
		
		JLabel loginlabel = new JLabel("LOGIN");
		loginlabel.setBounds(40,40,300,100);
		
		
			
			
		// ADD
		headerpanel.add(logo);
		headerpanel.add(heading);
		
		wrapper.add(headerpanel);
		wrapper.add(mainpanel);	
		
		loginpanel.add(loginlabel);
		wrapper.add(loginpanel);
		
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