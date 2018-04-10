
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class User_GUI extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel(); 
	private JPanel InfoPanel = new JPanel() ; 
	private JPanel ButtonPanel = new JPanel() ; 
	
	
	private JButton MakeAppointmentButton = new JButton("Make Appointment") ; 
	private JButton SeeAppointmentsButton = new JButton("See Appointments") ; 
	private JButton MakeReviewButton = new JButton("Make Review") ; 
	private JButton SeeRescriptionsButton = new JButton("See Rescriptions") ; 
	private JButton ChangeButton = new JButton("Change" ) ; 
	private JButton SignOutButton = new JButton("Sign out") ; 
	
	private JTextField EmailField  ; 
	private JPasswordField PasswordField  ; 
	private JTextField TelephoneField  ; 
	private Patient user ; 
	
	public User_GUI(Patient connected) 
	{
		
		
		user = connected ; 

	    ButtonPanel.setLayout(new GridLayout(10,1,10,30));
	    
	  
		ButtonPanel.add(new JLabel("Choose an option:"));
		
	
		ButtonPanel.add(MakeAppointmentButton);
		ButtonPanel.add(SeeAppointmentsButton);
		ButtonPanel.add(MakeReviewButton);
		ButtonPanel.add(SeeRescriptionsButton);
		ButtonPanel.add(SignOutButton);
		ButtonPanel.add(new JLabel("  "));
	 
	    
		EmailField = new JTextField(user.getMail());
		PasswordField = new JPasswordField(user.getPassword());
		TelephoneField = new JTextField(user.getTelephone()) ; 
		
		
		InfoPanel.setLayout(new GridLayout(13,1,10,10));
	    InfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    InfoPanel.add(new JLabel("User's Info")) ; 
	    InfoPanel.add(new JLabel("Name:" + user.getName()));
	    InfoPanel.add(new JLabel("Surname: " + user.getSurname()));
	    InfoPanel.add(new JLabel("AMKA: " + user.getAmka()));
	    InfoPanel.add(new JLabel("Email: "));
	    InfoPanel.add(EmailField);
	    InfoPanel.add(new JLabel("Password: "));
	    InfoPanel.add(PasswordField);
	    InfoPanel.add(new JLabel("Age: " + user.getAge()));
	    InfoPanel.add(new JLabel("Gender: " + user.isGender()));
	    InfoPanel.add(new JLabel("Telephone: " ));
	    InfoPanel.add(TelephoneField); 
	    InfoPanel.add(ChangeButton) ; 
	    
	       
	    
	    
	    
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new GridLayout(1, 2,30,0));
       	this.getContentPane().add(ButtonPanel);
		this.getContentPane().add(InfoPanel);
		
		MakeAppointmentButton.addActionListener(this);
		MakeReviewButton.addActionListener(this);
		SeeAppointmentsButton.addActionListener(this);
		SeeRescriptionsButton.addActionListener(this);
		ChangeButton.addActionListener(this);
		SignOutButton.addActionListener(this);
		this.setSize(800,500);
		this.setVisible(true);
		this.setTitle("USER GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(MakeAppointmentButton))
		{
			dispose() ; 
		}
		else if(e.getSource().equals(SeeAppointmentsButton))
		{
			dispose() ; 
		}
		else if(e.getSource().equals(MakeReviewButton))
		{
			dispose(); 
		}
		else if(e.getSource().equals(SeeRescriptionsButton))
		{
			dispose() ; 
		}
		else if(e.getSource().equals(ChangeButton)) 
		{
			user.setPassword(PasswordField.getText());
			user.setMail(EmailField.getText());
			user.setTelephone(TelephoneField.getText());
			
		}
		else 
		{
			new Auth_GUI() ; 
			dispose(); 
		}
		
	}

	
	

}
