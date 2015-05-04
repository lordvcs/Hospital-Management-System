import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ContactUs
{
    JTextArea comments;
    JTextField email;
	ContactUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//create contactusframe Jframe
		JFrame contactusframe = new JFrame("Contact Us");
		contactusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contactusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactusframe.setVisible(true);
		contactusframe.setLayout(null);
		
		//create Background Image for JFrame
		JLabel bgimage = new JLabel(new ImageIcon("Images//death.jpg"));
		
		contactusframe.setContentPane(bgimage);
		
		
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
				contactusframe.setVisible(false);
				new HomePage();
			}
		});
		
		
		//create mainbodypanel JPanel
		JPanel mainbodypanel = new JPanel();
		mainbodypanel.setLayout(null);
		mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		mainbodypanel.setBackground(new Color(0,0,0,0));
		
		//create map image
		JLabel map = new JLabel();
		map.setOpaque(true);
		map.setBackground(Color.red);
		map.setBounds(7*screenSize.width/10,15,350,350);
		
		//create address JLabel
		JLabel address = new JLabel();
		address.setOpaque(true);
		address.setBackground(Color.white);
		address.setBounds(10,10,screenSize.width/3,screenSize.height/3);
		
		//create email JLabel
		String text = "Your Email ID :";
		
		JLabel emaillabel = new JLabel(text);
		emaillabel.setFont(new Font("TimesNewRoman",Font.BOLD,17));
		emaillabel.setForeground(Color.white);
		
		emaillabel.setOpaque(true);
		emaillabel.setBackground(new Color(0,0,0,0));
		emaillabel.setBounds(10,screenSize.height/3+15,screenSize.width/3,30);
		
		
		//create email TextField
		email = new JTextField();
		email.setOpaque(true);
		email.setBackground(Color.white);
		email.setBounds(10,8*screenSize.height/20,screenSize.width/3,25);
		
                
		//create comments JLabel
		String text1 = "Comments :";
		
		JLabel commentslabel = new JLabel(text1);
		commentslabel.setFont(new Font("TimesNewRoman",Font.BOLD,17));
		commentslabel.setForeground(Color.white);
		
		commentslabel.setOpaque(true);
		commentslabel.setBackground(new Color(0,0,0,0));
		commentslabel.setBounds(10,(8*screenSize.height/20)+50,screenSize.width/3,25);
		
		//create comments TextArea
		comments = new JTextArea(5,5);
		comments.setOpaque(true);
		comments.setBackground(Color.white);
		comments.setBounds(10,screenSize.height/2,screenSize.width/3,100);
		
		//create submit button
                JButton submit = new JButton("Submit");
                submit.setBounds(10,(3*screenSize.height/5)+30,100,30);
		
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Statement stm;
				
				
				try
				{
					Connection connect=DriverManager.getConnection("jdbc:ucanaccess:Database//contactus.accdb"); 
                                        stm = connect.createStatement();
                                        PreparedStatement ps = connect.prepareStatement("insert into contactus values(?,?)");
                                        ps.setString( 1, email.getText() );
                                        ps.setString( 2, comments.getText() );
                                        int rst =ps.executeUpdate(); 
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
			}
		});
                
		//add headerpanel
		contactusframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		//add mainbodypanel
		contactusframe.add(mainbodypanel);
		mainbodypanel.add(map);
		mainbodypanel.add(address);
		mainbodypanel.add(email);
		mainbodypanel.add(emaillabel);
		mainbodypanel.add(commentslabel);
		mainbodypanel.add(comments);
		mainbodypanel.add(submit);
		
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
