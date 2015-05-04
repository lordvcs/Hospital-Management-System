import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class testtable {
    
    
    
    public testtable(){
        
        JFrame testframe = new JFrame("Test Heading");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First Name");        
        
        try{           
            Connection conn=DriverManager.getConnection(
                "jdbc:ucanaccess://C://Users//diabolicfeak//Documents//test.accdb");     
            PreparedStatement pst = conn.prepareStatement("Select username from users");                
            ResultSet rs = pst.executeQuery();                        
            while(rs.next())
            {
                String name = rs.getString(1);
                model.addRow(new Object[]{name});
            }
            } 
            catch(Exception e){
            e.printStackTrace();                
            } 
        
        JTable table = new JTable(model);
        JScrollPane testpane = new JScrollPane(table);
        testframe.add(testpane);
        testframe.setVisible(true);
        
    }
    
    public static void main(String ar[]){
        new testtable();
    }
}
