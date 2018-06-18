
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Patient_GUI extends JFrame {
	
	private JPanel panel = new JPanel(); 
	private JPanel InfoPanel = new JPanel() ; 
	private JPanel ButtonPanel = new JPanel() ; 
		
	private JButton MakeAppointmentButton = new JButton("Make Appointment") ; 
	private JButton MyAppointmentsButton = new JButton("My Appointments") ; 
	private JButton MakeReviewButton = new JButton("Make Review") ; 
	private JButton SeeRescriptionsButton = new JButton("See Prescriptions") ; 
	private JButton ConfigureButton = new JButton("Configure" ) ; 
	private JButton SignOutButton = new JButton("Sign out") ; 
	
	private JTextField EmailField  ; 
	private JPasswordField PasswordField  ; 
	private JTextField TelephoneField  ; 
	private Patient user ; 
	
	
	
	public Patient_GUI(Patient connected,Registry reg) 
	{
		

		user = connected ; 

		//commponets of Buuton panel
	    ButtonPanel.setLayout(new GridLayout(9,1,10,30));
	    ButtonPanel.add(new JLabel("Choose an option:"));
		
		ButtonPanel.add(MakeAppointmentButton);
		ButtonPanel.add(MyAppointmentsButton);
		ButtonPanel.add(MakeReviewButton);
		ButtonPanel.add(SeeRescriptionsButton);
		ButtonPanel.add(SignOutButton);
		ButtonPanel.add(new JLabel("  "));
	 
		//sets JFields 
		EmailField = new JTextField(user.getMail(),20);
		PasswordField = new JPasswordField(user.getPassword(),20);
		TelephoneField = new JTextField(user.getTelephone(),20) ; 
		
		//componets of InfoPanel 
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
	       
	    
	    //componets of panel 
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(ButtonPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	this.getContentPane().add(InfoPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		
		MakeAppointmentButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MakeAppointment_GUI(connected,reg);
				dispose() ; 
			}
		
		
		
		}) ; 
		
		MakeReviewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    new MakeReview_GUI(user,reg) ; 
				dispose() ; 
			}
		});
		
		MyAppointmentsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyAppointments_GUI(user,reg);
				dispose() ; 
			}
		});
		
		
		SeeRescriptionsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SeePrescriptions_GUI(user,reg);
				dispose() ; 
			}
		});
		
		ConfigureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user.setPassword(PasswordField.getText());
				user.setMail(EmailField.getText());
				user.setTelephone(TelephoneField.getText());
				JOptionPane.showMessageDialog(panel,"Saved" );
				
			}
		});
		
		SignOutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Auth_GUI(reg) ; 
				dispose(); 
			}
		});
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setTitle("USER GUI");
		this.setTitle("Patient GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
			

	}


	
	

}
