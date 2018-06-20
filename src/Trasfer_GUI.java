import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Trasfer_GUI extends JFrame {

	private JPanel panel = new JPanel(); 
	private JPanel listpanel  = new  JPanel() ; 
	private JPanel buttonpanel = new JPanel() ;  
    private DefaultListModel<String> CCities = new DefaultListModel<String>();	
	
	private JList<String> CitiesJList = new JList<String>();
	
	private JScrollPane CitiesPane ; 
	
	private JButton confirmButton = new JButton("Confirm") ; 
	private JButton backButton = new JButton("Back");	
	
	public Trasfer_GUI(Doctor doc,Admin user,Registry reg)
	{
	    listpanel.setLayout(new GridLayout(3,1,0,30));
		listpanel.add(new JLabel("Select a city to Transfer:")) ; 
		CitiesJList.setModel(CCities);
		
		for(int i =0 ; i<Registry.getCities().length ; i++) {
			if(!Registry.getCities()[i].equals(doc.getCityName())) {
				CCities.addElement(Registry.getCities()[i]);
			}
		}
		CitiesPane = new JScrollPane(CitiesJList);
		CitiesPane.setSize(new Dimension(30, 50));
		listpanel.add(CitiesPane);
		
		buttonpanel.add(confirmButton) ; 
		buttonpanel.add(backButton) ; 
		this.setContentPane(panel);
       	this.getContentPane().setLayout(new GridLayout(1, 2));
        this.getContentPane().add(listpanel);
       	this.getContentPane().add(buttonpanel);
       	
       	confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String city = CitiesJList.getSelectedValue() ; 
				if(city!=null)
				{
					user.trasferDoctor(doc, reg, city) ; 
					JOptionPane.showMessageDialog(panel ,"Transfer Completed! \n Doctor's new city is the selected city:" + city);
					CCities.removeAllElements();

					for(int i =0 ; i<Registry.getCities().length ; i++) {
						if(!Registry.getCities()[i].equals(doc.getCityName())) {
							CCities.addElement(Registry.getCities()[i]);
						}
					}
					
					
				}
				else
					JOptionPane.showMessageDialog(panel ,"Choose a city" );
				
			}
		});
       	
       	
       	backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_GUI(user, reg) ; 
				dispose();
			}
		});
       	
       	this.setSize(400,250);
		this.setVisible(true);
		this.setTitle("Trasfer GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centre the window
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}
	
}
