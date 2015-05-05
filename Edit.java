import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

class Edit 
{
	String name;
	String address;
	String phone;
	String age;
	String sex;
	String illness;
		
	Edit()
	{
		final JFrame editframe = new JFrame("Edit");
		editframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editframe.setLayout(null);
		
		final JPanel editpane = new JPanel();
		editpane.setLayout(null);
		editpane.setBounds(5,5,600,400);
		
		final JTextField idfield = new JTextField("Enter ID");
		idfield.setBounds(5,5,100,20);
		JButton editbutton = new JButton("Edit");
		editbutton.setBounds(5,50,100,20);
		
		editpane.add(idfield);
		editpane.add(editbutton);
		
		editframe.add(editpane);
		
		
		
		
		
		editbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try {
                  // Connection conn=DriverManager.getConnection(
                            // "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");     
					
					Connection conn=DriverManager.getConnection(
                            "jdbc:odbc:hospital");		

                  String query = "select * FROM patients WHERE id = ?";
                  pstmt = conn.prepareStatement(query); // create a statement
                  pstmt.setString(1, idfield.getText()); // set input parameter 1                  
                  ResultSet rs = pstmt.executeQuery(); // execute insert statement
				  rs.next();
					name = rs.getString("PName");
					address = rs.getString("Address");
					phone = rs.getString("PNumber");
					age = rs.getString("Age");
					sex = rs.getString("Sex");
					illness = rs.getString("Illness");
					
					// EDITFORM
					JPanel formpanel = new JPanel();
					formpanel.setBounds(50,300,600,400);		
					formpanel.setLayout(null);
					
					JTextField namefield = new JTextField(name);
					namefield.setBounds(100,200,200,100);
					formpanel.add(namefield);
					
					JTextField addressfield = new JTextField(address);
					addressfield.setBounds(100,400,200,100);
					formpanel.add(addressfield);
					
					JTextField phonefield = new JTextField(phone);
					phonefield.setBounds(100,600,200,100);
					formpanel.add(phonefield);
					
					JTextField agefield = new JTextField(age);
					agefield.setBounds(100,800,200,100);
					formpanel.add(agefield);
					
					JTextField sexfield = new JTextField(sex);
					sexfield.setBounds(100,1000,200,100);
					formpanel.add(sexfield);
					
					JTextField illnessfield = new JTextField(illness);
					illnessfield.setBounds(100,1200,200,100);
					formpanel.add(illnessfield);
					
					
					editframe.add(formpanel);
					
                } catch (Exception e) {
                  e.printStackTrace();
                } 
            }
        });
		
		
		
		editframe.setVisible(true);
	}
	
	public static void main(String ar[])
	{
		new Edit();
	}
}
