import java.util.*;
//class is abstract
public abstract class Hero extends DungeonCharacter
{
	private double _block_chance;
	private int _num_turns;
	//this should give access to this for every instance of hero, right?
	public static Random rand = new Random();//for block attempts

	public Hero(Scanner user)
	{
		super(user);
		_num_turns = 0; //setting inital val to 0, will be set based on opponent in attack method

	}
	public double get_block_chance(){return _block_chance;}
	public int get_num_turns(){return _num_turns;}
	public void set_block_chance(double chance){_block_chance = chance; }

	public void set_num_turns(DungeonCharacter enemy)
	{

		int turns = this.get_attack_speed() / enemy.get_attack_speed();

		if(turns < 1)
			_num_turns = 1;
		else
		{
			_num_turns = turns;
			System.out.println(get_name() + " gets " + (_num_turns - 1) + " extra turns this round");
		}
		
	}
	//should call this method in monster's attack method
	//should call on hero pointer?
	public boolean block_attempt()
	{
		//need to be able to check for all hero classes

		double chance = (_block_chance * 100);
		int val = (Math.abs(rand.nextInt())) % 100 + 1;

		System.out.println("hero block chance is " + chance + " and val is " + val + "\n");
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
		System.out.println("hero attack chance is " + chance + " and val is " + val + "\n");
		//if we get cal within chance to block range
		if( val <= chance) 
			return true;

		return false;
	}
	//do we want to make attack method abstract?
	//will want to override attack method for special attacks
	public void attack(Monster enemy)
	{
		set_num_turns(enemy);

		for(int i = 0; i < _num_turns; i++)
		{
			int attack_val = Math.abs(rand.nextInt()) % (get_max_damage() - get_min_damage()) + get_min_damage() + 1; //should be in range of attack values
			//System.out.println("hero attack val "+ attack_val);

			if(attack_attempt())//if returns true
			{
				//subtract attack from enemy hit points and apply
				System.out.println(get_name() + " ATTACKS for " + attack_val + "\n");
				enemy.set_hit_points(enemy.get_hit_points() - attack_val);
			}
			else
			{
				System.out.println(get_name() + " failed in attacking! \n");
			}

		}
	}




}//end class