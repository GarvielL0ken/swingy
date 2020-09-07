package model;

public class Agent
{
	private static int	idCounter = 0;

	protected boolean	mode;
	protected int		id;
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
		this.id = this.nextId();
	}

	public void printMode() {
		System.out.println(this.mode);
	}

	private int nextId() {
		Agent.idCounter++;
		return (Agent.idCounter);
	}
}