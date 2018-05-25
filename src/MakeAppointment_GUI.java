import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
public class MakeAppointment_GUI extends JFrame{

	private static final String[] Calendar = null;
	//panels
	
	private JPanel Appointment_Panel = new JPanel();
	private JPanel Search_Panel = new JPanel();
	private JPanel Result_Panel = new JPanel();
	private JPanel Make_Panel = new JPanel();
	private JPanel jlists_Panel = new JPanel();
	private JPanel test_panel = new JPanel();
	
	// text fields
	
	private JTextField tagfield = new JTextField("Instert Tag");
	
	//buttons
	
	private JButton BackButton = new JButton("Back");
	private JButton SearchButton = new JButton ("Search");
	private JButton Show_HoursButton = new JButton("Show Hours");
	private JButton InformationButton = new JButton ("Information");
	private JButton Make_AppointmentButton = new JButton ("Make the Appointment");
	
	// jlists ,deafultmodels
	private ListModel<Doctor> DDoctors = new DefaultListModel<Doctor>();
	private DefaultListModel<String> DHours = new DefaultListModel<String>();
	private DefaultListModel<String> DDays = new DefaultListModel<String>();
	
	private JList<Doctor> avail_docs = new JList<Doctor>();
	private JList<String> avail_hours = new JList<String>();
	private JList<String> days = new JList<String>();
	
	//boxes
	
	private JComboBox cities_list = new JComboBox(Registry.getCities());
	private JComboBox Specialisation_list = new JComboBox(Registry.getSpeciality());
	
	
	public MakeAppointment_GUI(Patient connected,Registry reg) {
	
		//search_Panel.
		Search_Panel.add(Box.createRigidArea(new Dimension(0,100)));
		Search_Panel.add(new JLabel("Cities :"));
		Search_Panel.add(cities_list);
		Search_Panel.add(new JLabel("Specialisation :"));
		Search_Panel.add(Specialisation_list);
		Search_Panel.add(new JLabel("Tag : "));
		Search_Panel.add(tagfield);

		Search_Panel.add(SearchButton);
		
		SearchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String SelectedCity = (String) cities_list.getSelectedItem();
				String SelectedSpeciality = (String) Specialisation_list.getSelectedItem();
				String SelectedTag = tagfield.getText();
				ArrayList<Doctor> ArrayListDocs = Registry.searchDoctor(SelectedCity,SelectedSpeciality,SelectedTag);
				for (Doctor  doc : ArrayListDocs ) {
					((DefaultListModel<Doctor>) DDoctors).addElement(doc);
				}
				SearchButton.setEnabled(false);
			}
		});
		//result_panel.
		Result_Panel.setLayout(new GridLayout(1,1000));
		
		//docs list.
		avail_docs.setModel(DDoctors);
		Result_Panel.add(new JLabel ("Available Docs :"));
		Result_Panel.add(new JScrollPane(avail_docs));
		
		//days list.
		
		LocalDate localDate ;


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		for (int i = 0 ;i<10;i++) {
			localDate = LocalDate.now().plusDays(i);
			String formattedString = localDate.format(formatter);
			DDays.addElement(formattedString);
		}
		days.setModel(DDays);
		Show_HoursButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String SelectedDay = days.getSelectedValue();
				Doctor SelectedDoctor = avail_docs.getSelectedValue();
				if (SelectedDay!=null && SelectedDoctor!=null) {
					//convert String to LocalDate
					LocalDate SelectedDate1 = LocalDate.parse(SelectedDay, formatter);
					int i = 0 ;
					while (i<10) {
						if (SelectedDate1.equals(LocalDate.now().plusDays(i)))
							break ;
						i++;
					}
					ArrayList<String> AvailHours = SelectedDoctor.showHours(i+1);	
					for (String hour : AvailHours){
						DHours.addElement(hour);
					}
					String SelectedHour = avail_hours.getSelectedValue();
				}
				else if (SelectedDay==null && SelectedDoctor== null)
					JOptionPane.showMessageDialog(Show_HoursButton, "Please choose doctor and day");
				else if (SelectedDoctor==null)
					JOptionPane.showMessageDialog(Show_HoursButton, "Please choose a doctor");
				else 
					JOptionPane.showMessageDialog(Show_HoursButton, "Please choose a day");
			}
		});
		
		Make_AppointmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Doctor SelectedDoctor = avail_docs.getSelectedValue();
				String SelectedDay = days.getSelectedValue();
				String SelectedHour = avail_hours.getSelectedValue();
				if (SelectedHour!=null) {
					String temp1[]=SelectedHour.split("-");
					String temp = SelectedDay+" " + temp1[0];
					System.out.println(temp);
					
					try {
						Date date;
						if (temp1[0].equals("12:00") || temp1[0].equals("12:30")) {
							temp = temp + " PM";
							date = new SimpleDateFormat("dd MMM yyyy hh:mm a").parse(temp);
							System.out.println(date);
						}
						else {
							date = new SimpleDateFormat("dd MMM yyyy hh:mm").parse(temp);
							System.out.println(date);
						}
						
						LocalDate SelectedDate1 = LocalDate.parse(SelectedDay, formatter);
						int i = 0 ;
						while (i<10) {
							if (SelectedDate1.equals(LocalDate.now().plusDays(i)))
								break ;
							i++;
						}	
						/*HashMap<Integer,Appointment[]> App = SelectedDoctor.getAppointmentMap();
						Appointment[] ap = App.get(i);
						new Appointment(SelectedDoctor,connected,date)
						*/		
						JOptionPane.showMessageDialog(Make_AppointmentButton, "Your appointment has been scheduled on : " + date );
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(Make_AppointmentButton,"Choose a time please");
				}
				
			}
			
		});
	
		Result_Panel.add(new JLabel("Available days :"));
		Result_Panel.add(new JScrollPane(days));
		
		//hours
		
		avail_hours.setModel(DHours);
		
		Result_Panel.add(new JLabel("Availble Hours :"));
		Result_Panel.add(new JScrollPane(avail_hours));
		
		BackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Patient_GUI(connected, reg);
				dispose();
			}
			
		});

		//test panel 
		
		BoxLayout box = new BoxLayout(test_panel,BoxLayout.Y_AXIS);
		test_panel.setLayout(box);
		Show_HoursButton.setPreferredSize(new Dimension (0,80));
		test_panel.add(Box.createRigidArea(new Dimension(0,20)));
		test_panel.add(Show_HoursButton);
		test_panel.add(Box.createRigidArea(new Dimension (0,30)));
		test_panel.add(InformationButton);
		Result_Panel.add(test_panel);
		//make the app.
	
		BackButton.setPreferredSize(new Dimension(100,80));
		Make_Panel.add(BackButton);
		Make_AppointmentButton.setPreferredSize(new Dimension(450,50));
		Make_Panel.add(Box.createRigidArea(new Dimension(0,150)));
		Make_Panel.add(Make_AppointmentButton);
		
		
		//final panel
		
		this.setContentPane(Appointment_Panel);
		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().add(Search_Panel);
		this.getContentPane().add(Result_Panel);
		this.getContentPane().add(Make_Panel);
		this.setSize(750,500);
		this.setVisible(true);
		this.setTitle("APPOINTMENT GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
