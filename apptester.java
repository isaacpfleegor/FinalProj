import java.util.*;

public class apptester
{
	public static void main(String[] args)
	{
		Scanner user = new Scanner(System.in);
		Game game = new Game(user);
		game.play_round(user);

	
	}
}