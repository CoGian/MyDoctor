import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MakeReview_GUI extends JFrame {
	
	private JPanel panel = new JPanel(); 
	private JPanel DoctorListPanel = new JPanel() ; 
	private JPanel ReviewPanel = new JPanel() ;
	
	private DefaultListModel<String> DDoctors = new DefaultListModel<String>();	
	
	private JList<String> doctorsJList = new JList<String>();
	
	private JScrollPane doctorPane ; 
	
	private JButton confirmButton = new JButton("Confirm") ; 
	private JButton backButton = new JButton("Back") ; 
	
	private int Cleanliness = 0 ; 
	private int StaffCo_operation = 0  ; 
	private int Dignity_and_respect = 0  ; 
    private int Involvement_in_decisions = 0  ; 
    
	public MakeReview_GUI(Patient user, Registry reg)  {
	
		DoctorListPanel.setLayout(new BoxLayout(DoctorListPanel, BoxLayout.Y_AXIS));
		
		doctorsJList.setModel(DDoctors);
		DDoctors.addElement("Marinos");
		DDoctors.addElement("Papadopoulous");
		doctorPane = new JScrollPane(doctorsJList);
	
		TitledBorder  title = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black), "My Doctors");
        title.setTitleJustification(TitledBorder.CENTER);
        doctorPane.setBorder(title);
        
        JToolTip instructions1 = new JToolTip() ; 
		instructions1.setTipText("First select doctor from the list");
		
		backButton.setPreferredSize((new Dimension(100, 50)));
		backButton.setAlignmentY(CENTER_ALIGNMENT);
		DoctorListPanel.add(Box.createRigidArea(new Dimension(100,10)));
		DoctorListPanel.add(instructions1);	
		DoctorListPanel.add(Box.createRigidArea(new Dimension(100,50)));
		DoctorListPanel.add(doctorPane) ; 
		DoctorListPanel.add(Box.createRigidArea(new Dimension(100,200)));
	   	DoctorListPanel.add(backButton) ; 
		DoctorListPanel.add(Box.createRigidArea(new Dimension(100,10)));
		
		
		ReviewPanel.setLayout(new GridLayout(14,1,0,0));
		
		JToolTip instructions2 = new JToolTip() ; 
		instructions2.setTipText("1:Very dissatisfied 2:Fairly dissatisfied 3:Neither satisfied nor dissatisfied 4:Fairly satisfied 5:Very satisfied");
		ReviewPanel.add(instructions2);	
		
        ReviewPanel.add(new JLabel("Cleanliness:"));  
		ReviewPanel.add(new JLabel("How satisfied are you with the cleanliness of the area you were treated in?"));  
		
		final JSlider slider1 = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider1.setPreferredSize(new Dimension(10,5));
		slider1.setMinorTickSpacing(1);  
		slider1.setMajorTickSpacing(1);  
		slider1.setPaintTicks(true);  
	    slider1.setPaintLabels(true);
		ReviewPanel.add(slider1);
				
		ReviewPanel.add(new JLabel("Staff co-operation:"));  
		ReviewPanel.add(new JLabel("How satisfied are you that the hospital staff worked well together?"));  
		final JSlider slider2 = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider2.setPreferredSize(new Dimension(10,5));
		slider2.setMinorTickSpacing(1);  
		slider2.setMajorTickSpacing(1);  
		slider2.setPaintTicks(true);  
	    slider2.setPaintLabels(true);
		ReviewPanel.add(slider2);
				
		ReviewPanel.add(new JLabel("Dignity and respect:"));  
		ReviewPanel.add(new JLabel("How satisfied are you that you were treated with dignity and respect by the staff?"));  
		final JSlider slider3 = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider3.setPreferredSize(new Dimension(10,5));
		slider3.setMinorTickSpacing(1);  
		slider3.setMajorTickSpacing(1);  
		slider3.setPaintTicks(true);  
	    slider3.setPaintLabels(true);
		ReviewPanel.add(slider3);
		
		ReviewPanel.add(new JLabel("Involvement in decisions"));  
		ReviewPanel.add(new JLabel("How satisfied are you that you were involved in decisions about your care?"));  
		final JSlider slider4 = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider4.setPreferredSize(new Dimension(10,5));
		slider4.setMinorTickSpacing(1);  
		slider4.setMajorTickSpacing(1);  
		slider4.setPaintTicks(true);  
	    slider4.setPaintLabels(true);
		ReviewPanel.add(slider4);
		
		ReviewPanel.add(confirmButton) ; 
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
       	this.getContentPane().add(DoctorListPanel);
       	this.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
    	this.getContentPane().add(new JSeparator(SwingConstants.VERTICAL));
    	this.getContentPane().add(ReviewPanel);
    	this.getContentPane().add(Box.createRigidArea(new Dimension(60,0)));
    	
    	
    	confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Cleanliness = slider1.getValue() ;
				StaffCo_operation = slider2.getValue(); 
				Dignity_and_respect = slider3.getValue() ;
				Involvement_in_decisions = slider4.getValue() ; 
				String doctorFullName = doctorsJList.getSelectedValue(); 
				if(Cleanliness != 0 && StaffCo_operation!= 0 && Dignity_and_respect !=0 && Involvement_in_decisions!=0 
						&&doctorFullName!= null) {
					
					JOptionPane.showMessageDialog(panel, "Your review was recorded");
				}else
					JOptionPane.showMessageDialog(panel, "Select all the fields to continue");
				
			}
		});
		
    	backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Patient_GUI(user, reg);
				dispose();
			}
		});
		this.setSize(1000,700);
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
