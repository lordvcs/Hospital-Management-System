import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.BevelBorder;

public class ContactUs
{
    JTextArea comments;
    JTextField email;
    ContactUs()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        //create contactusframe Jframe
        final JFrame contactusframe = new JFrame("Contact Us");
        contactusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        contactusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contactusframe.setVisible(true);
        contactusframe.setLayout(null);

        //create Background Image for JFrame
        JLabel bgimage = new JLabel(new ImageIcon("Images//death.jpg"));

        contactusframe.setContentPane(bgimage);

        
        // CREATE HEADERPANEL JPANEL
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10,10,screenSize.width-20,100);
        //headerpanel.setBackground(Color.cyan);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED)); 

        // CREATE HEADERPANELSH JPANEL
        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
        headerpanelsh.setBounds(16,16,screenSize.width-20,100);
        headerpanelsh.setBackground(new Color(200, 200, 200));            

        // CREATE HEADING JLABEL
        JLabel heading = new JLabel("SIMPSONS MILITARY HOSPITAL");
        Font font = new Font("Garamond", Font.BOLD, 35);
        heading.setFont(font);
        heading.setForeground(new Color(0, 255, 226));            
        heading.setBounds(screenSize.width-700,30,700,45);

        JLabel heading1 = new JLabel("SIMPSONS MILITARY HOSPITAL");
        Font font1 = new Font("Garamond", Font.BOLD, 35);
        heading1.setFont(font1);
        heading1.setForeground(new Color(0, 126, 112));            
        heading1.setBounds(screenSize.width-697,33,700,45);
            
  
        // LOGO
        ImageIcon image = new ImageIcon("C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Images\\logo.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );
        panel.setBounds(50,5,100,90);
        
        
        //FOOTER JPANEL
            JButton home = new JButton("Home");
            home.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    contactusframe.setVisible(false);
                    new HomePage();
                }
            });
            home.setBounds((screenSize.width/2)-140,650,100,30);
            contactusframe.add(home);
            JButton aboutus = new JButton("About Us");
            aboutus.setBounds((screenSize.width/2)-40,650,100,30);
            aboutus.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                   contactusframe.setVisible(false);
                   new AboutUs();
               }
            });
            contactusframe.add(aboutus);
            JButton contactus = new JButton("Contact Us");
            contactus.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    contactusframe.setVisible(false);
                    new ContactUs();
                }
            });
            contactus.setBounds((screenSize.width/2)+60,650,100,30);
            contactusframe.add(contactus);


        //create mainbodypanel JPanel
        JPanel mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        mainbodypanel.setBackground(new Color(0,0,0,0));

        //create map image
        JLabel map = new JLabel();
		ImageIcon icon_map = new ImageIcon("Images//map.jpg");
        Image img_map = icon_map.getImage();
        Image newimg_map = img_map.getScaledInstance(350, 350, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon_map = new ImageIcon(newimg_map);
        map.setIcon(logoicon_map);
        map.setOpaque(true);
        map.setBackground(Color.red);
        map.setBounds(7*screenSize.width/10,15,350,350);

        //create address JLabel
		String text2 = "Address : Medical College Ulloor Road, Thiruvananthapuram, Kerala 695011";
		String text4 = "Email ID : diabolicfreak@gmail.com";
		JTextArea address = new JTextArea();
		address.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
		address.setText(text2);
		address.append(System.getProperty("line.separator"));
		address.append(System.getProperty("line.separator"));
		address.append(System.getProperty("line.separator"));
		address.append(System.getProperty("line.separator"));
		address.append(text4);
		address.append(System.getProperty("line.separator"));
        
        address.setBackground(new Color(0,0,0,150));
		address.setForeground(Color.white);
        address.setBounds(10,100,screenSize.width/3,screenSize.height/3-100);
		address.setLineWrap(true);
		address.setWrapStyleWord(true);
		address.setEditable(false);
		address.setOpaque(true);
		
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
                try
                {
                    // Connection conn=DriverManager.getConnection(
                    // "jdbc:ucanaccess://C://Users//Sreeram//Documents//NetBeansProjects//hms//src//Database//Hospital.accdb");     
                    Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
					System.out.println("Connection established");
                    PreparedStatement pst = conn.prepareStatement("insert into contactus(email,comments) values (?,?)");
                    pst.setString(1, email.getText()); 
                    pst.setString(2, comments.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Your Comments are recieved");
                    email.setText("");
                    comments.setText(null);
                    
					
                }
                catch(Exception e)
                {
                    e.printStackTrace();

                }
            }
        });
		
		contactusframe.pack();
		
        //add headerpanel
        contactusframe.add(headerpanel);
        contactusframe.add(headerpanelsh);
        headerpanel.add(heading);
        headerpanel.add(heading1);
        headerpanel.add(panel);

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
