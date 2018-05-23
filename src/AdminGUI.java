import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminGUI extends JFrame {
	
	private JPanel panel = new JPanel(); 
	private JPanel doctorMainPanel = new JPanel(); 
	private JPanel doctorAddPanel = new JPanel(); 
	private JPanel statisticsPanel = new JPanel(); 
	private JPanel doctorLeftPanel = new JPanel();
	
	private JButton transferDoctorButton = new JButton("Transfer");
	private JButton deleteDoctorButton = new JButton("Delete");
	private JButton informationDoctorButton = new JButton("Information") ;
	
	private JTextField doctorsNameTextField = new JTextField("Doctor's name");
	private JButton addDoctorButton= new JButton("Add Doctor") ;
	
	private JButton showStatistics = new JButton("Show Statistics") ;

	
	public AdminGUI(Admin anAdmin,Registry aRegistry) 
	{
		
	}
}
