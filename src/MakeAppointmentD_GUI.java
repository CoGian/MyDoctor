import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class MakeAppointmentD_GUI extends JFrame{
	
	private JPanel listsPanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	
	private DefaultListModel<String> DHours = new DefaultListModel<String>();
	private DefaultListModel<String> DDays = new DefaultListModel<String>(); 
	private JList hoursList = new JList();
	private JList daysList = new JList();
	
	private JButton showHoursButton = new JButton("Show Hours");
	private JButton makeAppointmentButton = new JButton("Make Appointment");
	private JButton backButton = new JButton("Back");
	
	

	public MakeAppointmentD_GUI(Patient patient, Doctor doctor, Registry reg) {
		// TODO Auto-generated constructor stub
		
		listsPanel.add(new JScrollPane(daysList));
		listsPanel.add(new JScrollPane(hoursList));
		buttonsPanel.add(backButton);
		buttonsPanel.add(showHoursButton);
		buttonsPanel.add(makeAppointmentButton);
		
		makeAppointmentButton.setSize(30, 10);
		
		LocalDate localDate ;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		for (int i = 0 ;i<30;i++) {
			localDate = LocalDate.now().plusDays(i);
			String formattedString = localDate.format(formatter);
			DDays.addElement(formattedString);
		}
		daysList.setModel(DDays);
		
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
					ArrayList<String> AvailHours = doctor.showHours(i+1);	
					for (String hour : AvailHours){
						DHours.addElement(hour);
					}
					String SelectedHour = (String) hoursList.getSelectedValue();
				}
				else if (SelectedDay==null)
					JOptionPane.showMessageDialog(showHoursButton, "Please choose a day");
		
			}
			
		});
		
		hoursList.setModel(DHours);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PatientInfo_GUI(patient, doctor, reg);
				dispose();
			}
			
		});

		makeAppointmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String SelectedDay = (String) daysList.getSelectedValue();
				String SelectedHour = (String) hoursList.getSelectedValue();
				if (SelectedHour!=null) {
					String temp1[]=SelectedHour.split("-");
					String temp = SelectedDay+" " + temp1[0];	
					try {
						Date date;
						if (temp1[0].equals("12:00") || temp1[0].equals("12:30")) {
							temp = temp + " PM";
							date = new SimpleDateFormat("dd MMM yyyy hh:mm a").parse(temp);
						}
						else 
							date = new SimpleDateFormat("dd MMM yyyy hh:mm").parse(temp);

						
						LocalDate SelectedDate1 = LocalDate.parse(SelectedDay, formatter);
						int i = 0 ;
						while (i<10) {
							if (SelectedDate1.equals(LocalDate.now().plusDays(i)))
								break ;
							i++;
						}
						Appointment appointment = new Appointment(doctor,patient,date);
						patient.AddAppointment(appointment);
						doctor.addAppointment(i+1,SelectedHour,appointment);
						Serialization.SaveToFile(reg); //save to file
						JOptionPane.showMessageDialog(makeAppointmentButton, "Your appointment has been scheduled on : " + date );	
						patient.addDoctor(doctor);
						doctor.setVisits(doctor.getVisits() + 1);
						new PatientInfo_GUI(patient, doctor, reg);
						dispose();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(makeAppointmentButton,"Choose a time please");
				}
				
			}
			
		});
		
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.getContentPane().add(listsPanel);
		this.getContentPane().add(buttonsPanel);
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Make Appointment GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//centre the window
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		
		
	}

}
