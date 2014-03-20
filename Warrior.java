import java.util.*;

public class Warrior extends Hero
{
	private static final int HP = 125; 
	private static final int ATTACK_SPEED = 4;
	private static final double CHANCE_HIT = 0.8;
	private static final int MIN_DAMAGE = 35;
	private static final int MAX_DAMAGE = 60;
	private static final double BLOCK_CHANCE = 0.2; //30 percent

	public Warrior(Scanner user)
	{
		super(user);
		super.set_hit_points(HP);
		super.set_attack_speed(ATTACK_SPEED);
		super.set_attack_chance(CHANCE_HIT);
		super.set_damage_range(MAX_DAMAGE, MIN_DAMAGE);
		super.set_block_chance(BLOCK_CHANCE);

	}

	//will want to override attack method for special attacks


	public String toString()
	{
		String display = "";
		display += "name : " + super.get_name() + "\n";
		display += "hp: " + super.get_hit_points() + "\n";
		display += "attack speed: " + super.get_attack_speed() + "\n";
		display+= "block chance: " + super.get_block_chance() + "\n";
		return display;
	}
}