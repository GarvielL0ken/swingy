package model;

public class Player extends Agent
{
	private String	name;

	public Player(boolean mode, String name) {
		super(mode, name);
		this.name = name;

		if (mode)
			this.loadPlayer(name);
		else
		{
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
	}

	private void loadPlayer(String name)
	{
		System.out.println("loadPlayer(" + name + ")");
	}
}