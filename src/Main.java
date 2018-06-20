

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 
	    Registry reg = new Registry() ; 
	    reg = Serialization.ReadFromFile() ; 
	    
	    
	    Admin admin = new  Admin("admin","giatros@gmail.com","GIORGOS","PAPADOPOULOS",25,false,"6982222611" , "admin") ;
	   reg.setAdmin(admin);
	    
		Patient patient = new  Patient("231993221123","marinos@gmail.com","Marios","Marinos",23,false,"6989360354" , "paokmono") ;
		Patient patient1 = new  Patient("41220092311","dimitris12@hotmail.com","Dhmhtrhs","Papadopoulos",29,false,"6325114471" , "M2222366") ;
		Patient patient2 = new  Patient("221120001111","LOL@GMAIL","GIORGOS","PAPADOPOULOS",25,false,"6982222611" , "1423432") ;
		Doctor doctor = new Doctor ("45221145675","LOL@GMAIL.com","Marios","Panawgiwtidis",29,false,"6982223333" , "0","Thessaloniki","Heart","Cardiology");
		Doctor doctor1 = new Doctor ("44221142212","LOL@GMAIL.com","Giwrgos","Papadopoulous",41,false,"6982223333" , "0","Athens","","Pathology");
		Doctor doctor2 = new Doctor ("13224442855","LOL@GMAIL.com","Peris","Flekos",43,false,"6982223333" , "0","Patra","","Surgery");
		Doctor doctor3 = new Doctor ("45233345111","LOL@GMAIL.com","Xrhstos","adamou",43,false,"6982223333" , "0","Athens","Legs","Orthopedic");
		Doctor doctor4 = new Doctor ("7634522111","LOL@GMAIL.com","Apostolis","Gianakopoulos",43,false,"6982223333" , "0","Thessaloniki","HeartAttack","Cardiology");
	    
		
		//patient.addDoctor(doctor);
		//doctor.addReview(new Review("1",1,2,3,4),reg);
		
		//new Patient_GUI(patient,reg);
		/*
		reg.Patients.add(patient);
		reg.Patients.add(patient1);
		reg.Patients.add(patient2);
		reg.Doctors.add(doctor);
		reg.Doctors.add(doctor1);
		reg.Doctors.add(doctor2);
		reg.Doctors.add(doctor3);
		reg.Doctors.add(doctor4);
		*/
		//Serialization.SaveToFile(reg);
		//new MakeReview_GUI(patient, reg); 

		//new Auth_GUI(reg) ; 
        

 
		//new Doctor_GUI(doctor, reg);

		//new Admin_GUI(admin, reg) ; 



		//new Admin_GUI(admin, reg) ; 

		//new Auth_GUI(reg) ;		


		//new Doctor_GUI(doctor, reg);

		new Admin_GUI(admin, reg) ; 
		//new Doctor_GUI(doctor, reg);
		//new MakeAppointmentD_GUI(patient, doctor, reg);
	}

}
