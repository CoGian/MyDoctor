import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Patient implements Serializable{
	private String amka;
	private String mail;
	private String name;
	private String surname;
	private int age;
	private boolean gender;    // 0 -> male , 1-> female
	private String telephone;
	private String password;
	private ArrayList<Appointment> appointmentList  = new ArrayList<>()  ; 
	private ArrayList<Doctor> doctorsList = new ArrayList<>() ; 
	private ArrayList<String> prescriptionList = new ArrayList<>() ; 
	
	
	public Patient(String amka, String mail, String name, String surname, int age, boolean gender, String telephone,
			String password) {
		this.amka = amka;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.password = password;
	}

	public String getAmka() {
		return amka;
	}

	public void setAmka(String amka) {
		this.amka = amka;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public ArrayList<Doctor> getDoctorsList() {
		return doctorsList;
	}

	public ArrayList<String> getPrescriptionList() {
		return prescriptionList;
	}

	public void makeAppointment(Doctor aDoctor,Date aDate) {
		
	}
	
    public void cancelAppointment(Date selectedDate) {
		
	}
    
    public void configureInfo(String newPassword,String newEmail,String newTelephone) {
    	
    }
	
    public String showPrescription(String selectedPrescription) {
		return selectedPrescription;
    	
    }
    
    public void addDoctor(Doctor aDoctor) {
    	doctorsList.add(aDoctor); 
    	aDoctor.addPatient(this);
    }
    
    public void deleteDoctor(Doctor aDoctor){
    	doctorsList.remove(aDoctor);
    	
    	for(Appointment a : appointmentList)
    		if(a.getDoctor().equals(aDoctor))
    			appointmentList.remove(a) ; 
    	
    }
    
    public Doctor searchDocInList(String FullName)
    {
    	for(Doctor doc : doctorsList )
    		if(FullName.contains(doc.getName())&&FullName.contains(doc.getSurname()))
    			return doc ; 
    	
		return null; 
			
    }
}
