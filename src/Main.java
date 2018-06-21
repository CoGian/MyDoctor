

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 
	    Registry reg = new Registry() ; 
	    reg = Serialization.ReadFromFile() ; 
	    
		new Auth_GUI(reg) ; 
        
	}

}
