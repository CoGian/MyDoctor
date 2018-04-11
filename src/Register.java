import java.util.ArrayList;

public class Register {
	private ArrayList <Patient> Patients = new ArrayList<>();
	private ArrayList <Doctor> Doctors = new ArrayList<>();
	
	public void addPatient() {
		
	}
	public void addDoctor() {
		
	}
	
	public Object authentication(String username, String password) {
		return new Patient(username,"test@mydoctor.com","Example","User",25,false,"801-MY-DOCTOR" , password);
	}
}
