import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PatientInfo_GUI extends JFrame{
	
	private JPanel panel = new JPanel();
	private JPanel InfoPanel = new JPanel();
	private JPanel ActionPanel = new JPanel();
	
	private JButton BackButton = new JButton("Back");
	private JButton MakeAppointmentButton = new JButton("Make Appointment");
	private JButton WritePrescriptionButton = new JButton("Write Prescription");

	private JTextPane PrescriptionField = new JTextPane();

	public PatientInfo_GUI(Patient foundPatient, Doctor user, Registry reg) {
		// TODO Auto-generated constructor stub
	    
		InfoPanel.setLayout(new GridLayout(13,1,10,10));
	    InfoPanel.add(new JLabel("Patient's Info")) ; 
	    InfoPanel.add(new JLabel("Name:" + foundPatient.getName()));
	    InfoPanel.add(new JLabel("Surname: " + foundPatient.getSurname()));
	    InfoPanel.add(new JLabel("AMKA: " + foundPatient.getAmka()));
	    InfoPanel.add(new JLabel("Age: " + foundPatient.getAge()));
	    if(foundPatient.isGender())
	    	InfoPanel.add(new JLabel("Gender: Female" ));
	    else
	    	InfoPanel.add(new JLabel("Gender: Male" ));
	    InfoPanel.add(new JLabel("Telephone: " + foundPatient.getTelephone()));
	    
	    ActionPanel.setLayout(new GridLayout(7,1,10,10));
	    ActionPanel.add(MakeAppointmentButton);
	    PrescriptionField.setText(foundPatient.getPrescriptionList().get(user));
	    ActionPanel.add(PrescriptionField);
	    ActionPanel.add(WritePrescriptionButton);
	    ActionPanel.add(BackButton);
	    
	    this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(InfoPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	this.getContentPane().add(ActionPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
	    
	    MakeAppointmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MakeAppointmentD_GUI(foundPatient,user,reg);
				dispose();
			}
	    	
	    });
	    
	    WritePrescriptionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user.writePrescription(foundPatient, PrescriptionField.getText());
				JOptionPane.showMessageDialog(getParent(), "Prescription saved!");
			}
	    	
	    });
	    
	    BackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Doctor_GUI(user,reg);
				dispose();
			}
	    	
	    });
	    
	    this.setSize(500,500);
		this.setVisible(true);
		this.setTitle("Patient Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}
}
