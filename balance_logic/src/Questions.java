import java.util.ArrayList;
import java.util.HashMap;


public class Questions {

	public HashMap<Integer, String[]> firstAnswers;
	public ArrayList<String> firstQuestions;
	public ArrayList<String> randQuestions;
	
	public Questions()
	{
		//-----------------------------------------------------------------------------------------------------------------------------
		/* 0
		 * On  : $2500, raises happiness by 10
		 * Off : $1500, lowers energy by 10
		 */
		firstQuestions.add("Do you want live on or off campus?");
		String[] arr0 = {"On", "Off"};
		firstAnswers.put(0, arr0);
		
		/* 1
		 * Car  : $1000, raises happiness by 10, increases energy by 5, lowers money by $10/week
		 * Bike : $150, lowers energy by 5
		 * Walk : Lowers energy by 10
		 */
		firstQuestions.add("Do you want a car, a bike, or to just walk campus?");
		String[] arr1 = {"Car", "Bike", "Walk"};
		firstAnswers.put(1, arr1);
		
		/* 2
		 * On-campus Tutor              : $7/hour, increases grade by 3
		 * Off-campus Restaurant Server : $8.50/hour, decreases grade by 3, decreases energy by 5
		 */
		firstQuestions.add("Time to pick a job");
		String[] arr2 = {"On-campus: Tutor ($7/hour, 3 hours/day)", "Off-campus: Restaurant Server ($8.50/hour 5 hours/day)"};
		firstAnswers.put(2, arr2);
		
		/* 3
		 * Buy books       : $250, raises grade by 20 points 
		 * Don't buy books : lowers grade by 20 points
		 */
		firstQuestions.add("Classes start soon, you need books for class");
		String[] arr3 = {"Buy books ($350)", "Don't buy books"};
		firstAnswers.put(3, arr3);
		//-----------------------------------------------------------------------------------------------------------------------------
		
		
	}
	
	
}
