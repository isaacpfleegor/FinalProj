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

}//end class