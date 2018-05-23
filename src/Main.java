
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 
	    Registry reg = new Registry() ; 
	    reg = Serialization.ReadFromFile() ; 
		Patient patient = new  Patient("1313131","LOL@GMAIL","GIORGOS","PAPADOPOULOS",25,false,"6982222611" , "1423432") ;
<<<<<<< HEAD
		Doctor doctor = new Doctor ("13121312","LOL@GMAIL.com","MARIOS","PANAGIWTOPOULOS",43,false,"6982223333" , "0","Thessaloniki");


		
		
		Serialization.SaveToFile(reg);
=======
		//Doctor doctor = new Doctor ("13121312","LOL@GMAIL.com","MARIOS","PANAGIWTOPOULOS",43,false,"6982223333" , "0","Thessaloniki");
		//reg.Patients.add(patient);
		//Serialization.SaveToFile(reg);
		new MakeReview_GUI(patient, reg); 
>>>>>>> de89cc8bf2e7642e232722a5aa6ad559e3f91dfe
		new Auth_GUI(reg) ; 
		

	}

}
