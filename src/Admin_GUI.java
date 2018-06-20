import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
public class Admin_GUI extends JFrame{
			
		private JPanel panel = new JPanel(); 
		private JPanel InfoPanel = new JPanel() ; 
		private JPanel ButtonPanel = new JPanel() ; 
			
		private JButton TransferButton = new JButton("Transfer") ; 
		private JButton DeleteButton = new JButton("Delete") ; 
		private JButton InformationButton = new JButton("Information") ; 
		private JButton StatisticsButton = new JButton("Statistics");
		private JButton AddADoctorButton = new JButton("Add a Doctor") ; 
		private JButton ConfigureButton = new JButton("Configure" ) ; 
		private JButton SignOutButton = new JButton("Sign out") ; 
		
		private JButton Company_StatisticsButton = new JButton("Company Statistics");
		
		private JTextField DoctorAMKAField  ; 
		private JTextField EmailField  ; 
		private JPasswordField PasswordField  ; 
		private JTextField TelephoneField  ; 
		private Admin user ; 
		
		
		
		public Admin_GUI(Admin admin,Registry reg) 
		{
			

			user = admin ; 
			

			//components of Button panel
		    ButtonPanel.setLayout(new GridLayout(11,1,10,30));
		    ButtonPanel.add(new JLabel("Choose an option:"));
		    DoctorAMKAField = new JTextField() ; 
		    ButtonPanel.add(new JLabel("Insert Doctor's AMKA:"));
		    ButtonPanel.add(DoctorAMKAField) ; 
			ButtonPanel.add(TransferButton);
			ButtonPanel.add(DeleteButton);
			ButtonPanel.add(InformationButton);
			ButtonPanel.add(StatisticsButton);
			ButtonPanel.add(AddADoctorButton);
			ButtonPanel.add(SignOutButton);
			ButtonPanel.add(Company_StatisticsButton);
		 
			//sets JFields 
			EmailField = new JTextField(user.getMail(),20);
			PasswordField = new JPasswordField(user.getPassword(),20);
			TelephoneField = new JTextField(user.getTelephone(),20) ; 
			
			//components of InfoPanel 
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
		       
		    
			//components  of panel 
			this.setContentPane(panel);
	       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
	       	this.getContentPane().add(ButtonPanel);
	       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
	    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
	    	this.getContentPane().add(InfoPanel);
	    	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
			
			TransferButton.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String amka =  DoctorAMKAField.getText() ; 
					Doctor doc = admin.searchDoctorByAMKA(amka, reg) ; 
					if(doc!= null) {
						new Trasfer_GUI(doc,user,reg);
					    dispose() ; 
					}
					else
						JOptionPane.showMessageDialog(panel, "Doctor not found");
				
				}
			
			
			
			}) ; 
			
			InformationButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String amka =  DoctorAMKAField.getText() ; 
					Doctor doc = admin.searchDoctorByAMKA(amka, reg) ; 
					if(doc!= null) {
						new DoctorInfo_GUI(doc, reg, user) ; 
						dispose() ; 
					}
					else
						JOptionPane.showMessageDialog(panel, "Doctor not found");
				
					
				}
			});
			
			StatisticsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String amka =  DoctorAMKAField.getText() ; 
					Doctor doc = admin.searchDoctorByAMKA(amka, reg) ; 
					if(doc!= null) {
						
						new StatisticsDoctorGUI(doc,reg,user);
						
					}
					else
						JOptionPane.showMessageDialog(panel, "Doctor not found");
				
					
				}
			});
			
			Company_StatisticsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Statistics(reg);
				}
			});
			
			DeleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String amka =  DoctorAMKAField.getText() ; 
					Doctor doc = admin.searchDoctorByAMKA(amka, reg) ; 
					if(doc!= null) {
						
						Object[] options = {"Yes, please",
			                    "No, thanks"};
						int n = JOptionPane.showOptionDialog(panel,
								"Are you sure?", "Do you want to delete " + doc.getName() +" "+
								doc.getSurname(),JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,null,options,  options[1]);
						if(n==0){
							user.deleteDoctor(doc, reg);
							JOptionPane.showMessageDialog(panel, "Doctor Deleted") ; 
						}
					     
					}
					else
						JOptionPane.showMessageDialog(panel, "Doctor not found");
				
				}
			});
			
			
			AddADoctorButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new AddDoctor_GUI(user , reg) ; 
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
			
			this.setSize(500,600);
			this.setVisible(true);
			this.setTitle("Admin GUI");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//centre the window
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
			int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
			this.setLocation(x, y);
				

		}

}
