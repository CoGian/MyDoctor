import java.awt.GridLayout;

import javax.swing.*;

public class Auth_GUI extends JFrame{

	private JPanel panel = new JPanel(); 
	private JPanel LoginPanel = new JPanel() ; 
	private JPanel RegisterPanel = new JPanel() ; 
	
	private JButton LoginButton = new JButton("Login");
	private JButton RegisterButton = new JButton("Register");
	
	
	private JTextField UsernameLogField = new JTextField();
	private JPasswordField PasswordLogField = new JPasswordField();
	
	private JTextField UsernameRegField = new JTextField();
	private JPasswordField PasswordRegField = new JPasswordField();
	private JTextField NameField = new JTextField();
	private JTextField TelephoneField = new JTextField();
	private JTextField AddressField = new JTextField();
	private JTextField EmailField = new JTextField();
	private JTextField AgeField = new JTextField();
	
	String [] genders = { "Male", "Female" };
	private JComboBox GenderField = new JComboBox(genders);
	
	public Auth_GUI() {
		LoginPanel.setLayout(new GridLayout(5,1));
		
		LoginPanel.add(new JLabel("Username:"));
		LoginPanel.add(UsernameLogField);
		LoginPanel.add(new JLabel("Password: "));
		LoginPanel.add(PasswordLogField);
		LoginPanel.add(LoginButton);
		
		RegisterPanel.setLayout(new GridLayout(17,1));
		
		RegisterPanel.add(new JLabel("Username: "));
		RegisterPanel.add(UsernameRegField);
		RegisterPanel.add(new JLabel("Password: "));
		RegisterPanel.add(PasswordRegField);
		RegisterPanel.add(new JLabel("Name: "));
		RegisterPanel.add(NameField);
		RegisterPanel.add(new JLabel("Address: "));
		RegisterPanel.add(AddressField);
		RegisterPanel.add(new JLabel("Telephone: "));
		RegisterPanel.add(TelephoneField);
		RegisterPanel.add(new JLabel("e-mail: "));
		RegisterPanel.add(EmailField);
		RegisterPanel.add(new JLabel("Age: "));
		RegisterPanel.add(AgeField);
		RegisterPanel.add(new JLabel("Gender: "));
		RegisterPanel.add(GenderField);
		RegisterPanel.add(RegisterButton);
				
		this.setContentPane(panel);
		this.getContentPane().setLayout(new GridLayout(1,2,30,0));
		this.getContentPane().add(LoginPanel);
		this.getContentPane().add(RegisterPanel);
		this.setSize(800,500);
		this.setVisible(true);
		this.setTitle("LOGIN GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
