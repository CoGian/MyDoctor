import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class MakeAppointment_GUI extends JFrame{

	//panels
	
	private JPanel Appointment_Panel = new JPanel();
	private JPanel Search_Panel = new JPanel();
	private JPanel Result_Panel = new JPanel();
	private JPanel Make_Panel = new JPanel();
	private JPanel jlists_Panel = new JPanel();
	private JPanel test_panel = new JPanel();
	
	//buttons
	
	
	private JButton Search_Button = new JButton ("Search");
	private JButton Show_Hours_btn = new JButton("Show Hours");
	private JButton Informat_btn = new JButton ("Information");
	private JButton Make_Appoint = new JButton ("Make the Appointment");
	
	// jlists ,deafultmodels
	private DefaultListModel<String> DDoctors = new DefaultListModel<String>();
	private DefaultListModel<String> DHours = new DefaultListModel<String>();
	private DefaultListModel<String> DDays = new DefaultListModel<String>();
	
	private JList<String> avail_docs = new JList<String>();
	private JList<String> avail_hours = new JList<String>();
	private JList<String> days = new JList<String>();
	
	//boxes
	String[] cities = {"Athens" , "Thessaloniki" , "Patra" };
	String [] Specialisation = { "Cardiologist" , "Pneumologist" , "Otolaryngologist"};
	
	private JComboBox cities_list = new JComboBox(cities);
	private JComboBox Specialisation_list = new JComboBox(Specialisation);
	
	
	public MakeAppointment_GUI() {
	
		//search_Panel.
		Search_Panel.add(Box.createRigidArea(new Dimension(0,100)));
		Search_Panel.add(new JLabel("Cities :"));
		Search_Panel.add(cities_list);
		Search_Panel.add(new JLabel("Specialisation :"));
		Search_Panel.add(Specialisation_list);
		

		Search_Panel.add(Search_Button);
		
		//result_panel.
		Result_Panel.setLayout(new GridLayout(1,1000));
		
		//docs list.
		
		avail_docs.setModel(DDoctors);
		DDoctors.addElement("Marinos");
		DDoctors.addElement("Papadopoulous");
		Result_Panel.add(new JLabel ("Available Docs :"));
		Result_Panel.add(new JScrollPane(avail_docs));
		
		
		//days list.
		days.setModel(DDays);
		DDays.addElement("Monday");
		DDays.addElement("Tuesday");
		DDays.addElement("Wednesday");
		DDays.addElement("Thursday");
		DDays.addElement("Friday");
		Result_Panel.add(new JLabel("Available days :"));
		Result_Panel.add(new JScrollPane(days));
		
		//hours
		avail_hours.setModel(DHours);
		DHours.addElement("12:00-12:30");
		DHours.addElement("12:30-13:00");
		DHours.addElement("13:00-13:30");
		DHours.addElement("13:30-14:00");
		DHours.addElement("14:00-14:30");
		DHours.addElement("14:30-15:00");
		
		
		Result_Panel.add(new JLabel("Availble Hours :"));
		Result_Panel.add(new JScrollPane(avail_hours));
		
		//test panel 
		
		BoxLayout box = new BoxLayout(test_panel,BoxLayout.Y_AXIS);
		test_panel.setLayout(box);
		Show_Hours_btn.setPreferredSize(new Dimension (0,80));
		test_panel.add(Box.createRigidArea(new Dimension(0,20)));
		test_panel.add(Show_Hours_btn);
		test_panel.add(Box.createRigidArea(new Dimension (0,30)));
		test_panel.add(Informat_btn);
		Result_Panel.add(test_panel);
		//make the app.
		Make_Appoint.setPreferredSize(new Dimension(450,50));
		Make_Panel.add(Box.createRigidArea(new Dimension(0,150)));
		Make_Panel.add(Make_Appoint);
		

		
		//final panel
		
		this.setContentPane(Appointment_Panel);
		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().add(Search_Panel);
		this.getContentPane().add(Result_Panel);
		this.getContentPane().add(Make_Panel);
		this.setSize(750,500);
		this.setVisible(true);
		this.setTitle("APPOINTMENT GUI");
		
	}
	
}
