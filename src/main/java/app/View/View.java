package view;

import controller.Controller;
import model.Model;

public class View
{
	private Controller	controller;
	private Model		model;

	private int	mode;

	public View(Controller controller, Model model) {
		this.set_controller(controller);
		this.set_model(model);

		controller.set_view(this);
		model.set_view(this);
	}

	public void set_controller(Controller controller) {
		this.controller = controller;
	}

	public void set_model(Model model) {
		this.model = model;
	}

	public void set_mode(int mode) {
		this.mode = mode;
	}

	public void display_all_players() {
		Player	player;

		int	size;
		int	i;

		size = this.model.number_of_players();
		i = 0;
		while (i < size) {
			player = this.model.get_player(i);
			player.loadPlayer();
			i++;
		}
		System.out.println("DISPLAY ALL PLAYERS");
	}
}