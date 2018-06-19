import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Appointment implements Serializable{
	private Doctor doctor;
	private Patient patient;
	private Date date;
	private String id;
	public Appointment(Doctor doctor, Patient patient, Date date) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.date = date;
		this.id = UUID.randomUUID().toString();
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDate() {
		return date;
	}
	public String getId() {
		return id ;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String toString() {
		return date + " " + doctor.getName() + " " + doctor.getSurname();
	}
}
