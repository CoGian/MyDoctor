import java.io.Serializable;
import java.util.Date;
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
	private String tag ; 
	private  HashMap<Integer, Integer[]> appointmentMap = new HashMap<Integer, Integer[]>();
	private HashMap<Patient, Integer> patientMap = new HashMap<>() ; 
	public Doctor(String amka, String mail, String name, String surname, int age, boolean gender, String telephone,
			String password, String cityName,String tag) {
	
		this.amka = amka;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.password = password;
		this.cityName = cityName;
		this.tag = tag ;
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


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public HashMap<Integer, Integer[]> getAppointmentMap() {
		return appointmentMap;
	}


	public void setAppointmentMap(HashMap<Integer, Integer[]> appointmentMap) {
		this.appointmentMap = appointmentMap;
	}
	
	
	public void makeAppointment(Patient aPatient , Date aDate) {
		
	}
	
   public void cancelAppointment(Date selectedDate) {
		
	}
   
   public void configureInfo(String newPassword,String newEmail,String newTelephone) {
   	
   }
   
   public void showHours() {
	   
   }
   
   public void addPatient(Patient aPatient) {
	   
   }
   
   
   public void writePrescription(Patient aPatient,String prescription) {
	   
   }

}
