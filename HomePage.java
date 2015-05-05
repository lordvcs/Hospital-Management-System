import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomePage 
{
    HomePage()
    {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // HOME PAGE FRAME
        final JFrame homepageframe = new JFrame("test frame");
        homepageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homepageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //homepageframe.setSize(900,900);

        // WRAPPER 
        JPanel wrapper = new JPanel();
        wrapper.setLayout(null);
        wrapper.setBackground(Color.green);

        // CREATE HEADERPANEL JPANEL
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(5,5,screenSize.width-10,100);
        headerpanel.setBackground(Color.cyan);

        //create heading JLabel
        JLabel heading = new JLabel("Hospital Heading");
        heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
        heading.setBounds(screenSize.width-500,30,500,50);

        //create logo button JButton
        JButton logo = new JButton();
        logo.setBackground(Color.black);
        ImageIcon icon = new ImageIcon("Images\\logo.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon = new ImageIcon(newimg);
        logo.setIcon(logoicon);
        logo.setBounds(50,0,100,100);


        //FOOTER JPANEL
        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width/2)-110,650,100,30);
        aboutus.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               new AboutUs();
           }
        });
        wrapper.add(aboutus);
        JButton contactus = new JButton("Contact Us");
        contactus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new ContactUs();
            }
        });
        contactus.setBounds((screenSize.width/2)+10,650,100,30);
        wrapper.add(contactus);
        
        

        // MAIN CONTENT JPANEL
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.YELLOW);
        mainpanel.setBounds(20, 130, 850, 500);

        // LOGIN PANEL
        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);		
        loginpanel.setBounds(900, 130, 450, 500);

        JLabel loginlabel = new JLabel("LOGIN");
        loginlabel.setBounds(200,-20,300,100);
        loginlabel.setFont(new Font("TimesNewRoman",Font.BOLD,18));                

        final JTextField username = new JTextField("Enter Username");
        username.setBounds(100,80,300,50);

        final JPasswordField password = new JPasswordField("Enter Password");
        password.setBounds(100,160,300,50);

        JButton loginbutton = new JButton("LOGIN");
        loginbutton.setBounds(150,250,200,50);

        //LOGIN ACTION
        loginbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(username.getText().length()==0)
                    JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
                else if(password.getPassword().length == 0)
                    JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
                else 
                {
                    String user = username.getText();   
                    char[] pass = password.getPassword(); 
                    String pwd = String.copyValueOf(pass);  
                    if(validate_login(user,pwd))
                    {
                        JOptionPane.showMessageDialog(null, "Correct Login Credentials");
                        homepageframe.setVisible(false);
			new MenuPage();
                    }
                    else
                       JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");        

                }
            }
        });
        
        
        
        



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
    
    private boolean validate_login(String username,String password)
        {
            try{           
                Connection conn=DriverManager.getConnection(
                    "jdbc:ucanaccess://C://Users//diabolicfeak//Documents//test.accdb");     
                PreparedStatement pst = conn.prepareStatement("Select * from users where username=? and password=?");
                pst.setString(1, username); 
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();                        
                if(rs.next())            
                    return true;    
                else
                    return false;            
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }       
         }

    public static void main(String ar[])
    {
        new HomePage();		
    }
	
	
}
