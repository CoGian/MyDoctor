import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities; 

public class StatisticsDoctorGUI extends JFrame {
	
	private Doctor aDoctor;
	private float total_cleanliness;
	private float total_staff_cooperation;
	private float total_dignity;
	private float total_involvement;
	private float int_general_rating;
	
	private JButton backButton = new JButton("Back");

	private Registry reg;
	private Admin admin;
	
	public StatisticsDoctorGUI(Doctor aDoctor,Registry reg,Admin admin) {
		
		
		this.reg=reg;
		this.admin=admin;
		
		this.aDoctor = aDoctor;
		total_cleanliness=aDoctor.getTotal_cleanliness();
		total_dignity=aDoctor.getTotal_dignity();
		total_involvement=aDoctor.getTotal_involvement();
		total_staff_cooperation=aDoctor.getTotal_staff_cooperation();
		int_general_rating=aDoctor.getOverall_rating();
		
		
		 
		 if(aDoctor.getReviewList().isEmpty() ) {
			   JOptionPane.showMessageDialog(new JPanel(), "This doctor has not been reviewed yet.");
			   new Admin_GUI(admin,reg);
		   }
		 else {
		BarChart_AWT chart = new BarChart_AWT("Doctor's Statistics", "Review Summary");
		chart.pack();        
		RefineryUtilities.centerFrameOnScreen(chart);        
		chart.setVisible(true); 
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		 }
		
 
	}
		public class BarChart_AWT extends ApplicationFrame {
   
			public BarChart_AWT( String applicationTitle , String chartTitle) {
				super( applicationTitle );        
				JFreeChart barChart = ChartFactory.createBarChart(chartTitle,"Category","Score",createDataset(),
						PlotOrientation.VERTICAL,true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
				chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );      
				chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.PAGE_AXIS));
				setContentPane( chartPanel ); 
				chartPanel.add(backButton);

				backButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						dispose();
					}
				});
			}
   
   private CategoryDataset createDataset( ) {
	   
	   final String cleanliness = "Cleanliness";        
	   final String staff_cooperation = "Staff Cooperation";        
	   final String dignity = "Dignity & Respect";        
	   final String involvement_in_decisions = "Involvemen in Decisions";        
	   final String general_rating = "Overall";    
	   final String main = "Doctor"; 
	   DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  	
	   System.out.println(total_cleanliness+total_dignity);
	  
	   dataset.addValue( total_cleanliness/aDoctor.getReviewList().size(), main , cleanliness );                
	   dataset.addValue( total_staff_cooperation/aDoctor.getReviewList().size() , main , staff_cooperation ); 
	   dataset.addValue( total_dignity/aDoctor.getReviewList().size() , main , dignity );        
	   dataset.addValue( total_involvement/aDoctor.getReviewList().size() , main , involvement_in_decisions );       
	   dataset.addValue( StatisticsDoctorGUI.this.int_general_rating/aDoctor.getReviewList().size()  , main , general_rating );       	

	   return dataset; 
   }
   
		}	
}