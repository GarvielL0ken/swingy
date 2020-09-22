package model;

public class Player extends Agent
{
	private String	name;
	private String	class_name;

	public Player(boolean mode, String name) {
		super(mode, name);
		
		this.name = name;

		this.level = 0;
		this.experience = 0;
		this.attack = 1;
		this.defense = 1;
		this.hitPoints = 1;
		this.weapon = null;
		this.armor = null;
		this.helmet = null;
		this.position = new Position(0, 0);
	}

	public String toString() {
		return (this.id + ". " + this.name);
	}

	public String get_name() {
		return (this.name);
	}

	public void set_class(String class_name) {
		this.class_name = class_name;
	}
}