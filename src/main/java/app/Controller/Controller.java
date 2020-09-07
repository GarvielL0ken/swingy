package controller;

import model.Model;
import view.View;

public class Controller
{
	private Model	model;
	private View	view;

	private int	mode;

	public void set_model(Model model) {
		this.model = model;
	}

	public void set_view(View view) {
		this.view = view;
	}

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