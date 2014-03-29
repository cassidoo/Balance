import java.util.ArrayList;
import java.util.HashMap;


public class Questions {

	public HashMap<Integer, String[]> firstAnswers;
	public ArrayList<String> firstQuestions;
	public HashMap<Integer, String[]> randAnswers;
	public ArrayList<String> randQuestions;
	//dependent questions
	public HashMap<Integer, String[]> dependAnswers;
	public ArrayList<String> dependQuestions;
	
	//if questions
		//too tired, sleep through class
		//grade too low, get tutor ($100)
		//happiness too low, get meds ($100)
		//cash too low, get loan ($1000)
	
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
		 * Walk : Lowers energy by 10, lowers happiness by 5
		 */
		firstQuestions.add("Do you want a car, a bike, or to just walk campus?");
		String[] arr1 = {"Car", "Bike", "Walk"};
		firstAnswers.put(1, arr1);
		
		/* 2
		 * On-campus Tutor              : $7/hour, increases grade by 3
		 * Off-campus Restaurant Server : $8.50/hour, decreases grade by 10, decreases energy by 5
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
		
		/* 4
		 * Buy laptop       : $750, raises grade by 10 points, raises happiness by 10 
		 * Don't buy laptop : lowers grade by 5
		 */
		firstQuestions.add("Do you want a laptop for school?");
		String[] arr4 = {"Buy laptop ($750)", "Don't buy laptop"};
		firstAnswers.put(4, arr4);
		//-----------------------------------------------------------------------------------------------------------------------------
		/* 0
		 * Volunteer       : raises happiness by 15, lowers energy by 5
		 * Don't volunteer : lowers happiness by 3, raises energy by 1
		 */
		randQuestions.add("There is a volunteer opportunity on campus this week.");
		String[] arr00 = {"Volunteer", "Don't volunteer"};
		randAnswers.put(0, arr00);
		
		/* 1
		 * Don't do it                : lowers grade by 10, raises energy by 5, raises happiness by 5
		 * Study for 3 hours          : raises grade by 5, lowers energy by 5
		 * Stay up all night to study : raises grade by 10, lowers energy by 10, lowers happiness by 2
		 */
		randQuestions.add("You have an assignment due for your hardest class.");
		String[] arr01 = {"Don't do it", "Study for 3 hours", "Stay up all night to study"};
		randAnswers.put(1, arr01);
		
		/* 2
		 * Go to Doctor : $100, lowers grade by 5, raises energy by 5, raises happiness by 5
		 * Stay sick    : lowers grade by 5, lowers energy by 5, lowers happiness by 5
		 */
		randQuestions.add("You are very sick.");
		String[] arr02 = {"Go to Doctor ($100)", "Stay sick"};
		randAnswers.put(2, arr02);
		
		/* 3
		 * Go out            : $75, lowers grade by 2, lowers energy by 15, raises happiness by 15
		 * Stay in and study : raises grade by 10, raises energy by 10, lowers happiness by 5
		 */
		randQuestions.add("You have a free night tonight!");
		String[] arr03 = {"Go out and PARTY ($75)", "Stay in and study"};
		randAnswers.put(3, arr03);
		
		/* 4
		 * Go home to visit your parents : $35, raises energy by 15, raises happiness by 15
		 * Stay and study all weekend    : raises grade by 10, raises energy by 10, lowers happiness by 10
		 */
		randQuestions.add("You have a free weekend!");
		String[] arr04 = {"Go home to visit your parents ($35)", "Stay and study all weekend"};
		randAnswers.put(4, arr04);

		/* 5
		 * Join clubs!   : $25, raises happiness by 5
		 * Be antisocial : lowers happiness by 5
		 */
		randQuestions.add("Club Fest is on campus!");
		String[] arr05 = {"Join clubs! ($25)", "Be antisocial"};
		randAnswers.put(5, arr05);
		
		/* 6
		 * Give   : $10, raises happiness by 10
		 * Reject : lowers happiness by 5
		 */
		randQuestions.add("Your best friend asks you to borrow money for a book.");
		String[] arr06 = {"Give it up ($10)", "Reject them"};
		randAnswers.put(6, arr06);
	
		/* 7
		 * Love   : $500, raises happiness by 30
		 * Single : lowers happiness by 15
		 */
		randQuestions.add("Someone lovely asks you out on a date");
		String[] arr07 = {"Have a love life ($500)", "Be single"};
		randAnswers.put(7, arr07);
		
		/* 8
		 * Go   : $250, raises happiness by 5, raises grade by 15
		 * Skip : lowers grade by 5
		 */
		randQuestions.add("There is a conference in town that could benefit your career");
		String[] arr08 = {"Go to conference ($250)", "Skip the conference"};
		randAnswers.put(8, arr08);
		
		/* 9
		 * Research : raises grade by 10, raises happiness by 3
		 * Work     : raise by $50, lowers grade by 3, lowers energy by 5, lowers happiness by 3
		 */
		randQuestions.add("There is a research opportunity this weekend for students in your major");
		String[] arr09 = {"Research", "Work extra hours this weekend"};
		randAnswers.put(9, arr09);
		//-----------------------------------------------------------------------------------------------------------------------------
		/* 0
		 * Apply : if grade > 90, get $500, raise happiness by 10; else lower happiness by 10
		 * Study : raise grade by 5, lower energy by 5
		 */
		dependQuestions.add("Your guidance councelor emailed you a scholarship application");
		String[] arr10 = {"Apply", "Study"};
		dependAnswers.put(0, arr10);
		
		/* 1
		 * Apply : if grade > 85, raise happiness by 10, raise grade by 5; else lower happiness by 10
		 * Study : raise grade by 5, lower energy by 5
		 */
		dependQuestions.add("The honors college is looking for senior applicants.");
		String[] arr11 = {"Apply", "Study"};
		dependAnswers.put(1, arr11);
		
		
	}
	
	
}
