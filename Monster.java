import java.util.*;

public class Monster extends DungeonCharacter
{
	//members:
	
	private double _heal_chance;
	private int _num_turns;
	private int _heal_min;
	private int _heal_max;
	//does static mean it will only have one Scanner for all Monster instances?
	public static Random rand = new Random();//for block attempts
	//methods:
	public Monster(Scanner user)
	{
		super(user);
		_num_turns = 1; //setting inital val to 0, will be set based on opponent in attack method

		//we should be able to inherit all of the methods from the super class
		//for the derived classes
		//we have access to the private members through mutator methods.
		//the members are part of the derived class, but can only be set or accessed
		//through getters and setters
	}
	public void set_heal_min(int min){_heal_min = min;}

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
		//if we get cal within chance to block range
		if( val <= chance) 
			return true;

		return false;
	}
//we can pass in a Hero pointer because monsters only fight Heroes
	public void attack(DungeonCharacter enemy)
	{
		//will not perform attack if no hit points
		if(get_hit_points() < 1)
			return;
		//monster has chance to heal
		if(heal_attempt())
		{
			int heal_val = Math.abs(rand.nextInt()) % (_heal_max - _heal_min) + _heal_min + 1;
			System.out.println("heal val is " + heal_val);
			set_hit_points(get_hit_points() + heal_val);
		}


		int attack_val = Math.abs(rand.nextInt()) % (get_max_damage() - get_min_damage()) + get_min_damage() + 1; //should be in range of attack values

		System.out.println("attack value is " + attack_val);

		for(int i = 0; i < _num_turns; i++)
		{
			if(attack_attempt())//if returns true
			{ // polymorphism question: can i call this on a DungeonCharacter pointer?
				//or does this need to called on specific subclass		
				if(!enemy.block_attempt()) 
				{
					enemy.set_hit_points(enemy.get_hit_points() - attack_val);
				}
			}
		}

	}

}