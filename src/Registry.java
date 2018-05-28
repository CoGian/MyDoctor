import java.io.*;
import java.util.ArrayList;

public class Registry implements Serializable{
	
	
	public static ArrayList <Patient> Patients;
	public static ArrayList <Doctor> Doctors;
	private Admin  admin ;  
	private static String[] cities = {"Athens" , "Thessaloniki" , "Patra" };
	
	private static String[] specialities = {"Cardiology" , "Surgery" , "Pathology" , "Orthopedic"} ; 
	private static String[] appointmenthours = {"10:00-10:30","10:30-11:00","11:00-11:30","11:30-12:00","12:00-12:30","12:30-13:00","13:00-13:30","13:30-14:00","14:00-14:30",
			"14:30-15:00","15:00-15:30","15:30-16:00","16:00-16:30","16:30-17:00","17:00-17:30","17:30-18:00","18:00-18:30","18:30-19:00","19:00-19:30","19:30-20:00"};
	
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
		
		if(admin.getAmka().equals(username)&&admin.getPassword().equals(password))
			return admin ;
		
		return null; 
			
		
		
	}	

	public static  String[] getCities() {
		return cities;
	}

	public static String[] getSpeciality() {
		return specialities;
	}
	public static String getAppointmenthours(int index){
		return appointmenthours[index];
	}
	public static String[] getHours() {
		return appointmenthours;
	}

	public static ArrayList<Doctor> searchDoctor(String city, String speciality ,  String tag){
		ArrayList<Doctor> AvailableDocs = new ArrayList<Doctor>();
		ArrayList<Doctor> TagDocs = new ArrayList<Doctor>();
		for (int i=0;i<Doctors.size();i++) {
			Doctor TempDoctor = null;
			TempDoctor = Doctors.get(i);
			tag = tag.toLowerCase();
			if ((TempDoctor.getCityName().equals(city) && TempDoctor.getSpeciality().equals(speciality)) &&TempDoctor.getTag().toLowerCase().contains(tag)) 
				TagDocs.add(TempDoctor);
			else if ((TempDoctor.getCityName().equals(city) && TempDoctor.getSpeciality().equals(speciality)) )
				AvailableDocs.add(TempDoctor);
		}
		for (Doctor doc : AvailableDocs) {
			TagDocs.add(doc);
		}
		return  TagDocs;
	}
	
	public static Patient searchPatient(String amka) {
		for(Patient p: Patients) {
			if (p.getAmka().equals(amka)) return p;
		}
		return null;
	}
	
}
	

