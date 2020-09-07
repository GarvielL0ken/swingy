package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import controller.Controller;
import view.View;

public class Model
{
	private List<Player> players = new LinkedList<Player>();
	private File	filePlayers;

	private Controller	controller;
	private View		view;

	private int	mode;

	public Model(Controller controller) {
		this.set_controller(controller);
		
		controller.set_model(this);
	}

	private void open_file(String str_file) {
		this.filePlayers = new File(str_file);
		
		if (!(this.filePlayers.exists())) {
			System.out.println("Error : File does not exist");
			System.exit(1);
		}
		if (!(this.filePlayers.isFile())) {
			System.out.println("Error : path does not conclude with a valid file");
			System.exit(1);
		}
	}

	private void read_file() {
		String	line;

		try {
			Scanner	inputScanner = new Scanner(this.filePlayers);
			Player	player;

			while (inputScanner.hasNextLine()) {
				line = inputScanner.nextLine();
				player = new Player(false, line);
				this.players.add(player);
			}
			inputScanner.close();
		} catch (IOException error) {
			System.out.println("Error : ");
			error.printStackTrace();
			System.exit(1);
		}
	}

	public void set_controller(Controller controller) {
		this.controller = controller;
	}

	public void set_view(View view) {
		this.view = view;
	}

	public void set_mode(int mode) {
		this.mode = mode;
	}

	public void load_players(String str_file) {
		this.open_file(str_file);
		this.read_file();
	}
}