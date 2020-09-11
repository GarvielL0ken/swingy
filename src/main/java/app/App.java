package swingy;

import controller.*;
import model.*;
import view.*;

public class App 
{
	private static Controller	controller = new Controller();
	private static Model		model = new Model(controller);
	private static View			view = new View(controller, model);

	private static String	players_file = "players.swi";

	private static int	mode = -1;

	public static void print_error_message(String msg)
	{
		System.out.println("ERROR: " + msg);
		System.exit(1);
	}

	public static void validate_arguments(String[] args)
	{
		if (args.length != 1)
			print_error_message("Must be run with exactly one argument");

		if (args[0].equals("console"))
			mode = 0;
		else if (args[0].equals("gui"))
			mode = 1;
		else
			print_error_message("Invalid argument\nValid arguments: console\n               : gui");
	}

	public static void set_modes()
	{
		controller.set_mode(mode);
		view.set_mode(mode);
	}

	public static void select_player()
	{
		String	response;
		boolean	valid_response;
		
		valid_response = false;
		while (!valid_response) {
			view.display_message("Would you like to load an existing character or make a new one?:\n" +
									"L. Load Character\n" +
									"N. New Character");
			response = controller.get_input();
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
		System.out.println(model.player.toString());
	}

	public static void load_player() {
		boolean	valid_input;
		int		input;

		model.load_players(players_file);

		valid_input = false;
		while (!valid_input) {
			view.display_all_players();
			try {
				input = Integer.parseInt(controller.get_input()) - 1;
				
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
	}

	public static void new_player() {
		System.out.println("NEW PLAYER");
	}

	public static void main( String[] args )
	{
		Button	button;

		button = new Button();
		System.setProperty("java.awt.headless", "true");
		//validate_arguments(args);
		//set_modes();
		//select_player();
	}
}
