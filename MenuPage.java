import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.LabelUI;


class MenuPage 
{
    JTabbedPane tabbedPane;			
    JPanel mainbodypanel, billdisplaypanel;
    int i = 1;
    
    JTextArea billtextarea;
    JLabel totaldisplaylabel;
    JTextField patient_name_label;
    
    // JLabel patient_name;
    
    
    DefaultTableModel billtablemodel;
    JTable billtable;
    JScrollPane billdisplayscroll;
    

    String name;
    String address;
    String phone;
    String age;
    String sex;
    String illness;
    
    int billamountint;
    double totalsum1=0;

    MenuPage()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        //create menupageframe JFrame
        final JFrame menupageframe = new JFrame("Menu Page");
        menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menupageframe.setVisible(true);
        menupageframe.setLayout(null);

      
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
        

        //add headerpanel
        menupageframe.add(headerpanel);
        menupageframe.add(headerpanelsh);
        headerpanel.add(heading);
        headerpanel.add(heading1);
        headerpanel.add(panel);
        
        
        //FOOTER JPANEL
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                menupageframe.setVisible(true);
                new HomePage();
            }
        });
        home.setBounds((screenSize.width/2)-140,650,100,30);
        menupageframe.add(home);
        JButton aboutus = new JButton("About Us");
        aboutus.setBounds((screenSize.width/2)-40,650,100,30);
        aboutus.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               menupageframe.setVisible(true);
               new AboutUs();
           }
        });
        menupageframe.add(aboutus);
        JButton contactus = new JButton("Contact Us");
        contactus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                menupageframe.setVisible(true);
                new ContactUs();
            }
        });
        contactus.setBounds((screenSize.width/2)+60,650,100,30);
        menupageframe.add(contactus);


        //create mainbodypanel JPanel
        mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        mainbodypanel.setBackground(new Color(255,255,255,255));


        //create Jtabbedpane
        JTabbedPane tabpane = new JTabbedPane();
        tabpane.setBounds(5,115,screenSize.width-10,screenSize.height-(screenSize.height/4));
        menupageframe.add(tabpane);

        // OUTPATIENT start
        JPanel panel1 = new JPanel();
        //panel1.setBackground(Color.red);
        panel1.setOpaque(true);
        panel1.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel1.setLayout(null);
        
        // FORM start
        JPanel outform = new JPanel();
        outform.setLayout(null);
        outform.setBounds(410,25,450,480);
        outform.setBorder(new EtchedBorder(EtchedBorder.RAISED)); 
        
        JLabel outlabel = new JLabel("Enter Details of Out Patient");
        outlabel.setBounds(140,20,300,40);
        final JTextField outname = new JTextField("Enter Name");
        outname.setBounds(80,70,300,40);
        final JTextField outaddress = new JTextField("Enter Address");
        outaddress.setBounds(80,120,300,40);
        final JTextField outnumber = new JTextField("Enter Ph no");
        outnumber.setBounds(80,170,300,40);
        final JTextField outage = new JTextField("Enter Age");
        outage.setBounds(80,220,300,40);
        final JTextField outsex = new JTextField("Enter Sex");
        outsex.setBounds(80,270,300,40);
        final JTextField outillness = new JTextField("Enter Illness");
        outillness.setBounds(80,320,300,40);
        JButton outbutton = new JButton("Submit");
        outbutton.setBounds(100,400,250,40);
        
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
                PreparedStatement billpstmt = null;
                try {
                //    Connection conn=DriverManager.getConnection(
                //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
                    //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hms",
                    "root",
                    "root"
                );
                    
                  String query = "insert into Patients(Pname, Address, Pnumber, Age, Sex, Illness) values(?, ?, ?, ?, ?, ?)";
				  
				  
				  // FOR BILLING TABLE start
				   Statement s = conn.createStatement();
				   ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Patients");
				   r.next();
				   int count = r.getInt("rowcount");
				  count= count+1;				  
				  String billquery = "CREATE TABLE patient_"+count+" " +
                   "(id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                   " bill_item VARCHAR(255), " + 
                   " billamount VARCHAR(255))";
				  billpstmt = conn.prepareStatement(billquery);
				  billpstmt.executeUpdate();
				  System.out.println("Inserted into patient_id" );
				  // FOR BILLING TABLE end
				   

                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, outname.getText()); 
                  pstmt.setString(2, outaddress.getText()); 
                  pstmt.setString(3, outnumber.getText());
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
        //panel2.setBackground(Color.green);
        panel2.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel2.setLayout(null);
        
        JButton editpatient = new JButton("Edit Records");
        editpatient.setBounds(550,15,150,40);        
        editpatient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
		menupageframe.setVisible(false);
                new Edit();
            }
        });
        
        i=1;
        DefaultTableModel patientmodel = new DefaultTableModel();
        patientmodel.addColumn("id");   
        patientmodel.addColumn("Name");   
        patientmodel.addColumn("Address");   
        patientmodel.addColumn("Age");   
        patientmodel.addColumn("Phone Number");   
        patientmodel.addColumn("Sex");   
        patientmodel.addColumn("Illness");   
        patientmodel.addColumn("Buttons");   

        try{           
            //  Connection conn=DriverManager.getConnection(
            //      "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/hms",
                "root",
                "root"
            );
