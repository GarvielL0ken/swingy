package controller;

public class Controller
{
	private int	mode;

	public void set_mode(int mode) {
		this.mode = mode;
	}

	public void print_mode() {
		System.out.println(this.mode);
	}

	public void select_player() {
		System.out.println("SELECT PLAYER");
	}
}