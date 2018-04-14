import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Register reg = new Register();
		
		Patient patient = new  Patient("1313131","LOL@GMAIL","GIORGOS","PAPADOPOULOS",25,false,"6982222611" , "1423432") ; 
		Doctor doctor = new Doctor ("13121312","LOL@GMAIL.com","MARIOS","PANAGIWTOPOULOS",43,false,"6982223333" , "0","Thessaloniki");
		new Auth_GUI(reg) ; 
		
	}

}
