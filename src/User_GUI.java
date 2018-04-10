
import java.awt.*;


import javax.swing.*;



public class User_GUI extends JFrame{
	
	private JPanel panel = new JPanel(); 
	private JPanel InfoPanel = new JPanel() ; 
	private JPanel ButtonPanel = new JPanel() ; 
	
	
	private JButton MakeAppointment = new JButton("Make Appointment") ; 
	private JButton SeeAppointments = new JButton("See Appointments") ; 
	private JButton MakeReview = new JButton("Make Review") ; 
	private JButton SeeRescriptions = new JButton("See Rescriptions") ; 
	private JButton ChangeButton = new JButton("Change" ) ; 
	
	
	private JTextField EmailField  ; 
	private JTextField PasswordField  ; 
	private JTextField TelephoneField  ; 
	
	
	public User_GUI(Patient connected)
	{
		
		
		

	    ButtonPanel.setLayout(new GridLayout(6,2,10,50));
		ButtonPanel.add(new JLabel("Choose an option:"));
		
		ButtonPanel.add(MakeAppointment);
		ButtonPanel.add(SeeAppointments);
		ButtonPanel.add(MakeReview);
		ButtonPanel.add(SeeRescriptions);
		ButtonPanel.add(new JLabel("  "));
	 
	    
		EmailField = new JTextField(connected.getMail());
		PasswordField = new JTextField();
		TelephoneField = new JTextField(connected.getTelephone()) ; 
		
		
		InfoPanel.setLayout(new GridLayout(13,1,10,10));
	    InfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    InfoPanel.add(new JLabel("User's Info")) ; 
	    InfoPanel.add(new JLabel("Name:" + connected.getName()));
	    InfoPanel.add(new JLabel("Surname: " + connected.getSurname()));
	    InfoPanel.add(new JLabel("AMKA: " + connected.getAmka()));
	    InfoPanel.add(new JLabel("Email: "));
	    InfoPanel.add(EmailField);
	    InfoPanel.add(new JLabel("Password: "));
	    InfoPanel.add(PasswordField);
	    InfoPanel.add(new JLabel("Age: " + connected.getAge()));
	    InfoPanel.add(new JLabel("Gender: " + connected.isGender()));
	    InfoPanel.add(new JLabel("Telephone: " ));
	    InfoPanel.add(TelephoneField); 
	    InfoPanel.add(ChangeButton) ; 
	    
	       
	    
	    
	    
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new GridLayout(1, 2,30,0));
       	this.getContentPane().add(ButtonPanel);
		this.getContentPane().add(InfoPanel);
		this.setSize(800,500);
		this.setVisible(true);
		this.setTitle("USER GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
