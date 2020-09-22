package controller;

import model.Model;
import view.View;

public class Controller
{
	protected static Model	model;
	private static View		view;

	private static int	mode;

	private static Menu	menu_load_or_new;
	private static Menu	menu_new;
	private static Menu	menu_list_of_players;
	private static Menu	menu_select_class;

	public Controller() {
		this.menu_load_or_new = new Menu(this, "load_or_new.mnu");
		//this.menu_new = new Menu(this, "new.mnu");
		//this.menu_list_of_players = new Menu(this, "players.mnu");
		//this.menu_select_class = new Menu(this, "", new String[]{"Light", "Medium", "Heavy"});
	}

	public void set_model(Model model) {
		this.model = model;
	}

	public void set_view(View view) {
		this.view = view;
	}

	public void set_mode(int mode) {
		this.mode = mode;
	}

	public void select_player() {
		String	response;
		boolean	valid_response;

		if (mode == 0) {
			valid_response = false;
			while (!valid_response) {
				view.display_message("L. Load Character\n" +
										"N. New Character");
				response = get_input();
				if (response.equals("L")) {
					load_player();
					valid_response = true;
				}
				else if (response.equals("N")) {
					new_player();
					valid_response = true;
				}
				else
					view.display_message("INVALID RESPONSE");
			}
		}
		else {
			menu_load_or_new.show();
		}
	}

	public void load_player() {
		boolean	valid_input;
		int		input;

		model.load_players();
		if (mode == 0) {
			valid_input = false;
			while (!valid_input) {
				view.display_all_players();
				try {
					input = Integer.parseInt(get_input()) - 1;
					
					if (0 <= input && input < model.number_of_players()) {
						model.set_player(input);
						valid_input = true;
					}
					else
						view.display_message("INVALID INPUT. Enter a number that corresponds to the desired character");
				} catch (NumberFormatException nfe) {
					view.display_message("INVALID INPUT. Enter a number that corresponds to the desired character");
				}
			}
		} else {
			menu_load_or_new.hide();
			//menu_list_of_players = new Menu(this, "", model.players_to_string());
			//smenu_list_of_players.show();
		}
	}

	public static void new_player() {
		if (mode == 1) {
			menu_load_or_new.hide();
			menu_new.show();
		}
		System.out.println("NEW PLAYER");
		//load_player();
	}

	public static String get_input() {
		return (System.console().readLine());
	}
}