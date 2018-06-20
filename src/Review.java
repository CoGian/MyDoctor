import java.io.Serializable;

public class Review implements Serializable{
	
	private String id ; 
	private int Cleanliness ; 
	private int StaffCo_operation ; 
	private int Dignity_and_respect ; 
    private int Involvement_in_decisions ; 
    private float General_Rating ; 
    
  

	public Review(String id , int cleanliness, int staffCo_operation, int dignity_and_respect, int involvement_in_decisions) {
		
		this.id = id ; 
		Cleanliness = cleanliness;
		StaffCo_operation = staffCo_operation;
		Dignity_and_respect = dignity_and_respect;
		Involvement_in_decisions = involvement_in_decisions;
		General_Rating = (cleanliness +staffCo_operation +dignity_and_respect + involvement_in_decisions) / 4;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void setCleanliness(int cleanliness) {
		Cleanliness = cleanliness;
	}



	public void setStaffCo_operation(int staffCo_operation) {
		StaffCo_operation = staffCo_operation;
	}



	public void setDignity_and_respect(int dignity_and_respect) {
		Dignity_and_respect = dignity_and_respect;
	}



	public void setInvolvement_in_decisions(int involvement_in_decisions) {
		Involvement_in_decisions = involvement_in_decisions;
	}



	public void setGeneral_Rating(float general_Rating) {
		General_Rating =  general_Rating;
	}



	public String getId() {
		return id;
	}



	public int getCleanliness() {
		return Cleanliness;
	}



	public int getStaffCo_operation() {
		return StaffCo_operation;
	}



	public int getDignity_and_respect() {
		return Dignity_and_respect;
	}



	public int getInvolvement_in_decisions() {
		return Involvement_in_decisions;
	}



	public double getGeneral_Rating() {
		return General_Rating;
	}
    
	
}
