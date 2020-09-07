package model;

public class Agent
{
	protected boolean	mode;
	protected int		level;
	protected int		experience;
	protected int		attack;
	protected int		defense;
	protected int		hitPoints;
	protected Artifact	weapon;
	protected Artifact	armor;
	protected Artifact	helmet;
	protected Position	position;
	
	public Agent(boolean mode, String name) {
		this.mode = mode;
	}

	public void printMode() {
		System.out.println(this.mode);
	}
}