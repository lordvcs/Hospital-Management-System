import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

class MenuPage 
{
    JTabbedPane tabbedPane;			
    JPanel mainbodypanel;
	

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

        DefaultTableModel outpatientmodel = new DefaultTableModel();
        outpatientmodel.addColumn("id");   
//        outpatientmodel.addColumn("First Name");   
//        outpatientmodel.addColumn("First Name");   

        try{           
            Connection conn=DriverManager.getConnection(
                "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
            PreparedStatement pst = conn.prepareStatement("Select username from users");                
            ResultSet rs = pst.executeQuery();                        
            while(rs.next())
            {   
                int i = 1;
                String name = rs.getString(1);
                outpatientmodel.addRow(new Object[]{name});
                i++;
            }
            } 
        catch(Exception e){
            e.printStackTrace();                
            } 
        JTable outpatienttable = new JTable(outpatientmodel);
        JScrollPane outpatientpane = new JScrollPane(outpatienttable);
        outpatientpane.setBounds(100,100,500,400);
        panel1.add(outpatientpane);
        panel1.setVisible(true);
        
        // OUTPATIENT end
        
        // PATIENT DB START
        JPanel panel2 = new JPanel();
        panel2.setOpaque(true);
        panel2.setBackground(Color.green);
        panel2.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        
        
        DefaultTableModel patientmodel = new DefaultTableModel();
        outpatientmodel.addColumn("id");   
//        outpatientmodel.addColumn("First Name");   
//        outpatientmodel.addColumn("First Name");   

        try{           
            Connection conn=DriverManager.getConnection(
                "jdbc:ucanaccess://C://Users//diabolicfeak//Documents//test.accdb");     
            PreparedStatement pst = conn.prepareStatement("Select username from users");                
            ResultSet rs = pst.executeQuery();                        
            while(rs.next())
            {   
                int i = 1;
                String name = rs.getString(1);
                patientmodel.addRow(new Object[]{name});
                i++;
            }
            } 
        catch(Exception e){
            e.printStackTrace();                
            } 
        JTable patienttable = new JTable(outpatientmodel);
        JScrollPane patientpane = new JScrollPane(outpatienttable);
        outpatientpane.setBounds(100,100,500,400);
        panel1.add(outpatientpane);
        panel1.setVisible(true);
        // PATIENT DB END

        JPanel panel3 = new JPanel();
        panel3.setOpaque(true);
        panel3.setBackground(Color.blue);
        panel3.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));

        JPanel panel4 = new JPanel();
        panel4.setOpaque(true);
        panel4.setBackground(Color.yellow);
        panel4.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));

        //add panels to tabpane
        tabpane.setTabPlacement(SwingConstants.LEFT);
        tabpane.add(panel1,"OutPatient");
        tabpane.add(panel2,"Patient DB");
        tabpane.add(panel3,"Doctor DB");
        tabpane.add(panel4,"Bill Payment");
        
        menupageframe.pack();
        
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
    
		
		
		
    