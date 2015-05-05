import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.plaf.LabelUI;


class MenuPage 
{
    JTabbedPane tabbedPane;			
    JPanel mainbodypanel;
    int i = 1;

    MenuPage()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        //create menupageframe JFrame
        final JFrame menupageframe = new JFrame("Menu Page");
        menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menupageframe.setVisible(true);
        menupageframe.setLayout(null);

        //create Background Image for JFrame
        // JLabel bgimage = new JLabel(new ImageIcon("Images//aboutus.jpg"));
        // menupageframe.setContentPane(bgimage);


        //create headerpanel JPanel
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(5,5,screenSize.width-10,100);
        headerpanel.setBackground(new Color(0,0,200));


        //create JLabel for heading
        JLabel heading = new JLabel("Hospital Heading");
        heading.setFont(new Font("TimesNewRoman",Font.PLAIN,40));
        heading.setBounds(screenSize.width-(screenSize.width/4),30,500,50);


        //create logo button JButton
        JButton logo = new JButton();
        logo.setBackground(Color.black);
        ImageIcon icon = new ImageIcon("Images\\logo.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH ) ;  
        ImageIcon logoicon = new ImageIcon(newimg);
        logo.setIcon(logoicon);
        logo.setBounds(50,0,100,100);

        logo.addActionListener(new ActionListener()
        {
                public void actionPerformed(ActionEvent ae)
                {
                        menupageframe.setVisible(false);
                        new HomePage();
                }
        });

        //add headerpanel
        menupageframe.add(headerpanel);
        headerpanel.add(heading);
        headerpanel.add(logo);


        //create mainbodypanel JPanel
        mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        mainbodypanel.setBackground(new Color(255,255,255,255));


        //create Jtabbedpane
        JTabbedPane tabpane = new JTabbedPane();
        tabpane.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        menupageframe.add(tabpane);

        // OUTPATIENT start
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setOpaque(true);
        panel1.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel1.setLayout(null);
        
        // FORM start
        JPanel outform = new JPanel();
        outform.setLayout(null);
        outform.setBounds(310,30,600,520);
        
        JLabel outlabel = new JLabel("Enter Details of Out Patient");
        outlabel.setBounds(240,30,300,40);
        final JTextField outname = new JTextField("Enter Name");
        outname.setBounds(150,90,300,40);
        final JTextField outaddress = new JTextField("Enter Address");
        outaddress.setBounds(150,150,300,40);
        final JTextField outnumber = new JTextField("Enter Phone Number");
        outnumber.setBounds(150,210,300,40);
        final JTextField outage = new JTextField("Enter Age");
        outage.setBounds(150,270,300,40);
        final JTextField outsex = new JTextField("Enter Sex");
        outsex.setBounds(150,330,300,40);
        final JTextField outillness = new JTextField("Enter Illness");
        outillness.setBounds(150,390,300,40);
        JButton outbutton = new JButton("Submit");
        outbutton.setBounds(160,450,250,40);
        
        outform.add(outlabel);
        outform.add(outname);
        outform.add(outname);
        outform.add(outaddress);
        outform.add(outnumber);
        outform.add(outage);
        outform.add(outsex);
        outform.add(outillness);
        outform.add(outbutton);
        
        panel1.add(outform);
        // FORM end
        
        outbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try {
                  // Connection conn=DriverManager.getConnection(
                            // "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
					Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
                  String query = "insert into Patients(Pname, Address, Pnumber, Age, Sex, Illness) values(?, ?, ?, ?, ?, ?)";

                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setString(1, outname.getText()); // set input parameter 1
                  pstmt.setString(2, outaddress.getText()); // set input parameter 2
                  pstmt.setString(3, outnumber.getText()); // set input parameter 3
                  pstmt.setString(4, outage.getText());
                  pstmt.setString(5, outsex.getText());
                  pstmt.setString(6, outillness.getText());
                  pstmt.executeUpdate(); // execute insert statement
                  JOptionPane.showMessageDialog(null, "Successfully entered details");
                  new MenuPage();
                  menupageframe.setVisible(false);
                } catch (Exception e) {
                  e.printStackTrace();
                } 
            }
        });
        
        
        
        
      
        
        
        // OUTPATIENT end
        
        // PATIENT DB START
        JPanel panel2 = new JPanel();
        panel2.setOpaque(true);
        panel2.setBackground(Color.green);
        panel2.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel2.setLayout(null);
        
        
        DefaultTableModel patientmodel = new DefaultTableModel();
        patientmodel.addColumn("id");   
        patientmodel.addColumn("Name");   
        patientmodel.addColumn("Address");   
        patientmodel.addColumn("Age");   
        patientmodel.addColumn("Phone Number");   
        patientmodel.addColumn("Sex");   
        patientmodel.addColumn("Illness");   

        try{           
           // Connection conn=DriverManager.getConnection(
             //   "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
            Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
			PreparedStatement pst = conn.prepareStatement("Select * from Patients");                
            ResultSet rs = pst.executeQuery();                        
            while(rs.next())
            {   
                String id = rs.getString("id");
                String name = rs.getString("PName");
                String address = rs.getString("Address");
                String phone = rs.getString("PNumber");
                String age = rs.getString("Age");
                String sex = rs.getString("Sex");
                String illness = rs.getString("Illness");
                patientmodel.addRow(new Object[]{id, name, address, phone, age, sex, illness});
                
            }
            } 
        catch(Exception e){
            e.printStackTrace();                
            } 
        JTable patienttable = new JTable(patientmodel);
        JScrollPane patientpane = new JScrollPane(patienttable);
        patientpane.setBounds(10,10,1240,550);
        panel2.add(patientpane);
        panel2.setVisible(true);
        // PATIENT DB END

        
        
        // DOCOTORS DB start
        JPanel panel3 = new JPanel();
        panel3.setOpaque(true);
        panel3.setLayout(null);
        panel3.setBackground(Color.blue);
        panel3.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        
        
        
        DefaultTableModel doctormodel = new DefaultTableModel();
        doctormodel.addColumn("id");   
        doctormodel.addColumn("Name");   
        doctormodel.addColumn("Specialisation");   
        doctormodel.addColumn("Address");   
        doctormodel.addColumn("Phone Number");  

        try{           
            //Connection conn=DriverManager.getConnection(
             //   "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");  
			Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
            PreparedStatement pst = conn.prepareStatement("Select * from doctors");                
            ResultSet rs = pst.executeQuery();                        
            while(rs.next())
            {   
                String id = rs.getString("id");
                String name = rs.getString("DocName");  
                String specialisation = rs.getString("Specialisation");
                String address = rs.getString("Address");
                String age = rs.getString("PNumber");
                doctormodel.addRow(new Object[]{id, name, specialisation, address, age});
                
            }
            } 
        catch(Exception e){
            e.printStackTrace();                
            } 
        JTable doctortable = new JTable(doctormodel);
        JScrollPane doctorpane = new JScrollPane(doctortable);
        doctorpane.setBounds(10,10,1240,550);
        panel3.add(doctorpane);
        panel3.setVisible(true);
        
        // DOCOTORS DB end
        
        

        
		//BILL PAYMENT JPANEL
		//START
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
        panel4.setOpaque(true);
        panel4.setBackground(Color.yellow);
        panel4.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		
		JPanel bill_entry = new JPanel();
		bill_entry.setLayout(null);
		bill_entry.setBackground(Color.red);
		bill_entry.setBounds(5,5,2*(screenSize.width-10)/5,screenSize.height-(screenSize.height/3));
		
		JTextField patient_name = new JTextField("Patient Name");
		patient_name.setBounds(20,20,300,30);
		
		JTextField bill_item = new JTextField("Bill Item");
		bill_item.setBounds(20,70,300,30);
		
		JTextField bill_amt = new JTextField("Bill Amount");
		bill_amt.setBounds(20,120,300,30);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(100,170,75,30);
		
		JButton total_amt = new JButton("Total Amount");
		total_amt.setBounds(190,170,130,30);
		
		panel4.add(bill_entry);
		bill_entry.add(patient_name);
		bill_entry.add(bill_item);
		bill_entry.add(bill_amt);
		bill_entry.add(submit);
		bill_entry.add(total_amt);

        //add panels to tabpane
        tabpane.setTabPlacement(SwingConstants.LEFT);
        
		
		// Create vertical labels to render tab titles
		tabpane.add(panel1,"<html>O<br>U<br>T<br>P<br>A<br>T<br>I<br>E<br>N<br>T</html>");
		
        tabpane.add(panel2,"<html>P<br>A<br>T<br>I<br>E<br>N<br>T<br> <br>D<br>B</html>");
        tabpane.add(panel3,"Doctor DB");
        tabpane.add(panel4,"Bill Payment");
        
//        menupageframe.pack();
        
        //add mainbodypanel
        menupageframe.add(mainbodypanel);
    }
    
    public static void main(String a[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
                public void run()
                {
                        new MenuPage();
                }
        });
    }


}



