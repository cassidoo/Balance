
public class Player {

	public int cash;
	public int happy;
	public int grades;
	public int energy;
	public int week;
	public int loan;
	
	public Player(int money, int happiness, int grade, int ener, int time, int loan)
	{
		//week 1 money is $1000
		cash = money;
		happy = happiness;
		grades = grade;
		energy = ener;
		week = time;
		this.loan = loan;
	}
	
	public int getCash()
	{
		return cash;
	}
	
	public int getHappy()
	{
		return happy;
	}
	
	public int getGrades()
	{
		return grades;
	}
	
	public int getEnergy()
	{
		return energy;
	}
	
	public int getWeek()
	{
		return week;
	}
	
	public int getLoan()
	{
		return loan;
	}
	
	public void addCash(int x)
	{
		cash += x;
	}
	
	public void addHappy(int x)
	{
		happy += x;
	}
	
	public void addGrades(int x)
	{
		grades += x;
	}
	
	public void addEnergy(int x)
	{
		energy += x;
	}
	
	public void addWeek(int x)
	{
		week += x;
	}
	
	public void addLoan(int x)
	{
		loan += x;
	}
}
