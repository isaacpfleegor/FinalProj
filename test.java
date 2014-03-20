import java.util.*;

public class test
{
	public static void main(String[] args)
	{
		
		Random rand = new Random();

		double chance = (.3 * 100);
		System.out.println("chance to block is " + chance);
		int val = (Math.abs(rand.nextInt())) % 100 + 1;
		System.out.println(val);
		if( val <= chance) 
			System.out.println("true");
		else
		System.out.println("false");
	}
}