import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;

public class CancelAppointmentD_GUI extends JFrame{

	private JPanel listsPanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	
	private DefaultListModel<String> DHours = new DefaultListModel<String>();
	private DefaultListModel<String> DDays = new DefaultListModel<String>(); 
	private JList hoursList = new JList();
	private JList daysList = new JList();
	
	private JButton showHoursButton = new JButton("Show Hours");
	private JButton cancelAppointmentButton = new JButton("Cancel Appointment");
	private JButton backButton = new JButton("Back");
	
	public CancelAppointmentD_GUI(Doctor user, Registry reg) {
		// TODO Auto-generated constructor stub
		listsPanel.add(new JScrollPane(daysList));
		listsPanel.add(new JScrollPane(hoursList));
		buttonsPanel.add(backButton);
		buttonsPanel.add(showHoursButton);
		buttonsPanel.add(cancelAppointmentButton);
		
		cancelAppointmentButton.setSize(30, 10);
		
		LocalDate localDate ;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		for (int i = 0 ;i<30;i++) {
			localDate = LocalDate.now().plusDays(i);
			String formattedString = localDate.format(formatter);
			DDays.addElement(formattedString);
		}
		daysList.setModel(DDays);
		hoursList.setModel(DHours);
		
		showHoursButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DHours.removeAllElements();
				String SelectedDay = (String) daysList.getSelectedValue();
				if (SelectedDay!=null) {
					//convert String to LocalDate
					LocalDate day = LocalDate.parse(SelectedDay, formatter);
					int i = 0 ;
					while (i<30) {
						if (day.equals(LocalDate.now().plusDays(i)))
							break ;
						i++;
					}
					ArrayList<String> hours = user.showAppointedHours(i+1);	
					for (String hour : hours){
						DHours.addElement(hour);
					}
					String SelectedHour = (String) hoursList.getSelectedValue();
				}
				else if (SelectedDay==null)
					JOptionPane.showMessageDialog(showHoursButton, "Please choose a day");
		
			}
			
		});
		
		cancelAppointmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int SelectedDay = daysList.getSelectedIndex();
				int SelectedHour = hoursList.getSelectedIndex();
				user.cancelAppointment(SelectedDay, SelectedHour);
				Serialization.SaveToFile(reg);
			}
		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Doctor_GUI(user, reg);
				dispose();
			}
			
		});
		
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.getContentPane().add(listsPanel);
		this.getContentPane().add(buttonsPanel);
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Cancel Appointment GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}
}
