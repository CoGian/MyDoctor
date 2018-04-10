import java.awt.GridLayout;

import javax.swing.*;

public class Auth_GUI extends JFrame{

	private JPanel panel = new JPanel(); 
	private JPanel LoginPanel = new JPanel() ; 
	private JPanel RegisterPanel = new JPanel() ; 
	
	private JButton LoginButton = new JButton("Login");
	private JButton RegisterButton = new JButton("Register");
	
	
	private JTextField UsernameLogField = new JTextField();
	private JTextField PasswordLogField = new JTextField();
	
	private JTextField UsernameRegField = new JTextField();
	private JTextField PasswordRegField = new JTextField();
	private JTextField NameField = new JTextField();
	private JTextField TelephoneField = new JTextField();
	private JTextField AddressField = new JTextField();
	private JTextField EmailField = new JTextField();
	private JTextField AgeField = new JTextField();
	
	String [] genders = { "Male", "Female" };
	private JComboBox GenderField = new JComboBox(genders);
	
	public Auth_GUI() {
		LoginPanel.setLayout(new GridLayout(5,1,10,50));
		
		LoginPanel.add(new JLabel("Username:"));
		LoginPanel.add(UsernameLogField);
		LoginPanel.add(new JLabel("Password: "));
		LoginPanel.add(PasswordLogField);
		LoginPanel.add(LoginButton);
		
		this.setContentPane(panel);
       	this.getContentPane().add(LoginPanel);
		this.setSize(800,500);
		this.setVisible(true);
		this.setTitle("LOGIN GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
