import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
 

public class Doctor implements Serializable{
	private String amka;
	private String mail;
	private String name;
	private String surname;
	private int age;
	private boolean gender;    // 0 -> male , 1-> female
	private String telephone;
	private String password;
	private String cityName;
	private String tag;
	private String speciality;
	private  HashMap<Integer, Appointment[]> appointmentMap = new HashMap< Integer,Appointment[]>();
	private HashMap<Patient, Integer> patientMap = new HashMap<>() ; 
	private ArrayList<Review> reviewList = new ArrayList<>() ; 
	

	public Doctor(String amka, String mail, String name, String surname, int age, boolean gender, String telephone,

			String password, String cityName,String tag,String speciality) {
	
		this.amka = amka;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.password = password;
		this.tag=tag;
		this.cityName = cityName;
		this.speciality = speciality;
		for (int i = 1 ;i<=30;i++) {
			Appointment[] tempAmp = new Appointment[20];
			appointmentMap.put(i, tempAmp );
		}
		Registry.Doctors.add(this);
	}


	public String getTag() {
		return tag;
	}


	public String getSpeciality() {
		return speciality;
	}


	public HashMap<Patient, Integer> getPatientMap() {
		return patientMap;
	}


	public ArrayList<Review> getReviewList() {
		return reviewList;
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


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void makeAppointment(Patient aPatient , Date aDate) {
		
	}
	
   public void cancelAppointment(Date selectedDate) {
		
	}
   
   public void configureInfo(String newPassword,String newEmail,String newTelephone) {
   	
   }
   
   public ArrayList<String> showHours(int SelectedDate) {
	   ArrayList<String> AvailableHours = new ArrayList<String>();
	   Appointment[] appoint = appointmentMap.get(SelectedDate);
	   for (int i = 0 ;i<20;i++) {
		   if (appoint[i]==null)
			   AvailableHours.add(Registry.getAppointmenthours(i));
	   }
	   
	   return AvailableHours;
   }
   
   public void addPatient(Patient aPatient) {
	   
   }
   
   
   public void writePrescription(Patient aPatient,String prescription) {
	   
   }
   //add appointment in appointmentmap 
   public void addAppointment(int day ,String SelectedHour,Appointment appointment) {
	   String[] hours = Registry.getHours();
	   Appointment[] dayAppointments = this.appointmentMap.get(day);
	   int index = 0;
	   for (int i=0; i<20;i++) {
		   if (hours[i]==SelectedHour)
			   index  = i ;
	   }
	   dayAppointments[index] = appointment;
	   this.appointmentMap.put(day, dayAppointments);
   
   }
   //add review in reviewlist if  a  patient has reviewed already it just replace the new review with the old
   public void addReview(Review rev)
   {
	   boolean found = false ; 
	   for(Review r : reviewList)
		   if(rev.getId().equals(r.getId())) {
			   r.setId(rev.getId());
			   found = true ; 
			   break; 
		   }
			  
	   if(!found) {
		   reviewList.add(rev) ; 
	   }
   }

   public String toString () {
	   return this.name + (" ") + this.surname;
   }
}
