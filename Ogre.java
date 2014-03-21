import java.util.*;

public class Ogre extends Monster
{
	private static final int HP = 200; 
	private static final int ATTACK_SPEED = 2;
	private static final double CHANCE_HIT = 0.6;
	private static final int MIN_DAMAGE = 30;
	private static final int MAX_DAMAGE = 60;
	private static final int MAX_HEAL = 60;
	private static final int MIN_HEAL = 30;
	private static final double HEAL_CHANCE = 0.2; //30 percent
	private static final double SPECIAL_CHANCE = 0.2;
	private static final int SPECIAL_HEAL_MAX = 200;
	private static final int SPECIAL_HEAL_MIN = 150;
	public Ogre(Scanner user)
	{
		super(user);
		//because these are public methods of the super class, we dont have to use 
		//use the super 
		set_hit_points(HP);
		set_attack_speed(ATTACK_SPEED);
		set_attack_chance(CHANCE_HIT);
		set_damage_range(MAX_DAMAGE, MIN_DAMAGE);
		set_heal_range(MAX_HEAL, MIN_HEAL);
		set_heal_chance(HEAL_CHANCE);
		set_special_chance(SPECIAL_CHANCE);

	}

	//will want to override attack method for special attacks


	public String toString()
	{
		return super.toString();
		//display += "attack speed: " + get_attack_speed() + "\n";
	}
	public void attack(Hero enemy)
	{
		//if we don't use the super method here we are going to call same method
		//and we can't call the super method straight from the pointer
		super.attack(enemy);
	}

	public void take_turn(Hero enemy, Scanner user)
	{
		//will not perform attack if no hit points
		//i.e the character is dead
		if(get_hit_points() < 1)
			return;

		System.out.println("It is " + get_name() + "'s turn!\n");
		String resp;
		System.out.println("Would you like to attempt your special ability this turn?");
		resp = user.nextLine();

		if(resp.equalsIgnoreCase("yes"))
		{
				special(enemy); //we should call own method for this??
			}
			else
			{
				attack(enemy); //we can call parent method for attack
			}

		}
	//every character has their own special move, so we define here
		public void special(Hero enemy)
		{

		if(special_attempt())//if returns true
		{
				//special move goes in here
			int heal_val = Math.abs(rand.nextInt()) % (SPECIAL_HEAL_MAX - SPECIAL_HEAL_MIN) + SPECIAL_HEAL_MIN + 1;

			System.out.println(get_name() + " uses SPECIAL MOVE -- HOLISTIC MEDICINE and HEALS for " + heal_val + "\n");
			set_hit_points(get_hit_points() + heal_val);
		}
		else
		{
			System.out.println(get_name() + " special FAILED! \n");
		}

	}

}//end class