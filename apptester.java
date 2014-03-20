import java.util.*;

public class apptester
{
	public static void main(String[] args)
	{
		Scanner user = new Scanner(System.in);
		DungeonCharacter me = new Warrior(user);
		System.out.println(me);	
	}
}