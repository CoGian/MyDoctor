import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MakeReview_GUI extends JFrame {
	
	private JPanel panel = new JPanel(); 
	private JPanel DoctorListPanel = new JPanel() ; 
	private JPanel ReviewPanel = new JPanel() ;
	
	private DefaultListModel<String> DDoctors = new DefaultListModel<String>();	
	
	private JList<String> doctorsJList = new JList<String>();
	
	private JScrollPane doctorPane ; 
	
	public MakeReview_GUI(Patient user, Registry reg)  {
	
		DoctorListPanel.setLayout(new GridLayout(2,1,10,10));
		
		doctorsJList.setModel(DDoctors);
		DDoctors.addElement("Marinos");
		DDoctors.addElement("Papadopoulous");
		doctorPane = new JScrollPane(doctorsJList);
		TitledBorder  title = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black), "My Doctors");
        title.setTitleJustification(TitledBorder.CENTER);
        doctorPane.setBorder(title);
		DoctorListPanel.add(doctorPane) ; 
		
		
		ReviewPanel.setLayout(new GridLayout(5,1,0,0));
        
		  
		ReviewPanel.add(new JLabel("Cleanliness :"));  
		ReviewPanel.add(new JLabel("How satisfied are you with the cleanliness of the area you were treated in?"));  
		
		final JSlider slider = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider.setPreferredSize(new Dimension(10,5));
		slider.setMinorTickSpacing(1);  
		slider.setMajorTickSpacing(1);  
		slider.setPaintTicks(true);  
	    slider.setPaintLabels(true);
		 
		ReviewPanel.add(slider); 
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(DoctorListPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	this.getContentPane().add(ReviewPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(60,0)));
    	
    	
    	
		
		this.setSize(900,500);
		this.setVisible(true);
		this.setTitle("MakeReview GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	
	} 
	
	
	

}
