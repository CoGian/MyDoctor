import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.nio.channels.NetworkChannel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.CenterArrangement;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class Statistics implements Serializable {
	
	private Registry reg;
	private Admin admin;
	private JButton backButton = new JButton("Back");

	
	
	public Statistics(Registry aRegistry,Admin admin, String use) {
		// TODO Auto-generated constructor stub
		this.reg=aRegistry;
		this.admin=admin;
		
		BarChart_AWT chart = new BarChart_AWT("Statistics", "Visits per City", use);
	
		chart.pack();      	
		chart.setVisible(true);
	}

	public class BarChart_AWT extends ApplicationFrame {
		   
		public BarChart_AWT( String applicationTitle , String chartTitle, String use) {
			super( applicationTitle );        
			JFreeChart barChart = ChartFactory.createBarChart(chartTitle,"Category","Visits",createDataset(use),
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

		
		
		private CategoryDataset createDataset(String use) {
			
			
			@SuppressWarnings("static-access")
			final String city1 = reg.getCities()[0];        
			final String city2 = reg.getCities()[1];       
			final String city3 = reg.getCities()[2];  
			
			final String speciality1 = reg.getSpeciality()[0];
			final String speciality2 = reg.getSpeciality()[1];
			final String speciality3 = reg.getSpeciality()[2];
			final String speciality4 = reg.getSpeciality()[3];
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  	
			if(use.equals("City")){
				
				final String main = "City"; 
			
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city1, speciality1) , main , city1 );                
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city1, speciality2) , main , city1 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city1, speciality3) , main , city1 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city1, speciality4) , main , city1 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city2, speciality1) , main , city2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city2, speciality2) , main , city2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city2, speciality3) , main , city2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city2, speciality4) , main , city2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city3, speciality1) , main , city3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city3, speciality2) , main , city3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city3, speciality3) , main , city3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(city3, speciality4) , main , city3 );      

			
			}
			else if(use.equals("Speciality")) {
				
				final String main = "Speciality"; 
				  
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality1, city1) , main , speciality1 );                
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality1, city2) , main , speciality1 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality1, city3) , main , speciality1 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality2, city1) , main , speciality2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality2, city2) , main , speciality2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality2, city3) , main , speciality2 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality3, city1) , main , speciality3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality3, city2) , main , speciality3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality3, city3) , main , speciality3 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality4, city1) , main , speciality4 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality4, city2) , main , speciality4 );      
				dataset.addValue(reg.getVisitPerCityPerSpeciality(speciality4, city3) , main , speciality4 );  
			
			}
			return dataset;
		}

	}	
	
}
