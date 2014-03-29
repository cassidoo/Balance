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
		
		/* 9
		 * Semester : lowers cash by $500
		 * Week     : lowers cash by $100/week
		 */
		randQuestions.add("You have run out of meals on your meal plan.");
		String[] arr010 = {"Buy meals for the semester ($500)", "Buy meals by the week ($100/week)"};
		randAnswers.put(10, arr010);
		
		/* 10
		 * Ticket : lowers cash by $100
		 * Court  : lowers cash by $50, lowers grade by 5, lowers happiness by 5, lowers energy by 5
		 */
		randQuestions.add("You borrowed your friend's car for the weekend and got a speeding ticket");
		String[] arr011 = {"Pay the ticket ($100)", "Contest in court and miss class ($50)"};
		randAnswers.put(11, arr011);
		
		/* 11
		 * Party : lowers cash by $50, raises happiness by 10, lowers energy by 5
		 * Skip  : lowers happiness by 10
		 */
		randQuestions.add("Your friend got engaged, and they are having party!");
		String[] arr012 = {"Buy them a present ($50)", "Skip the party"};
		randAnswers.put(12, arr012);
		
		/* 12
		 * Party : lowers cash by $25, raises happiness by 10, lowers energy by 5
		 * Skip  : lowers happiness by 10
		 */
		randQuestions.add("Your friends birthday is tonight, and they are having party!");
		String[] arr013 = {"Buy them a present ($25)", "Skip the party"};
		randAnswers.put(13, arr013);
		
		/* 13
		 * Class : lowers energy by 15, raises grade by 5, lower happiness by 7
		 * Skip  : raises energy by 10, lowers grade by 10, raises happiness by 3
		 */
		randQuestions.add("After a late night hanging out with friends, you don't have enough time to sleep before class");
		String[] arr014 = {"Go to class", "Skip class"};
		randAnswers.put(14, arr014);
		
		/* 14
		 * Class : lowers energy by 15, raises grade by 5, lower happiness by 7
		 * Skip  : raises energy by 10, lowers grade by 10, raises happiness by 3
		 */
		randQuestions.add("You stayed up too late marathoning your favorite TV show, you don't have enough time to sleep before class");
		String[] arr015 = {"Go to class", "Skip class"};
		randAnswers.put(15, arr015);
		
		/* 15
		 * Class : lowers energy by 5, raises grade by 5, lower happiness by 10
		 * Skip  : lowers grade by 10, raises happiness by 10
		 */
		randQuestions.add("Your crush invites you to breakfast during your morning class!");
		String[] arr016 = {"Go to class", "Skip class"};
		randAnswers.put(16, arr016);
		
		/* 16
		 * Class : lowers energy by 5, raises grade by 5, lower happiness by 10
		 * Skip  : lowers energy by 5, lowers grade by 10, raises happiness by 10
		 */
		randQuestions.add("Your favorite band is playing at the local bar during your night class");
		String[] arr017 = {"Go to class", "Skip class"};
		randAnswers.put(17, arr017);
		
		
		//----------------------------------------------------------------------------------------------------------------------------- THESE QUESTIONS NEED A MESSAGE AFTER THE ANSWER
		/* 0
		 * Apply : if grade >= 90, get $500, raise happiness by 10; else lower happiness by 10
		 * Study : raise grade by 5, lower energy by 5
		 * Message: if true
		 * 		    You won the scholarship, congrats!
		 * 		    else
		 *          You didn't get the scholarship, you feel depressed from defeat.
		 */
		dependQuestions.add("Your guidance councelor emailed you a scholarship application");
		String[] arr10 = {"Apply", "Study"};
		dependAnswers.put(0, arr10);
		
		/* 1
		 * Apply : if grade >= 85, raise happiness by 10, raise grade by 5; else lower happiness by 10
		 * Study : raise grade by 5, lower energy by 5
		 * Message: if true
		 * 		    You got into the honors college, congrats!
		 * 		    else
		 *          You didn't get into the honors college, you feel depressed from defeat.
		 */
		dependQuestions.add("The honors college is looking for senior applicants.");
		String[] arr11 = {"Apply", "Study"};
		dependAnswers.put(1, arr11);
		
		/* 2
		 * Try Out : if energy >= 85 and happiness >= 85, raise happiness by 10; else lower happiness by 10
		 * Practice : lower energy by 10, raise happiness by 5
		 * Message: if true
		 * 		    You got the spot on the team, congrats!
		 * 		    else
		 *          You didn't get the spot on the team, you feel depressed from defeat.
		 */
		dependQuestions.add("The intramural sports team has one spot open!");
		String[] arr12 = {"Try out!", "Practice"};
		dependAnswers.put(2, arr12);
		
		/* 3
		 * Apply : if grade >= 75 and happiness >= 80, raise happiness by 10, raise grade by 10; else lower happiness by 10
		 * Study : raise grade by 5, lower energy by 5
		 * Message: if true
		 * 		    You got the position, congrats!
		 * 		    else
		 *          You didn't get the position, you feel depressed from defeat.
		 */
		dependQuestions.add("There is a leadership position open in your major.");
		String[] arr13 = {"Apply", "Study"};
		dependAnswers.put(3, arr13);
		
		/* 4
		 * Eat   : if happiness >= 70, raise happiness by 10, raise cash by $10; else lower happiness by 10
		 * Watch : raise happiness by 10
		 * 
		 * Message: if true
		 * 		    You won the contest, congrats!
		 * 		    else
		 *          You lost the contest, you feel depressed from defeat.
		 */
		dependQuestions.add("There is a pie-eating contest on central campus- winner gets $10!");
		String[] arr14 = {"Eat!", "Just watch"};
		dependAnswers.put(4, arr14);
		//-----------------------------------------------------------------------------------------------------------------------------
	}
	
	
}
