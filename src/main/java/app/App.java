package swingy;

import controller.*;
import model.*;
import view.*;

public class App 
{
	private static Controller	controller = new Controller();
	private static Model		model = new Model(controller);
	private static View			view = new View(controller, model);

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
		controller.select_player();
		/*String	response;
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
		}*/
		//System.out.println(model.player.toString());
	}

	public static void main( String[] args )
	{
		validate_arguments(args);
		set_modes();
		select_player();
	}
}
