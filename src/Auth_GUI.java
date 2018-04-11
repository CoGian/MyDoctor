import java.awt.*;

import javax.swing.*;

public class Auth_GUI extends JFrame{

	private JPanel LoginPanel = new JPanel() ; 
	private JPanel RegisterPanel = new JPanel() ; 
	
	private JButton LoginButton = new JButton("Login");
	private JButton RegisterButton = new JButton("Register");
	
	
	private JTextField UsernameLogField = new JTextField(20);
	private JPasswordField PasswordLogField = new JPasswordField(20);
	
	private JTextField UsernameRegField = new JTextField(20);
	private JPasswordField PasswordRegField = new JPasswordField(20);
	private JTextField NameField = new JTextField(20);
	private JTextField TelephoneField = new JTextField(20);
	private JTextField AddressField = new JTextField(20);
	private JTextField EmailField = new JTextField(20);
	private JTextField AgeField = new JTextField(20);
	
	String [] genders = { "Male", "Female" };
	private JComboBox GenderField = new JComboBox(genders);
	
	public Auth_GUI() {
		LoginPanel.setLayout(new BoxLayout(LoginPanel, BoxLayout.PAGE_AXIS));
				
		LoginPanel.add(new JLabel("Username:"));
		LoginPanel.add(Box.createHorizontalGlue());
		LoginPanel.add(UsernameLogField);
		LoginPanel.add(new JLabel("Password:"));
		LoginPanel.add(PasswordLogField);
		LoginPanel.add(LoginButton);
		
		RegisterPanel.setLayout(new BoxLayout(RegisterPanel, BoxLayout.PAGE_AXIS));
		
		RegisterPanel.add(new JLabel("Username: "));
		RegisterPanel.add(UsernameRegField);
		RegisterPanel.add(new JLabel("Password: "));
		RegisterPanel.add(PasswordRegField);
		RegisterPanel.add(new JLabel("Full Name: "));
		RegisterPanel.add(NameField);
		RegisterPanel.add(new JLabel("Address: "));
		RegisterPanel.add(AddressField);
		RegisterPanel.add(new JLabel("Telephone: "));
		RegisterPanel.add(TelephoneField);
		RegisterPanel.add(new JLabel("E-mail: "));
		RegisterPanel.add(EmailField);
		RegisterPanel.add(new JLabel("Age: "));
		RegisterPanel.add(AgeField);
		RegisterPanel.add(new JLabel("Gender: "));
		RegisterPanel.add(GenderField);
		RegisterPanel.add(RegisterButton);
				
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.getContentPane().add(LoginPanel);
		this.getContentPane().add(Box.createRigidArea(new Dimension(20,0)));
		this.getContentPane().add(RegisterPanel);
		this.setSize(470,400);
		this.setVisible(true);
		this.pack();
		this.setTitle("LOGIN GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
