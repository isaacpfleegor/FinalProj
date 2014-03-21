import java.util.*;

public class Game
{
	Hero _hero;
	Monster _monster;

	public Game(Scanner user)
	{
		pick_character(user);
		_monster = new Ogre(user);
	}

	public void pick_character(Scanner user)
	{
		System.out.println("Enter the type of character you want to play as:  'Warror' |  'Thief'  |  'Sorceress' ");
		String resp = user.nextLine();

		if(resp.equalsIgnoreCase("warrior"))
			_hero = new Warrior(user);
		else if(resp.equalsIgnoreCase("thief"))
			_hero = new Thief(user);
		else if(resp.equalsIgnoreCase("Sorceress"))
		{
			//_hero = new Sorceress(user);
		}
		else
		{
			//Asks the user if they don't give the right response.
			System.out.println("Sorry, that is not a character type. Please try again. \n");
			pick_character(user);
		}

	}
//there was a problem calling a sub-class method from a parent pointer... Why is this ?

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