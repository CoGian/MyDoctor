
public class Review{
	
	private int id ; 
	private int Cleanliness ; 
	private int StaffCo_operation ; 
	private int Dignity_and_respect ; 
    private int Involvement_in_decisions ; 
    private double General_Rating ; 
    
  

	public Review(int id , int cleanliness, int staffCo_operation, int dignity_and_respect, int involvement_in_decisions) {
		
		Cleanliness = cleanliness;
		StaffCo_operation = staffCo_operation;
		Dignity_and_respect = dignity_and_respect;
		Involvement_in_decisions = involvement_in_decisions;
		General_Rating = (cleanliness +staffCo_operation +dignity_and_respect + involvement_in_decisions) / 4;
	}
    
	
}
