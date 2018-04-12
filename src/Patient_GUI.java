
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Patient_GUI extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel(); 
	private JPanel InfoPanel = new JPanel() ; 
	private JPanel ButtonPanel = new JPanel() ; 
	
	
	private JButton MakeAppointmentButton = new JButton("Make Appointment") ; 
	private JButton SeeAppointmentsButton = new JButton("See Appointments") ; 
	private JButton MakeReviewButton = new JButton("Make Review") ; 
	private JButton SeeRescriptionsButton = new JButton("See Rescriptions") ; 
	private JButton ConfigureButton = new JButton("Configure" ) ; 
	private JButton SignOutButton = new JButton("Sign out") ; 
	
	private JTextField EmailField  ; 
	private JPasswordField PasswordField  ; 
	private JTextField TelephoneField  ; 
	private Patient user ; 
	
	public Patient_GUI(Patient connected) 
	{
		
		
		user = connected ; 

	    ButtonPanel.setLayout(new GridLayout(9,1,10,30));
	    
	  
		ButtonPanel.add(new JLabel("Choose an option:"));
		
	
		ButtonPanel.add(MakeAppointmentButton);
		ButtonPanel.add(SeeAppointmentsButton);
		ButtonPanel.add(MakeReviewButton);
		ButtonPanel.add(SeeRescriptionsButton);
		ButtonPanel.add(SignOutButton);
		ButtonPanel.add(new JLabel("  "));
	 
	    
		EmailField = new JTextField(user.getMail(),20);
		PasswordField = new JPasswordField(user.getPassword(),20);
		TelephoneField = new JTextField(user.getTelephone(),20) ; 
		
		
		InfoPanel.setLayout(new GridLayout(13,1,10,10));
	   
	    
	    InfoPanel.add(new JLabel("User's Info")) ; 
	    InfoPanel.add(new JLabel("Name:" + user.getName()));
	    InfoPanel.add(new JLabel("Surname: " + user.getSurname()));
	    InfoPanel.add(new JLabel("AMKA: " + user.getAmka()));
	    InfoPanel.add(new JLabel("Email: "));
	    InfoPanel.add(EmailField);
	    InfoPanel.add(new JLabel("Password: "));
	    InfoPanel.add(PasswordField);
	    InfoPanel.add(new JLabel("Age: " + user.getAge()));
	    if(user.isGender())
	    	InfoPanel.add(new JLabel("Gender: Female" ));
	    else
	    	InfoPanel.add(new JLabel("Gender: Male" ));
	    InfoPanel.add(new JLabel("Telephone: " ));
	    InfoPanel.add(TelephoneField); 
	    InfoPanel.add(ConfigureButton) ; 
	    
	       
	    
	    
	    
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(ButtonPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	
    	this.getContentPane().add(InfoPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		
		MakeAppointmentButton.addActionListener(this);
		MakeReviewButton.addActionListener(this);
		SeeAppointmentsButton.addActionListener(this);
		SeeRescriptionsButton.addActionListener(this);
		ConfigureButton.addActionListener(this);
		SignOutButton.addActionListener(this);
		this.setSize(500,500);
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
		else if(e.getSource().equals(ConfigureButton)) 
		{
			user.setPassword(PasswordField.getText());
			user.setMail(EmailField.getText());
			user.setTelephone(TelephoneField.getText());
			JOptionPane.showMessageDialog(panel,"Saved" );
			
		}
		else 
		{
			new Auth_GUI() ; 
			dispose(); 
		}
		
	}

	
	

}
