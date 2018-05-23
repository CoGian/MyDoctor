import java.util.Date;

public class Appointment {
	private Doctor doctor;
	private Patient patient;
	private Date date;
	public Appointment(Doctor doctor, Patient patient, Date date) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.date = date;
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
	public void setDate(Date date) {
		this.date = date;
	}
	
}
