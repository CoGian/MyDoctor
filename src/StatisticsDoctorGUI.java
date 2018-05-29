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
	private Registry aRegistry;
	private int total_cleanliness;
	private int total_staff_cooperation;
	private int total_dignity;
	private int total_involvement;
	private int general_rating;
	
	
	public StatisticsDoctorGUI(Doctor aDoctor,Registry aRegistry) {
		
		this.aDoctor = aDoctor;
		 if(aDoctor.getReviewList().isEmpty() ) {
			   JOptionPane.showMessageDialog(new JPanel(), "This doctor has not been reviewed yet.");
			   
		   }
		 else {
		BarChart_AWT chart = new BarChart_AWT("Doctor's Statistics", "Review Summary");
		chart.pack();        
		RefineryUtilities.centerFrameOnScreen(chart);        
		chart.setVisible(true); 
		 }
 
	}
		public class BarChart_AWT extends ApplicationFrame {
   
			public BarChart_AWT( String applicationTitle , String chartTitle) {
				super( applicationTitle );        
				JFreeChart barChart = ChartFactory.createBarChart(chartTitle,"Category","Score",createDataset(),
						PlotOrientation.VERTICAL,true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
				chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
				setContentPane( chartPanel ); 
			}
   
   private CategoryDataset createDataset( ) {
	  
	
	   for(Review aReview: aDoctor.getReviewList()) {
		   total_cleanliness+=aReview.getCleanliness();
		   total_staff_cooperation+=aReview.getStaffCo_operation();
		   total_dignity+=aReview.getDignity_and_respect();
		   total_involvement+=aReview.getInvolvement_in_decisions();
		   general_rating+=aReview.getGeneral_Rating();
	   }
	   
	   
	   
	   final String cleanliness = "Cleanliness";        
	   final String staff_cooperation = "Staff Cooperation";        
	   final String dignity = "Dignity & Respect";        
	   final String involvement_in_decisions = "Involvemen in Decisions";        
	   final String general_rating = "Overall";    
	   final String main = "Doctor"; 
	   DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  	

	   dataset.addValue( total_cleanliness/aDoctor.getReviewList().size(), main , cleanliness );                
	   dataset.addValue( total_staff_cooperation/aDoctor.getReviewList().size() , main , staff_cooperation ); 
	   dataset.addValue( total_dignity/aDoctor.getReviewList().size() , main , dignity );        
	   dataset.addValue( total_involvement/aDoctor.getReviewList().size() , main , involvement_in_decisions );       
	   dataset.addValue( StatisticsDoctorGUI.this.general_rating/aDoctor.getReviewList().size()  , main , general_rating );       	

	   return dataset; 
   }
   
		}	
}