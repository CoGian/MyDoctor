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
	
}
