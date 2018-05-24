import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Auth_GUI extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;
	private JPanel LoginPanel = new JPanel() ; 
	private JPanel RegisterPanel = new JPanel() ; 
	
	private JButton LoginButton = new JButton("Login");
	private JButton RegisterButton = new JButton("Registry");
	
	
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
	private JComboBox<String> GenderField = new JComboBox<String>(genders);
	
	private Registry reg;
	
	public Auth_GUI(Registry reg) {
		this.reg = reg;
		
		LoginPanel.setLayout(new BoxLayout(LoginPanel, BoxLayout.PAGE_AXIS));
				
		LoginPanel.add(Box.createRigidArea(new Dimension(0,120)));
		LoginPanel.add(new JLabel("Username:"));
		LoginPanel.add(Box.createHorizontalGlue());
		LoginPanel.add(UsernameLogField);
		LoginPanel.add(new JLabel("Password:"));
		LoginPanel.add(PasswordLogField);
		LoginPanel.add(Box.createRigidArea(new Dimension(0,120)));
		LoginPanel.add(LoginButton);
		LoginPanel.add(Box.createRigidArea(new Dimension(0,10)));
		
		RegisterPanel.setLayout(new BoxLayout(RegisterPanel, BoxLayout.PAGE_AXIS));
		
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
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
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
		RegisterPanel.add(RegisterButton);
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
				
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		this.getContentPane().add(LoginPanel);
		this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
		this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		this.getContentPane().add(RegisterPanel);
		this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
		this.setVisible(true);
		this.pack();
		this.setTitle("LOGIN GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		LoginButton.addActionListener(this);
		RegisterButton.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource().equals(LoginButton)) {
			
			Object user = new Object();
			user = reg.authentication(UsernameLogField.getText(), PasswordLogField.getText());
		    
			if(user instanceof Patient) {
				new Patient_GUI((Patient) user,reg);
				dispose();
			}
			else if(user instanceof Doctor) {
				new Doctor_GUI((Doctor) user , reg);
				dispose();
			}
			else if(user instanceof Admin){		
			
				new Admin_GUI((Admin)user, reg) ; 
				dispose();
			}
			else
				JOptionPane.showMessageDialog(this.getContentPane(), "Wrong Username or Password");
		}
		else if(e.getSource().equals(RegisterButton)) {
			
		}
	}
		
	
}
