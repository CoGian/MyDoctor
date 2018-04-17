import java.util.ArrayList;

public class Registry {
	private ArrayList <Patient> Patients = new ArrayList<>();
	private ArrayList <Doctor> Doctors = new ArrayList<>();
	
	String[] cities = {"Athens" , "Thessaloniki" , "Patra" };
	
	public void addPatient(Patient p) {
		this.Patients.add(p);
	}
	public void addDoctor(Doctor d) {
		this.Doctors.add(d);
	}
	
	public Object authentication(String username, String password) {
		return new Patient(username,"test@mydoctor.com","Example","User",25,false,"801-MY-DOCTOR" , password);
	}
}
