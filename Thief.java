import java.util.*;

public class Thief extends Hero
{
	private static final int HP = 75; 
	private static final int ATTACK_SPEED = 6;
	private static final double CHANCE_HIT = 0.8;
	private static final int MIN_DAMAGE = 20;
	private static final int MAX_DAMAGE = 40;
	private static final double BLOCK_CHANCE = 0.4; //30 percent
	private static final double SPECIAL_CHANCE = 0.4;
	private int _count;

	public Thief(Scanner user)
	{


		super(user);
		set_hit_points(HP);
		set_attack_speed(ATTACK_SPEED);
		set_attack_chance(CHANCE_HIT);
		set_damage_range(MAX_DAMAGE, MIN_DAMAGE);
		set_block_chance(BLOCK_CHANCE);
		set_special_chance(SPECIAL_CHANCE);


	}

	public void take_turn(Monster enemy, Scanner user)
	{
		System.out.println("It is " + get_name() + "'s turn!\n");
		set_num_turns(enemy);
		for(_count = 0; _count < get_num_turns(); _count++)
		{
			String resp;
			System.out.println("Would you like to attempt your special ability this turn?");
			resp = user.nextLine();
			if(resp.equalsIgnoreCase("yes"))
		special(enemy); //we should call own method for this??
	else
		attack(enemy); //we can call parent method for attack
	System.out.println("Turn number is " + _count);
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

		if(special_attempt())//if returns true
			{
				System.out.println(get_name() + " performs SURPRISE ATTACK! ");
				attack(enemy);
				System.out.println(get_name() + " gets an extra turn with special");
				_count--;
			}
			else
			{
				System.out.println(get_name() + " special attack FAILED in attacking! \n");
			}

		}
}//end class






