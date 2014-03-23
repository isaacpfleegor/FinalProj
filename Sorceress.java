import java.util.*;

public class Sorceress extends Hero
{
	private static final int HP = 75; 
	private static final int ATTACK_SPEED = 5;
	private static final double CHANCE_HIT = 0.7;
	private static final int MIN_DAMAGE = 25;
	private static final int MAX_DAMAGE = 45;
	private static final double BLOCK_CHANCE = 0.3; //30 percent
	private static final double SPECIAL_CHANCE = 0.4;
	private static final int SPECIAL_DAMAGE_MAX = 175;
	private static final int SPECIAL_DAMAGE_MIN = 75;

	public Sorceress(Scanner user)
	{

		super(user);
		System.out.println("in Sorceress constructor");
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
	if(special_attempt()) //if returns true
	{
		int heal_val = Math.abs(rand.nextInt()) % (SPECIAL_DAMAGE_MAX - SPECIAL_DAMAGE_MIN) + SPECIAL_DAMAGE_MIN + 1;

		System.out.println(get_name() + " uses SPECIAL MOVE -- HEAL and HEAL's SELF for " + heal_val + "\n");
		set_hit_points(get_hit_points() + heal_val);
	}
	else

		System.out.println(get_name() + " healing spell FAILED! \n");
}




}//end class






