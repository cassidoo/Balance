import java.util.HashMap;


public class Questions {

	public HashMap<String, String[]> questions;
	
	
	public Questions()
	{
		/* 1
		 * On  : $2500/semester, but increases social  
		 * Off : $1500/semester, but takes away energy
		 */
		String[] arr1 = {"On", "Off"};
		questions.put("Do you want live on or off campus?", arr1);
		
		/* 2
		 * Car  : 
		 * Bike : $150, lowers energy by 5
		 * Walk : Lowers energy by 10
		 */
		String[] arr2 = {"Car", "Bike", "Walk"};
		questions.put("Do you want a car, a bike, or to just walk campus?", arr2);
		
		
	}
	
	
}
