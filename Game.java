import java.util.*;

public class Game
{
Hero _warrior;
Monster _ogre;
	public Game(Scanner user)
	{
		//System.out.println("Enter the type of character you want to play as");
		//System.out.print("")
		_warrior = new Warrior(user);
		_ogre = new Ogre(user);
	}
	public void play_round()
	{
		int round = 1;
		//methods may need to be redefined in their subclasses
		while(_warrior.is_alive() && _ogre.is_alive())
		{
			System.out.println("Round " + round + "\n");
			
			_warrior.attack(_ogre);
			_ogre.attack(_warrior);
			// tells us the outcome of the round
			System.out.println(_warrior);
			System.out.println(_ogre);

			round++;

			System.out.println("");

		}
	}
}