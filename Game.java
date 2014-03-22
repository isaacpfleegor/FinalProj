import java.util.*;

public class Game
{
	Random rand = new Random();

	public static final int OGRE     = 1;
    public static final int GREMLIN  = 2;
    public static final int SKELETON = 3;

	Sorceress _sorceress;
	Thief _thief;
	Warrior _warrior;
	Ogre _ogre;
	Gremlin _gremlin;
	Skeleton _skeleton;

	public Game(Scanner user)
	{
		choose_hero();
		choose_enemy(rand);
	}

	public void choose_hero()
	{
		System.out.println("Enter the type of character you want to play as");
		String char = user.nextLine();

		if ( char == equalsIgnoreCase(Warrior) )
			{
				Warrior _warrior = new Warrior(user);
			}
		else if ( char == equalsIgnoreCase(Thief) )
			{
				Thief _thief = new Thief(user);
			}
		else if ( char == equalsIgnoreCase(Sorceress) )
			{
				Sorceress _sorceress = new Sorceress(user);
			}
		else choose_hero();
	}

	public void choose_enemy()
	{
	int rand_enemy = (Math.abs(rand.nextInt() ) % 4;

		if ( rand_enemy == OGRE )
			{
			Ogre _ogre = new _ogre(user);
			}
		else if ( rand_enemy == GREMLIN )
			{
			Gremlin	_gremlin = new Gremlin(user);
			}
		else ( enemy == SKELETON )
			{
			Skeleton _skeleton = new Skeleton(user);
			}
	}
	
	public void play_round(Scanner user)
	{
		int round = 1;
		boolean done = false;
		//methods may need to be redefined in their subclasses

		// hero/ogre here needs to be (hero) (monster)

		while( !done && _warrior.is_alive() && _ogre.is_alive() )
		{
			System.out.println("Round " + round + "\n");

			_warrior.take_turn(_ogre, user);
			_ogre.take_turn(_warrior, user);
			// tells us the outcome of the round
			System.out.println("\n");

			System.out.println(_warrior);
			System.out.println(_ogre);

			round++;

			System.out.println("\n");

			done = ask_again(user);

		}
	}

	public boolean ask_again(Scanner user)
	{

		System.out.print("Would you like to play another round?  Yes or No :");
		String resp = user.nextLine();

		if (resp.equalsIgnoreCase("yes"))
			return false;
		else
			return true;

	}

}