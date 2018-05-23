import java.io.*;
import java.util.ArrayList;

public class Registry implements Serializable{
	
	
	public ArrayList <Patient> Patients;
	public  ArrayList <Doctor> Doctors;
	
	String[] cities = {"Athens" , "Thessaloniki" , "Patra" };
	
	String[] speciality = {"Cardiology" , "Surgery" , "Pathology" , "Orthopedic"} ; 
	
	
	public Registry() {
		 Patients= new ArrayList<>(); ; 
		 Doctors= new ArrayList<>(); 
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
		return null;
		
		
		
	}	
	
	
	public  ArrayList<Doctor> searchDoctor(String city, String speciality ,  String tag){
		return  Doctors ;
		
	}
	
	
}
