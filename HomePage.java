import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomePage 
{
	HomePage()
	{
            try
            {
                Connection conn=DriverManager.getConnection(
                        "jdbc:ucanaccess://C://Users//diabolicfeak//Documents//test.accdb");
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    System.out.println(rs.getString(2));
}   
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
               
            
            
            
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
		
<<<<<<< HEAD
		//create logo button JButton
		JButton logo = new JButton();
		logo.setBackground(Color.black);
		ImageIcon icon = new ImageIcon("Images//logo.png");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon = new ImageIcon(newimg);
		logo.setIcon(logoicon);
		logo.setBounds(50,0,100,100);
=======
		about = new JButton("About Us");
		about.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				homepageframe.setVisible(false);
				new AboutUs();
			}
		});
		
		contact = new JButton("Contact Us");		
		contact.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				homepageframe.setVisible(false);
				new ContactUs();
			}
		});
>>>>>>> 796103b8e347906f2744f9fc2970d701390a3b5b
		
		// MAIN CONTENT JPANEL
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.YELLOW);
		mainpanel.setBounds(20, 110, 850, 600);
		
		// LOGIN PANEL
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(null);		
		loginpanel.setBounds(900, 110, 450, 600);
		
<<<<<<< HEAD
		JLabel loginlabel = new JLabel("LOGIN");
		loginlabel.setBounds(200,-20,300,100);
		loginlabel.setFont(new Font("TimesNewRoman",Font.BOLD,18));
=======
		//homepageframe.add(test);
>>>>>>> 796103b8e347906f2744f9fc2970d701390a3b5b
		
		JTextField username = new JTextField("Enter Username");
		username.setBounds(100,50,300,50);
		
		JPasswordField password = new JPasswordField("Enter Password");
		password.setBounds(100,160,300,50);
		
		JButton loginbutton = new JButton("LOGIN");
		loginbutton.setBounds(150,290,200,100);
		
			
			
		// ADD
		headerpanel.add(logo);
		headerpanel.add(heading);
		
		wrapper.add(headerpanel);
		wrapper.add(mainpanel);	
				
		loginpanel.add(loginlabel);
		loginpanel.add(username);
		loginpanel.add(password);
		loginpanel.add(loginbutton);
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
