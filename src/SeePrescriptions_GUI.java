import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeePrescriptions_GUI extends JFrame{
	
	private JPanel panel2  = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JButton BackButton = new JButton("Back");
	private JButton ShowDoctors = new JButton ("Show Doctors");
	private JButton ShowPrescription = new JButton("Show Prescription");
	private JComboBox doctors_list = new JComboBox();
	private JComboBox Specialisation_list = new JComboBox(Registry.getSpeciality());
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private ArrayList<Doctor> RightDocs = new ArrayList<Doctor>();

	public SeePrescriptions_GUI(Patient connected , Registry reg) {
		

		
		panel.add(new JLabel("Specialisation :"));
		panel.add(Specialisation_list);
		panel.add(Box.createRigidArea(new Dimension(0,100)));

		
		panel2.add(BackButton);
		panel.add(ShowDoctors);
		panel.add(new JLabel("Doctors : "));
		panel.add(doctors_list);
		panel.add(ShowPrescription);
		
		ShowDoctors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel1.removeAll();
				for (int i = 0; i <RightDocs.size();i++) {
					RightDocs.remove(i);
				}
				doctors = connected.getDoctorsList();
				for (Doctor doc : doctors) {
					if (Specialisation_list.getSelectedItem().equals(doc.getSpeciality()))
						RightDocs.add(doc);
				}
				doctors_list.setModel(new DefaultComboBoxModel(RightDocs.toArray()));
			}
			
		});
		
		
		ShowPrescription.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HashMap<Doctor,String> prescriptionList =  connected.getPrescriptionList();
				Doctor  SelectedDoctor = (Doctor) doctors_list.getSelectedItem();
				String prescription = prescriptionList.get(SelectedDoctor);
				panel1.add(new JLabel("Your prescription is : "+prescription));
				doctors_list.removeAllItems();
			}	
		});
		
		BackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Patient_GUI(connected,reg);
				dispose();
			}
			
		});
		
		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().add(panel);
		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);
		this.setSize(800,400);
		this.setVisible(true);
		this.setTitle("MY APPOINTMENTS GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
