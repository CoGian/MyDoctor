import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Doctor_GUI extends JFrame{
	private JPanel panel = new JPanel(); 
	private JPanel InfoPanel = new JPanel() ; 
	private JPanel ButtonPanel = new JPanel() ; 
	
	private JTextField amkaField = new JTextField(20);	
	private JButton SearchPatientButton = new JButton("Search Patient");
	private JButton CancelAppointmentsButton = new JButton("Cancel Appointments");
	private JButton ConfigureButton = new JButton("Configure" ); 
	private JButton SignOutButton = new JButton("Sign out");
	
	private JTextField EmailField  ; 
	private JPasswordField PasswordField  ; 
	private JTextField TelephoneField  ; 
	private Doctor user ; 
	
	public Doctor_GUI(Doctor connected, Registry reg)
	{

		user = connected ; 

		//components of Button panel
	    ButtonPanel.setLayout(new GridLayout(9,1,10,30));
	    ButtonPanel.add(new JLabel("Choose an option:"));
		
	    ButtonPanel.add(amkaField);
		ButtonPanel.add(SearchPatientButton);
		ButtonPanel.add(CancelAppointmentsButton);
		ButtonPanel.add(SignOutButton);
		ButtonPanel.add(new JLabel("  "));
	 
		//sets JFields 
		EmailField = new JTextField(user.getMail(),20);
		PasswordField = new JPasswordField(user.getPassword(),20);
		TelephoneField = new JTextField(user.getTelephone(),20) ; 
		
		//components of InfoPanel 
		InfoPanel.setLayout(new GridLayout(14,1,10,10));
	   	    
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
	    InfoPanel.add(new JLabel("City: "+user.getCityName()));
	    InfoPanel.add(ConfigureButton) ; 
	       
	    
		//components of panel 
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(ButtonPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	this.getContentPane().add(InfoPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	
    	SearchPatientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Patient foundPatient = user.searchPatientFromList(amkaField.getText());
				if(foundPatient != null) {
					new PatientInfo_GUI(foundPatient, user, reg);
					dispose();
				}
				else JOptionPane.showMessageDialog(getParent(), "Patient not found");
			}
    	});
    	
    	CancelAppointmentsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new CancelAppointmentD_GUI(user, reg);
				dispose();
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
		this.setTitle("Doctor GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}
}
