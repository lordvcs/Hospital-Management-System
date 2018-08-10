import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

class Edit 
{
	String name;
	String address;
	String phone;
	String age;
	String sex;
	String illness;
        
        JFrame editframe;
        JPanel formpanel, editpane, menubuttonpane;
        JButton menubutton;
        
                
	Edit()
	{   
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            
            final JFrame editframe = new JFrame("Edit");
            editframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            editframe.setLayout(null);
            
            
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
            heading.setBounds(screenSize.width-700,40,700,45);
            
            JLabel heading1 = new JLabel("SIMPSONS MILITARY HOSPITAL");
            Font font1 = new Font("Garamond", Font.BOLD, 35);
            heading1.setFont(font1);
            heading1.setForeground(new Color(0, 126, 112));            
            heading1.setBounds(screenSize.width-697,43,700,45);
            
  
            // LOGO
            ImageIcon image = new ImageIcon("C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Images\\logo.png");
            JLabel label = new JLabel("", image, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.add( label, BorderLayout.CENTER );
            panel.setBounds(50,15,100,90);
            
            //FOOTER JPANEL
            JButton home = new JButton("Home");
            home.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    editframe.setVisible(true);
                    new HomePage();
                }
            });
            home.setBounds((screenSize.width/2)-140,650,100,30);
            editframe.add(home);
            JButton aboutus = new JButton("About Us");
            aboutus.setBounds((screenSize.width/2)-40,650,100,30);
            aboutus.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                   editframe.setVisible(true);
                   new AboutUs();
               }
            });
            editframe.add(aboutus);
            JButton contactus = new JButton("Contact Us");
            contactus.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    editframe.setVisible(true);
                    new ContactUs();
                }
            });
            contactus.setBounds((screenSize.width/2)+60,650,100,30);
            editframe.add(contactus);
            
            
            
            editpane = new JPanel();
            editpane.setLayout(null);
            editpane.setBounds(520,120,400,200);
            
            menubuttonpane = new JPanel();
            menubuttonpane.setLayout(null);
            menubuttonpane.setBounds(500,140,400,50);

            final JTextField idfield = new JTextField("Enter ID");
            idfield.setBounds(10,10,150,30);
            JButton editbutton = new JButton("Edit");
            editbutton.setBounds(170,10,150,30);
            
            menubutton = new JButton("View Patients");
            menubutton.setBounds(120,15,150,30);
            menubuttonpane.add(menubutton);
            menubuttonpane.setVisible(false);

            editpane.add(idfield);
            editpane.add(editbutton);

            editframe.add(editpane);
            editframe.add(menubuttonpane);
            editframe.add(panel);
            editframe.add(heading);
            editframe.add(heading1);
            editframe.add(headerpanel);
            editframe.add(headerpanelsh);
            
            


            formpanel = new JPanel();
            formpanel.setBounds(400,170,600,450);		
            formpanel.setLayout(null);
        
                
		
            editbutton.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try {
                //    Connection conn=DriverManager.getConnection(
                //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hms",
                    "root",
                    "root"
                );
					
//		Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");		
                   int a = Integer.parseInt(idfield.getText());
                  String query = "select * FROM Patients WHERE id = ?";
                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setInt(1, a); // set input parameter 1                  
                  ResultSet rs = pstmt.executeQuery(); // execute insert statement
                    rs.next();
                    name = rs.getString("PName");
                    address = rs.getString("Address");
                    phone = rs.getString("PNumber");
                    age = rs.getString("Age");
                    sex = rs.getString("Sex");
                    illness = rs.getString("Illness");

                    editform(name, address, phone, age, sex, illness, a);
					
                } catch (Exception e) {
                  e.printStackTrace();
                } 
            }
        });
                
           editframe.add(formpanel);     
		
            editframe.setVisible(true);
	}
        
        public void editform(String name, String address, String phone, String age, String sex, String illness, final int a)
        {
             // EDITFORM
                    

                    final JTextField namefield = new JTextField(name);
                    namefield.setBounds(165,60,280,40);
                    formpanel.add(namefield);

                    final JTextField addressfield = new JTextField(address);
                    addressfield.setBounds(165,110,280,40);
                    formpanel.add(addressfield);

                    final JTextField phonefield = new JTextField(phone);
                    phonefield.setBounds(165,160,280,40);
                    formpanel.add(phonefield);

                    final JTextField agefield = new JTextField(age);
                    agefield.setBounds(165,210,280,40);
                    formpanel.add(agefield);

                    final JTextField sexfield = new JTextField(sex);
                    sexfield.setBounds(165,260,280,40);
                    formpanel.add(sexfield);

                    final JTextField illnessfield = new JTextField(illness);
                    illnessfield.setBounds(165,310,280,40);
                    formpanel.add(illnessfield);

                    JButton formeditbutton = new JButton("Submit");
                    formeditbutton.setBounds(185,380,230,40);
                    formeditbutton.setVisible(true);
                    formpanel.add(formeditbutton);
                    
                    formpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED)); 
                    
                    editpane.setVisible(false);
                    menubuttonpane.setVisible(true);
                    formpanel.repaint();
                    
                    
                    // SECOND ONCLICK
                formeditbutton.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                PreparedStatement pstmt = null;
                try {
                //   Connection conn=DriverManager.getConnection(
                //             "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hms",
                    "root",
                    "root"
                );

                  String query = "UPDATE Patients SET Pname=?, Address=?, Pnumber=?, Age=?, Sex=?, Illness=? WHERE id=?";

                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setString(1, namefield.getText()); // set input parameter 1
                  pstmt.setString(2, addressfield.getText()); // set input parameter 2
                  pstmt.setString(3, phonefield.getText()); // set input parameter 3
                  pstmt.setString(4, agefield.getText());
                  pstmt.setString(5, sexfield.getText());
                  pstmt.setString(6, illnessfield.getText());
                  pstmt.setInt(7, a);
                  pstmt.executeUpdate(); // execute insert statement
                  JOptionPane.showMessageDialog(null, "Successfully entered details");
                  
                  
                } catch (Exception e) {
                  e.printStackTrace();
                } 
            }
        });
                
        menubutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new MenuPage();
                editframe.setVisible(false);
            }
        });
                    
        }         
	
	public static void main(String ar[])
	{
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Edit();
                
            }});
		
	}
}