//			Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
			PreparedStatement pst = conn.prepareStatement("Select * from Patients");                
            ResultSet rs = pst.executeQuery();       
			// Statement s = conn.createStatement();
			// ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Patients");
			// r.next();
			// int count = r.getInt("rowcount");			
			// System.out.println(count);
			// JButton[] buttons = new JButton[10];
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
                i++;
				
				
				
            }
            } 
        catch(Exception e){
            e.printStackTrace();                
            } 
        JTable patienttable = new JTable(patientmodel);
        JScrollPane patientpane = new JScrollPane(patienttable);
        patientpane.setBounds(10,70,1240,420);
        panel2.add(editpatient);
        panel2.add(patientpane);
        panel2.setVisible(true);
        // PATIENT DB END

        
        
        // DOCOTORS DB start
        JPanel panel3 = new JPanel();
        panel3.setOpaque(true);
        panel3.setLayout(null);
        //panel3.setBackground(Color.blue);
        panel3.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        
        
        JButton editdoctor = new JButton("Edit Records");
        editdoctor.setBounds(550,15,150,40);
        editdoctor.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
		menupageframe.setVisible(false);
                new EditDoc();
            }
        });
        
        
        DefaultTableModel doctormodel = new DefaultTableModel();
        doctormodel.addColumn("id");   
        doctormodel.addColumn("Name");   
        doctormodel.addColumn("Specialisation");   
        doctormodel.addColumn("Address");   
        doctormodel.addColumn("Phone Number");  

        try{           
            //  Connection conn=DriverManager.getConnection(
            //      "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");  
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/hms",
                "root",
                "root"
            );
            //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
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
        doctorpane.setBounds(10,70,1240,420);
        panel3.add(editdoctor);
        panel3.add(doctorpane);
        panel3.setVisible(true);
        
        // DOCOTORS DB end
        
        

        
        //BILL PAYMENT START
        final JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setOpaque(true);
//        panel4.setBackground(Color.yellow);
        panel4.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		
		
	// ID PANEL start	
        JPanel billidpanel = new JPanel();
        billidpanel.setLayout(null);
        billidpanel.setBounds(450,10,500,50);

        final JTextField billidfield = new JTextField("Enter id");
        JButton billidbutton = new JButton("Show");
        billidfield.setBounds(5,5,200,30);
        billidbutton.setBounds(300,5,200,30);

        billidpanel.add(billidfield);
        billidpanel.add(billidbutton);
	
        // ID PANEL end
		
		
        // BILL ENTRY PANEL start

        final JTextField bill_item = new JTextField("Bill Item");
        bill_item.setBounds(140,130,300,30);

        final JTextField bill_amt = new JTextField("Bill Amount");
        bill_amt.setBounds(140,200,300,30);

        JButton bill_submit = new JButton("Add");
        bill_submit.setBounds(240,260,75,30);

        JButton total_amt = new JButton("Show Total Amount");
        total_amt.setBounds(180,320,230,30);

        final JPanel billentrypanel = new JPanel();
        billentrypanel.setLayout(null);
        billentrypanel.setBounds(20,100,600,400);
        billentrypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		
		
	bill_submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {  
                PreparedStatement pstmt = null;
                try 
                {
                    int a = Integer.parseInt(billidfield.getText());
                //    Connection conn=DriverManager.getConnection(
                //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hms",
                    "root",
                    "root"
                );
                    //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
                  String query = "insert into patient_"+a+"(bill_item, billamount) values(?, ?)";
			
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, bill_item.getText()); 
                  pstmt.setString(2, bill_amt.getText()); 
                  
                  pstmt.executeUpdate(); // execute insert statement
                  
                } catch (Exception e) 
                {
                  e.printStackTrace();
                } 
            }
        });
	
        // BILL ENTRY PANEL end
        
        
		
        
		
	// BILL DISPLAY PANEL start
        
        
				
		
        billidbutton.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent ae)
            {
                try{
                int a = Integer.parseInt(billidfield.getText());
                // Connection conn1=DriverManager.getConnection(
                // "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hms",
                    "root",
                    "root"
                );
                //Connection conn1=DriverManager.getConnection("jdbc:odbc:hospital");
            // FOR PATIENT NAME start
               Statement s = conn.createStatement();
               ResultSet r = s.executeQuery("SELECT * FROM Patients WHERE id="+a+"");
               r.next();
               String patient_name = r.getString("PName");
               String patient_age = r.getString("Age");
               String patient_sex = r.getString("Sex");
               
               

               patient_name_label = new JTextField("Patient Name: "+patient_name);
               billentrypanel.add(patient_name_label);
               patient_name_label.setBounds(20,20,150,30);
               patient_name_label = new JTextField("Patient Age: "+patient_age);
               billentrypanel.add(patient_name_label);
               patient_name_label.setBounds(220,20,150,30);
               patient_name_label = new JTextField("Patient Sex: "+patient_sex);
               billentrypanel.add(patient_name_label);
               patient_name_label.setBounds(420,20,150,30);

                // FOR PATIENT NAME END
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                
                // BILL TABLE start
                billtablemodel = new DefaultTableModel();
                billtablemodel.addColumn("Bill Item");   
                billtablemodel.addColumn("Bill Amount");                   
				
                PreparedStatement pstmt = null;
                try 
		{
                    // Connection conn=DriverManager.getConnection(
                    //           "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
					Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/hms",
                        "root",
                        "root"
                    );
                    //Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");		
                   int a = Integer.parseInt(billidfield.getText());
                
                    PreparedStatement pst = conn.prepareStatement("Select * from patient_"+a+"");                
                    ResultSet rs = pst.executeQuery();       
                    
                    while(rs.next())
                    {   
                        
                        String billitem = rs.getString("bill_item");
                        String billamount = rs.getString("billamount");
                        billtablemodel.addRow(new Object[]{billitem, billamount});
                        
                    }
                    billtable = new JTable(billtablemodel);
//                    billtablemodel.fireTableDataChanged();
                    billdisplayscroll = new JScrollPane(billtable);
                    billdisplayscroll.setBounds(20,20,470,280);
                    billdisplaypanel.add(billdisplayscroll);
                }
                catch(Exception e)
                {
                    e.printStackTrace();                
                } 
                
            }
        });
        
        
        
        total_amt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                billtablemodel.fireTableDataChanged();
                billtable.repaint();
                
                
                
                 try 
		{
                    // Connection conn=DriverManager.getConnection(
                    //           "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
					Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/hms",
                        "root",
                        "root"
                    );
                    //Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");		
                   int a = Integer.parseInt(billidfield.getText());
                   
                     Statement s = conn.createStatement();
                     System.out.println("long before");
                     ResultSet rs = s.executeQuery("SELECT * FROM patient_"+a+"");
                     System.out.println("bit before");              
                                   
                    totalsum1 = 0;
                    int sum1 = 0;
