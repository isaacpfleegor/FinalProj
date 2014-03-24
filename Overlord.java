import java.util.*;

public class Overlord extends Hero
{
	private static final int HP = 1000; 
	private static final int ATTACK_SPEED = 8;
	private static final double CHANCE_HIT = .9;
	private static final int MIN_DAMAGE = 100;
	private static final int MAX_DAMAGE = 200;
	private static final double BLOCK_CHANCE = 0.8; //30 percent
	private static final double SPECIAL_CHANCE = 0.8;
	private static final int SPECIAL_DAMAGE_MAX = 1000000000;
	private static final int SPECIAL_DAMAGE_MIN = 5000;

	public Overlord(Scanner user)
	{


		super(user);
		set_hit_points(HP);
		set_attack_speed(ATTACK_SPEED);
		set_attack_chance(CHANCE_HIT);
		set_damage_range(MAX_DAMAGE, MIN_DAMAGE);
		set_block_chance(BLOCK_CHANCE);
		set_special_chance(SPECIAL_CHANCE);

		System.out.println("I AM OVERLORD! THE DUNGEONMASTER!");


	}

	public void take_turn(Monster enemy, Scanner user)
	{
		System.out.println("It is " + get_name() + "'s turn!\n");
		set_num_turns(enemy);
		for(int i = 0; i < get_num_turns(); i++)
		{
			String resp;
			System.out.println("Would you like to attempt your special ability this turn?");
			resp = user.nextLine();
			if(resp.equalsIgnoreCase("yes"))
		special(enemy); //we should call own method for this??
	else
		attack(enemy); //we can call parent method for attack
}
}



public String toString()
{
	return super.toString();
}

public void attack(Monster enemy)
{
	super.attack(enemy);

}

public void special(Monster enemy)
{

	int attack_val = Math.abs(rand.nextInt()) % (SPECIAL_DAMAGE_MAX - SPECIAL_DAMAGE_MIN) + SPECIAL_DAMAGE_MIN + 1;

			if(special_attempt())//if returns true
			{

				System.out.println(get_name() + " calls his mom to kick everyone out of his basement dealing " + attack_val + " damage and ending the game...forever.\n");
				enemy.set_hit_points(enemy.get_hit_points() - attack_val);
				System.exit(0);
			}
			else
			{
				System.out.println(get_name() + " special attack FAILED in attacking! \n");

				enemy.set_hit_points(enemy.get_hit_points() - attack_val);

				System.out.println(get_name() + " calls his mom to kick everyone out of his basement anyways; dealing " + attack_val + " damage and ending the game...forever.\n");
				System.exit(0);

			}

		}
}//end class






