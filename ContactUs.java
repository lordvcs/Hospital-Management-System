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
        final JFrame contactusframe = new JFrame("Contact Us");
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
        headerpanel.setBackground(new Color(0,0,0,30));


        //create JLabel for heading
        JLabel heading = new JLabel("Simpsons Military Hospital");
        heading.setFont(new Font("TimesNewRoman",Font.BOLD,40));
        heading.setBounds(screenSize.width/2,30,600,50);


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
		String text3 = "Phone No. : 9633885834";
		String text4 = "Email ID : diabolicfreak@gmail.com";
		JTextArea address = new JTextArea();
		address.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
		address.setText(text2);
		address.append(System.getProperty("line.separator"));
		address.append(System.getProperty("line.separator"));
		address.append(text3);
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
