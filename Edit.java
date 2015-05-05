import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.BevelBorder;

class Edit 
{
	String name;
	String address;
	String phone;
	String age;
	String sex;
	String illness;
        
        JFrame editframe;
        JPanel formpanel;
        JPanel editpane;
                
	Edit()
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
            heading1.setBounds(screenSize.width-702,42,700,45);
            
  
            
            ImageIcon image = new ImageIcon("C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Images\\logo.png");
            JLabel label = new JLabel("", image, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.add( label, BorderLayout.CENTER );
            panel.setBounds(50,15,100,90);
            
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

            final JTextField idfield = new JTextField("Enter ID");
            idfield.setBounds(10,10,150,30);
            JButton editbutton = new JButton("Edit");
            editbutton.setBounds(170,10,150,30);

            editpane.add(idfield);
            editpane.add(editbutton);

            editframe.add(editpane);
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
                   Connection conn=DriverManager.getConnection(
                             "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
					
//		Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");		
                   int a = Integer.parseInt(idfield.getText());
                  String query = "select * FROM patients WHERE id = ?";
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
                    namefield.setBounds(200,20,280,40);
                    formpanel.add(namefield);

                    final JTextField addressfield = new JTextField(address);
                    addressfield.setBounds(200,80,280,40);
                    formpanel.add(addressfield);

                    final JTextField phonefield = new JTextField(phone);
                    phonefield.setBounds(200,140,280,40);
                    formpanel.add(phonefield);

                    final JTextField agefield = new JTextField(age);
                    agefield.setBounds(200,200,280,40);
                    formpanel.add(agefield);

                    final JTextField sexfield = new JTextField(sex);
                    sexfield.setBounds(200,260,280,40);
                    formpanel.add(sexfield);

                    final JTextField illnessfield = new JTextField(illness);
                    illnessfield.setBounds(200,320,280,40);
                    formpanel.add(illnessfield);

                    JButton formeditbutton = new JButton("Submit");
                    formeditbutton.setBounds(225,400,230,40);
                    formeditbutton.setVisible(true);
                    formpanel.add(formeditbutton);
                    
                    
                    editpane.setVisible(false);
                    formpanel.repaint();
                    
                    
                    // SECOND ONCLICK
                formeditbutton.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent ae)
                {
                PreparedStatement pstmt = null;
                try {
                  Connection conn=DriverManager.getConnection(
                            "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     

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
                    
                    
        }
	
	public static void main(String ar[])
	{
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Edit();
                
            }});
		
	}
}
