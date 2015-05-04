import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class AboutUs
{
	
	AboutUs()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//create aboutusframe Jframe
		JFrame aboutusframe = new JFrame("About Us");
		aboutusframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		aboutusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutusframe.setVisible(true);
		aboutusframe.setLayout(null);
		
		//create Background Image for JFrame
		JLabel bgimage = new JLabel(new ImageIcon("Images//aboutus.jpg"));
		
		aboutusframe.setContentPane(bgimage);
		
		
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
				aboutusframe.setVisible(false);
				new HomePage();
			}
		});
		
		
		//create mainbodypanel JPanel
		JPanel mainbodypanel = new JPanel();
		mainbodypanel.setLayout(null);
		mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
		mainbodypanel.setBackground(new Color(0,0,0,0));
		
				
		//create Founder1 image
		JLabel founder1 = new JLabel();
		
		ImageIcon iconfounder1 = new ImageIcon("Images//founder1.jpg");
		Image imgfounder1 = iconfounder1.getImage();
		Image newimg1 = imgfounder1.getScaledInstance(250, 250, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon1 = new ImageIcon(newimg1);
		founder1.setIcon(logoicon1);
		
		JLabel founder1name = new JLabel("Cofounder : Dr.Vivek C S");
		founder1name.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
		founder1name.setBounds(8*screenSize.width/10,270,250,20);
		
		founder1.setOpaque(true);
		founder1.setBackground(Color.red);
		founder1.setBounds(8*screenSize.width/10,15,250,250);
				
		//create Founder2 image
		JLabel founder2 = new JLabel();
				
		ImageIcon iconfounder2 = new ImageIcon("Images//founder2.jpg");
		Image imgfounder2 = iconfounder2.getImage();
		Image newimg2 = imgfounder2.getScaledInstance(250, 250, Image.SCALE_SMOOTH ) ;  
		ImageIcon logoicon2 = new ImageIcon(newimg2);
		founder2.setIcon(logoicon2);
		
		founder2.setOpaque(true);
		founder2.setBackground(Color.red);
		founder2.setBounds(8*screenSize.width/10,300,250,250);
		
		
		//create JLabel for AboutUs text for mainbodypanel
		String text = "At McLean Hospital, our staff, faculty, students, volunteers and supporters are dedicated to improving the lives of people and families affected by psychiatric illness. As the largest psychiatric affiliate of Harvard Medical School, McLean has been meeting the needs of individuals and families with psychiatric illness since our founding in 1811. We are here to help you.";
		// JLabel aboutustext = new JLabel("<html>"+text+"</html>");
		
		JTextArea aboutustext = new JTextArea();
		aboutustext.setText(text);
		aboutustext.setFont(new Font("TimesNewRoman",Font.PLAIN,20));
		aboutustext.setLineWrap(true);
		aboutustext.setWrapStyleWord(true);
		aboutustext.setEditable(false);
		aboutustext.setOpaque(true);
		
		//aboutusframe.add(jtext);
		aboutustext.setBackground(new Color(255,255,255,125));
		aboutustext.setBounds(100,100,screenSize.width/2,screenSize.height/2);
		
		
		aboutusframe.pack();
		
		
		//add headerpanel
		aboutusframe.add(headerpanel);
		headerpanel.add(heading);
		headerpanel.add(logo);
		
		//add mainbodypanel
		aboutusframe.add(mainbodypanel);
		mainbodypanel.add(founder1);
		mainbodypanel.add(founder1name);
		mainbodypanel.add(founder2);
		mainbodypanel.add(aboutustext);
		
				
		
	}
	
	public static void main(String a[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new AboutUs();
			}
		});
	}
}
