import java.util.*;

public class Skeleton extends Monster
{
	private static final int HP = 100; 
	private static final int ATTACK_SPEED = 3;
	private static final double CHANCE_HIT = 0.8;
	private static final int MIN_DAMAGE = 30;
	private static final int MAX_DAMAGE = 50;
	private static final int MAX_HEAL = 50;
	private static final int MIN_HEAL = 30;
	private static final double HEAL_CHANCE = 3.; //30 percent
	private static final double SPECIAL_CHANCE = 0.3;
	private static final int SPECIAL_ATTACK_MAX = 100;
	private static final int SPECIAL_ATTACK_MIN = 60;
	
	public Skeleton(Scanner user)
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
			int attack_val = Math.abs(rand.nextInt()) % (SPECIAL_ATTACK_MAX- SPECIAL_ATTACK_MIN) + SPECIAL_ATTACK_MIN + 1;

			System.out.println(get_name() + " SAYS 'THROW ME A BONE MAN' AND TOSSES A RIB AT YOU FOR " + attack_val + " DAMAGE\n");
			enemy.set_hit_points(get_hit_points() - attack_val);
		}
		else
		{
			System.out.println(get_name() + " special FAILED! \n");
			System.out.println(get_name() + "pulled his leg off by mistake.");
			System.out.println();
			System.out.println("But it was merely a flesh wound.");
		}

	}

}//end class