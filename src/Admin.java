
public class Admin{

	private String username;
	private String mail;
	private String name;
	private String surname;
	private int age;
	private boolean gender;    // 0 -> male , 1-> female
	private String telephone;
	private String password;
	public Admin(String username, String mail, String name, String surname, int age, boolean gender, String telephone,
			String password) {
		
		this.username = username;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.password = password;
	}
	public String getAmka() {
		return username;
	}
	public void setAmka(String amka) {
		this.username = amka;
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
	
	
	public void trasferDoctor(Doctor doc,Registry reg,String transfer_city) {
		
		doc.setCityName(transfer_city);
			
	}
	
	public Doctor searchDoctorByAMKA(String amka,Registry reg)
	{
		for(Doctor doc : reg.Doctors)
			if(doc.getAmka().equals(amka))
				return doc ; 
			
		
		return null;
		
	}
	
	public void deleteDoctor(Doctor doc,Registry reg)
	{
		for(Patient key: doc.getPatientMap().keySet())
			{
			   key.deleteDoctor(doc);
	
			}
		reg.Doctors.remove(doc) ; 
		
	}

   
}
