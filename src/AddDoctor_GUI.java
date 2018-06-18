import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericDeclaration;

import javax.swing.*;


public class AddDoctor_GUI extends JFrame{
	
	private JPanel RegisterPanel = new JPanel() ; 
	

	private JTextField UsernameRegField = new JTextField(20);
	private JPasswordField PasswordRegField = new JPasswordField(20);
	private JTextField NameField = new JTextField(20);
	private JTextField SurnameField = new JTextField() ; 
	private JTextField TelephoneField = new JTextField(20);
	private JTextField CityField = new JTextField(20);
	private JTextField EmailField = new JTextField(20);
	private JTextField AgeField = new JTextField(20);
	private JTextField SpecialityField = new JTextField(20);
	private JTextField TagField = new JTextField(20) ; 
	String [] genders = { "Male", "Female" };
	private JComboBox<String> GenderBox = new JComboBox<String>(genders);
	
	private JButton RegisterButton = new JButton("Register");
	private JButton BackButton = new JButton("Back") ; 
	

	public AddDoctor_GUI(Admin user, Registry reg)
	{
		
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
		RegisterPanel.add(new JLabel("Username: (AMKA)"));
		RegisterPanel.add(UsernameRegField);
		RegisterPanel.add(new JLabel("Password: "));
		RegisterPanel.add(PasswordRegField);
		RegisterPanel.add(new JLabel("Name: "));
		RegisterPanel.add(NameField);
		RegisterPanel.add(new JLabel("Surname: "));
		RegisterPanel.add(SurnameField);
		RegisterPanel.add(new JLabel("Speciality:"));
		RegisterPanel.add(SpecialityField);
		RegisterPanel.add(new JLabel("Tag:"));
		RegisterPanel.add(TagField) ; 
		RegisterPanel.add(new JLabel("City: "));
		RegisterPanel.add(CityField);
		RegisterPanel.add(new JLabel("Telephone: "));
		RegisterPanel.add(TelephoneField);
		RegisterPanel.add(new JLabel("E-mail: "));
		RegisterPanel.add(EmailField);
		RegisterPanel.add(new JLabel("Age: "));
		RegisterPanel.add(AgeField);
		RegisterPanel.add(new JLabel("Gender: "));
		RegisterPanel.add(GenderBox);
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
		RegisterPanel.add(RegisterButton);
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
		RegisterPanel.add(BackButton  ); 
		RegisterPanel.add(Box.createRigidArea(new Dimension(0,10)));
		this.setContentPane(RegisterPanel);
		this.getContentPane().setLayout(new GridLayout(28, 1,5,0));
		
		RegisterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    String amka = UsernameRegField.getText();
				 String mail = EmailField.getText();
				 String name = NameField.getText();
				 String surname =  SurnameField.getText();
				 String age = AgeField.getText() ; 
				 int gender = GenderBox.getSelectedIndex() ; 
			     String telephone = TelephoneField.getText();
				 String password = PasswordRegField.getText();
				 String cityName = CityField.getText();
				 String tag = TagField.getText(); 
				 String speciality = SpecialityField.getText();
				 if(amka!= null && amka.length() == 11 && mail != null && name != null &&
						 age != null && surname != null && gender!= -1&&telephone != null&&password != null
						 && cityName != null && tag != null && speciality != null){
					   
					  
					  boolean gender1 ; 
					  if(gender==1)
						  gender1 = true ; 
					  else 
						  gender1 = false ; 
					  
					  try {
					  int age1 = Integer.parseInt(age); 
					  new Doctor(amka, mail, name, surname, age1, gender1, telephone, password, cityName, tag, speciality);
				      JOptionPane.showMessageDialog(RegisterPanel, "Registration Completed");
				      Serialization.SaveToFile(reg);
					  }catch (Exception e1) {
						// TODO: handle exception
						  JOptionPane.showMessageDialog(RegisterPanel, "Wrong Age Format!");
					   }
					  
					  
				 }
				 else
					 JOptionPane.showMessageDialog(RegisterPanel, "Completion Incorrect please check all the fields to continue!");
				
			}
		});
		
		
		
		BackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			   new 	Admin_GUI(user,reg);
			   dispose() ; 
			}
		});
		
		this.setVisible(true) ; 
		this.setSize(300,600);
		this.setTitle("Add a Doctor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		
	}
}
