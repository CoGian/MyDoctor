import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MyAppointments_GUI extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel MainPan = new JPanel();
	private JPanel panel2 = new JPanel();
	private JButton ShowAppointmentsButton= new JButton("Show Appointments") ;
	private JButton BackButton = new JButton("Back");
	private JButton DeleteButton = new JButton("Delete Appointment");
	private DefaultListModel<Appointment> ListModelApps = new DefaultListModel<Appointment>();
	private JList <Appointment> myApps = new JList<Appointment>(ListModelApps) ;

	
	public MyAppointments_GUI(Patient connected , Registry reg) {


		MainPan.add(new JLabel("Your Appointments :"));	
		myApps.setVisibleRowCount(10);
		MainPan.add(new JScrollPane(myApps));
		
		BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(box);

		panel.add(Box.createRigidArea(new Dimension (0,26)));
		panel.add(ShowAppointmentsButton);
		panel.add(Box.createRigidArea(new Dimension (0,50)));
		panel.add(DeleteButton);
		panel.add(Box.createRigidArea(new Dimension(0,100)));
		BackButton.setPreferredSize(new Dimension(100,50));
		MainPan.add(BackButton);
		panel2.add(panel);
		
		ShowAppointmentsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ArrayList<Appointment> myAppointments = connected.getAppointmentList();
				for (Appointment app : myAppointments) 
					ListModelApps.addElement(app);
				ShowAppointmentsButton.setEnabled(false);
			}
		});
		
		DeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (myApps.getSelectedValue()!=null) {
					int dialogResult = JOptionPane.showConfirmDialog(DeleteButton, "Are you sure you want to delete this appointment ? ");
					if (dialogResult == JOptionPane.YES_OPTION) {
						Appointment SelectedAppointment = myApps.getSelectedValue();
						connected.cancelAppointment(SelectedAppointment);
						new Patient_GUI(connected,reg);
						dispose();
						}	
				}
				else {
					JOptionPane.showMessageDialog(DeleteButton, "Choose an appointment to delete please.");
				}
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
		
		this.getContentPane().setLayout(new GridLayout(1,2));
		this.getContentPane().add(MainPan);
		this.getContentPane().add(panel2);
		this.setSize(550,300);
		this.setVisible(true);
		this.setTitle("MY APPOINTMENTS GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
