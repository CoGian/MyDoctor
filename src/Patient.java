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
	private HashMap<Doctor,String> prescriptionList = new HashMap<>() ; 
	
	
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

	public HashMap<Doctor,String> getPrescriptionList() {
		return prescriptionList;
	}

	public void AddAppointment(Appointment App) {
		appointmentList.add(App);
	}
	
	public ArrayList<Appointment> getAppointments() {
		return this.appointmentList; 
	}
	
    public void cancelAppointment(Appointment selectedAppointment) {
		Doctor doctor = selectedAppointment.getDoctor();
		String id = selectedAppointment.getId();
		doctor.removeAppointment(id);
    	appointmentList.remove(selectedAppointment);
		
	}
    
    public void configureInfo(String newPassword,String newEmail,String newTelephone) {
    	
    }
	
    public String showPrescription(String selectedPrescription) {
		return selectedPrescription;
    	
    }
    
    //adds doctor and adds patients in doctor's patientmap
    public void addDoctor(Doctor aDoctor) {
    	if (!doctorsList.contains(aDoctor)) {
    		doctorsList.add(aDoctor); 
    		aDoctor.addPatient(this);
    	}
    }
    
    //delete doctor from all saved records in Patient 
    public void deleteDoctor(Doctor aDoctor){
    	doctorsList.remove(aDoctor);
    	
    	for(Appointment a : appointmentList)
    		if(a.getDoctor().equals(aDoctor))
    			appointmentList.remove(a) ; 
    	
    }
    
    //search doctor in list by name + surname 
    public Doctor searchDocInList(String FullName)
    {
    	for(Doctor doc : doctorsList )
    		if(FullName.contains(doc.getName())&&FullName.contains(doc.getSurname()))
    			return doc ; 
    	
		return null; 
			
    }

    public void editPrescriptionList(String prescription, Doctor aDoctor) {
    	this.prescriptionList.put(aDoctor, prescription);
    }
   
}
