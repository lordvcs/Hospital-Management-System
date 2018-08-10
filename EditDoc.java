import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.BevelBorder;

class EditDoc 
{
	String name;
	String address;
	String phone;
	String specialisation;	
        
        JFrame editframe;
        JPanel formpanel, editpane, menubuttonpane;
        JButton menubutton;
        
                
	EditDoc()
	{   
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            
            JFrame editframe = new JFrame("Edit");
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
            
  
            
            ImageIcon image = new ImageIcon("C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Images\\logo.png");
            JLabel label = new JLabel("", image, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.add( label, BorderLayout.CENTER );
            panel.setBounds(50,15,100,90);
            
            //FOOTER JPANEL
            JButton aboutus = new JButton("About Us");
            aboutus.setBounds((screenSize.width/2)-120,650,100,30);
            aboutus.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                   new AboutUs();
               }
            });
            editframe.add(aboutus);
            JButton contactus = new JButton("Contact Us");
            contactus.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    new ContactUs();
                }
            });
            contactus.setBounds((screenSize.width/2)+10,650,100,30);
            editframe.add(contactus);
            
            editpane = new JPanel();
            editpane.setLayout(null);
            editpane.setBounds(500,120,400,200);
            
            menubuttonpane = new JPanel();
            menubuttonpane.setLayout(null);
            menubuttonpane.setBounds(510,120,400,50);

            final JTextField idfield = new JTextField("Enter ID");
            idfield.setBounds(10,10,150,30);
            JButton editbutton = new JButton("Edit");
            editbutton.setBounds(170,10,150,30);
            
            menubutton = new JButton("View ");
            menubutton.setBounds(120,10,150,30);
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
            formpanel.setBounds(350,150,600,900);		
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
                  String query = "select * FROM doctors WHERE id = ?";
                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setInt(1, a); // set input parameter 1                  
                  ResultSet rs = pstmt.executeQuery(); // execute insert statement
                    rs.next();
                    name = rs.getString("DocName");
                    specialisation = rs.getString("Specialisation");
                    address = rs.getString("Address");
                    phone = rs.getString("PNumber");

                    editform(name, specialisation, address, phone, a);
					
                } catch (Exception e) {
                  e.printStackTrace();
                } 
            }
        });
                
           editframe.add(formpanel);     
		
            editframe.setVisible(true);
	}
        
        public void editform(String name, String specialisation, String address, String phone, final int a)
        {
             // EDITFORM
                    

                    final JTextField namefield = new JTextField(name);
                    namefield.setBounds(200,60,280,40);
                    formpanel.add(namefield);

                    final JTextField specialisationfield = new JTextField(specialisation);
                    specialisationfield.setBounds(200,110,280,40);
                    formpanel.add(specialisationfield);

                    final JTextField addressfield = new JTextField(address);
                    addressfield.setBounds(200,160,280,40);
                    formpanel.add(addressfield);

                    final JTextField phonefield = new JTextField(phone);
                    phonefield.setBounds(200,210,280,40);
                    formpanel.add(phonefield);

                    JButton formeditbutton = new JButton("Submit");
                    formeditbutton.setBounds(225,380,230,40);
                    formeditbutton.setVisible(true);
                    formpanel.add(formeditbutton);
                    
                    
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

                  String query = "UPDATE doctors SET DocName=?, Specialisation=?, Address=?, Pnumber=? WHERE id=?";

                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setString(1, namefield.getText()); // set input parameter 1
                  pstmt.setString(2, specialisationfield.getText()); // set input parameter 2
                  pstmt.setString(3, addressfield.getText()); // set input parameter 3
                  pstmt.setString(4, phonefield.getText());
                  pstmt.setInt(5, a);
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
                new EditDoc();
                
            }});
		
	}
}
