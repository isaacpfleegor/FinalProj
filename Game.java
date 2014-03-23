import java.util.*;

public class Game
{
	Random rand = new Random();

	public static final int OGRE     = 1;
	public static final int GREMLIN  = 2;
	public static final int SKELETON = 3;

	Hero _hero;
	Monster _monster;

	public Game(Scanner user)
	{
		choose_hero(user);
		choose_enemy(user);
	}

	public void choose_hero(Scanner user)
	{
		System.out.println("Enter the type of character you want to play as");
		String resp = user.nextLine();

		if ( resp.equalsIgnoreCase("Warrior") )
		{
			_hero = new Warrior(user);
		}
		else if ( resp.equalsIgnoreCase("Thief") )
		{
			_hero = new Thief(user);
		}
		else if ( resp.equalsIgnoreCase("Sorceress") )
		{
			System.out.println("We are in else for Sorceress");
			_hero = new Sorceress(user);
		}
		else 
		{
			System.out.println("misspelled respacter.  Try again!");
			choose_hero(user);
		}
	}

	public void choose_enemy(Scanner user )
	{
		int rand_enemy = Math.abs(rand.nextInt() ) % 4;

			if ( rand_enemy == OGRE )
			{
				_monster = new Ogre(user);
			}
			else if ( rand_enemy == GREMLIN )
			{
				_monster = new Gremlin(user);
			}
			else
			{
				_monster = new Skeleton(user);
			}
		}

		public void play_round(Scanner user)
		{
			int round = 1;
			boolean done = false;
		//methods may need to be redefined in their subclasses
// && _hero.is_alive() && _monster.is_alive() 
			while( !done)
			{
				System.out.println("Round " + round + "\n");

				_hero.take_turn(_monster, user);
				_monster.take_turn(_hero, user);
			// tells us the outcome of the round
				System.out.println("\n");

				System.out.println(_hero);
				System.out.println(_monster);

				round++;

				System.out.println("\n");

//if characters are alive, ask the user if they would like to play another round
				if (_hero.is_alive() && _monster.is_alive())
					done = ask_again(user); 
				else
					done = true;


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