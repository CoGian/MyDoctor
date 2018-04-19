import java.io.*;
import java.util.ArrayList;

public class Registry implements Serializable{
	private ArrayList <Patient> Patients = new ArrayList<>();
	private ArrayList <Doctor> Doctors = new ArrayList<>();
	
	String[] cities = {"Athens" , "Thessaloniki" , "Patra" };
	
	public void addPatient(Patient p) {
		this.Patients.add(p);
	}
	public void addDoctor(Doctor d) {
		this.Doctors.add(d);
	}
	
	public Object  authentication(String username, String password) {
		
		for(Patient patient : Patients)
		{
			if(patient.getAmka().equals(username))
				if(patient.getPassword().equals(password))
					return patient ; 	
		}
		
		

		for(Doctor doc : Doctors)
		{
			if(doc.getAmka().equals(username))
				if(doc.getPassword().equals(password))
					return doc ; 
		}
		
		return null ;
		
	}	
	
	
	
}
