import java.util.*;

public abstract class DungeonCharacter
{
	//members:
	private String _name;
	private int _hit_points;
	private int _attack_speed;
	private int _damage_range_min;
	private int _damage_range_max;
	private double _attack_chance;

	public DungeonCharacter(Scanner user)
	{
		set_name(user);

	}
	//set the character's name  //should I pass in the Scanner user?
	public void set_name(Scanner user)
	{
		System.out.print("Enter character's name:  ");
		_name = user.nextLine();
	}
	public void set_hit_points(int hp){_hit_points = hp;}
	public void set_attack_speed(int aspeed){_attack_speed = aspeed;}
	public void set_attack_chance(double chance){_attack_chance = chance;}


	public String get_name(){return _name;}
	public double get_attack_chance(){return _attack_chance;}
	public int get_hit_points(){return _hit_points;}
	public int get_attack_speed(){return _attack_speed;}
	public int get_max_damage(){return _damage_range_max;}
	public int get_min_damage(){return _damage_range_min;}
	
	public void set_damage_range(int max, int min)
	{
		_damage_range_max = max;
		_damage_range_min = min;
	}

	public boolean is_alive()
	{
		if (_hit_points > 0)
		{
			return true;
		}

		System.out.println(_name + " is dead!!");
		return false;
	}
	//public abstract void attack(DungeonCharacter enemy); //must define this is subclass
	public String toString()
	{
		return _name + " has " + _hit_points + " hit points";

	}
}