//                    PreparedStatement pst = conn.prepareStatement("SELECT SUM(billamount) AS totaltt FROM patient_"+a+"");                
//                    
//                    ResultSet rs = pst.executeQuery(); 
                    
                    while(rs.next())
                    {   
                        
                        System.out.println("before");
                        
                        String id = rs.getString("bill_item");
                        String name = rs.getString("billamount");
                        sum1 = Integer.parseInt(name);
                        totalsum1 = totalsum1 +sum1;
                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();                
                } 
                String total2 = String.valueOf(totalsum1);
                totaldisplaylabel = new JLabel();
                totaldisplaylabel.setText("");
                billdisplaypanel.add(totaldisplaylabel);
                totaldisplaylabel.setText("Amount payable: "+total2);
//                 billdisplaypanel.add(totaldisplaylabel);
//                 totaldisplaylabel.setBounds(250,50,300,600);
//                 totaldisplaylabel.repaint();
                 
                 JTextField totaltext = new JTextField();
                 totaltext.setText("Amount payable: "+total2);
                 billdisplaypanel.add(totaltext);
                 totaltext.setBounds(150,300,200,30);
                System.out.println(total2);
                 
            }
        });
        
        billdisplaypanel = new JPanel();
        billdisplaypanel.setLayout(null);
        //billdisplaypanel.setBackground(Color.red);
        panel4.add(billdisplaypanel);
        billdisplaypanel.setBounds(700,100,500,400);
        billdisplaypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		

        // BILL DISPLAY PANEL end

        billentrypanel.add(bill_item);
        billentrypanel.add(bill_amt);
        billentrypanel.add(total_amt);
        billentrypanel.add(bill_submit);



        panel4.add(billentrypanel);
         
        panel4.add(billidpanel);
		
		//BILL PAYMENT END
		

        //add panels to tabpane
        tabpane.setTabPlacement(SwingConstants.LEFT);
        
		
	// Create vertical labels to render tab titles
	tabpane.add(panel1,"<html>O<br>U<br>T<br>P<br>A<br>T<br>I<br>E<br>N<br>T</html>");
        tabpane.add(panel2,"<html>P<br>A<br>T<br>I<br>E<br>N<br>T<br> <br>D<br>B</html>");
        tabpane.add(panel3,"<html>D<br>O<br>C<br>T<br>O<br>R<br> <br>D<br>B</html>");
        tabpane.add(panel4,"<html>B<br>I<br>L<brl<br>");
        
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

