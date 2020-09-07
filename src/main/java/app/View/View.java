package view;

public class View
{
	private int	mode;

	public void set_mode(int mode) {
		this.mode = mode;
	}

	public void load_players() {
		System.out.println("LOAD PLAYERS");
	}

	public void display_all_players() {
		System.out.println("DISPLAY ALL PLAYERS");
	}
}