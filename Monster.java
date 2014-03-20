import java.util.*;

public abstract class Monster extends DungeonCharacter
{
	//members:
	
	private double _heal_chance;
	private int _num_turns;
	private int _heal_min;
	private int _heal_max;

	public static Random rand = new Random();//for block attempts
	//methods:
	public Monster(Scanner user)
	{
		super(user);
		_num_turns = 1; //setting inital val to 0, will be set based on opponent in attack method

	}
	public void set_heal_range(int max, int min)
	{
		_heal_max = max;
		_heal_min = min;
	}

	public void set_heal_max(int max){_heal_max = max;}

	public double get_heal_chance(){return _heal_chance;}

	public void set_heal_chance(double chance){_heal_chance = chance;}

	public boolean heal_attempt()
	{
		//need to be able to check for all hero classes

		double chance = (_heal_chance * 100);
		int val = (Math.abs(rand.nextInt())) % 100 + 1;
		//if we get cal within chance to block range
		if( val <= chance) 
			return true;

		return false;
	}

	public boolean attack_attempt()
	{
		//need to be able to check for all hero classes

		double chance = (get_attack_chance() * 100);

		int val = (Math.abs(rand.nextInt())) % 100 + 1;
		System.out.println("    monster attack chance: " +chance+ " val : "+ val + "\n");
		//if we get cal within chance to block range
		if( val <= chance) 
			return true;

		return false;
	}
//we can pass in a Hero pointer because monsters only fight Heroes
	public void attack(Hero enemy)
	{
		//will not perform attack if no hit points
		//i.e the character is dead
		if(get_hit_points() < 1)
			return;
		//monster has chance to hea
		
		if(heal_attempt())
		{
			int heal_val = Math.abs(rand.nextInt()) % (_heal_max - _heal_min) + _heal_min + 1;
			//System.out.println("heal val is " + heal_val);
			System.out.println(get_name() + " has HEALED by " + heal_val + "hp!\n" );
			set_hit_points(get_hit_points() + heal_val);
		}

	int attack_val = Math.abs(rand.nextInt()) % (get_max_damage() - get_min_damage()) + get_min_damage() + 1; //should be in range of attack values

		if(attack_attempt())//if returns true
		{ // polymorphism question: can i call this on a DungeonCharacter pointer?
			//or does this need to called on specific subclass		

			if(!enemy.block_attempt()) 
			{
				System.out.println(get_name() + " ATTACKS for " + attack_val + "\n");
				enemy.set_hit_points(enemy.get_hit_points() - attack_val);
			}
			else
			{
				System.out.println(get_name() + " attacked, but was BLOCKED!! \n");
			}

		}
		else
		{
			System.out.println(get_name() + " failed in attack! \n");
		}
	}//end attack method

}//end class













