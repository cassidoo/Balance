
public class Expenses {
	public static int i = 0;
	public static void main(String[] args)
	{
		String s = "hello";
		s = "world";
		trial(5);
	}
	
	public static void trial(int type)
	{
		switch (type)
		{
		case 1:
			i ++;
			break;
		case 2:
			i+=2;
			break;
		default:
			System.out.println("I" + '\n' + "am" + '\n' + "a" + '\n' + "boy");
		}
	}
}
