package controller;

import java.awt.event.*;  
import javax.swing.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Menu {
	private Controller		controller;
	private	File			inputFile;
	private int				previousX;
	private int				previousY;
	private int				previousWidth;
	private int				previousHeight;
	private int				gap;
	private JFrame			frame;
	private JLabel			label;
	private List<JButton>	buttons = new LinkedList<JButton>();
	private String			file_name;

	public Menu(Controller controller, String file_name) {
		JButton	button;
		int	i;

		this.file_name = "resources/menus/" + file_name;
		this.controller = controller;
		
		this.open_input_file();
		this.read_file();

		//label = new JLabel(strLabel);
		//label.setBounds(50, 50, 100, 50);
		//frame.add(label);

		/*i = 1;
		for (String option:strOptions) {
			button = new JButton(option);
			button.setBounds(50, i * 100, 100, 50);
			setFunction(controller, button, option);
			frame.add(button);
			buttons.add(button);
			i++;
		}
		*/
		//this.frame.setSize(300, 600);
		this.frame.setLayout(null);
		this.frame.setVisible(false);
	}

	public void open_input_file() {
		this.inputFile = new File(this.file_name);
		if (!(this.inputFile.exists())) {
			System.out.println("Error : File does not exist");
			System.out.println(this.file_name);
			System.exit(1);
		}
		if (!(this.inputFile.isFile())) {
			System.out.println("Error : path does not conclude with a valid file");
			System.exit(1);
		}
	}

	public void read_file() {
		String	line;
		int		line_number;

		try {
			Scanner inputScanner = new Scanner(this.inputFile);

			this.validate_first_line(inputScanner.hasNextLine());
			this.parse_first_line(inputScanner.nextLine());

			line_number = 2;
			while (inputScanner.hasNextLine()) {
				line = inputScanner.nextLine();
				this.validate_line(line, line_number);
				this.parse_line(line);
				line_number++;
			}
			inputScanner.close();
		} catch (IOException error) {
			System.out.println("Error :");
			error.printStackTrace();
			System.exit(1);
		}
	}

	private void validate_first_line(boolean hasNextLine) {
		System.out.println("VALIDATE FIRST LINE");
	}

	private void parse_first_line(String line) {
		String[]	parameters;
		String[]	key_value;
		int			width;
		int			height;

		parameters = line.split(";");
		for (String parameter : parameters) {
			key_value = parameter.split(":");
			if (key_value[0].equals("NAME")) 
				this.frame = new JFrame(key_value[1]);
			else if (key_value[0].equals("SIZE")) 
			{
				width = Integer.parseInt(key_value[1]);
				height = Integer.parseInt(key_value[2]);
				this.frame.setSize(width, height);
			} 
			else if (key_value[0].equals("GAP"))
				this.gap = Integer.parseInt(key_value[1]);

			System.out.println(parameter);
		}
		System.out.println("PARSE FIRST LINE");
	}

	private void validate_line(String line, int line_number) {
		System.out.println("VALIDATE LINE");
	}

	private void parse_line(String line) {
		String[]	parameters;
		String[]	key_value;

		parameters = line.split(";");

		for (String parameter : parameters) {
			key_value = parameter.split(":");
			if (key_value[0].equals("TYPE")) {
				if (key_value[1].equals("Button"))
					this.addButton(parameters);
			}
			System.out.println(parameter);
		}
	}

	private void addButton(String[] parameters) {
		JButton	button;
		String[]	key_value;
		int			posX;
		int			posY;
		int			width;
		int			height;

		button = new JButton();
		for (String parameter : parameters) {
			key_value = parameter.split(":");
			if (key_value[0].equals("TEXT")) {
				button.setText(key_value[1]);
			}
			if (key_value[0].equals("BOUNDS")) {
				width = Integer.parseInt(key_value[3]);
				height = Integer.parseInt(key_value[4]);
				if (key_value[1].equals("AUTO"))
					posX = this.previousX;
				else {
					posX = Integer.parseInt(key_value[1]);
					this.previousX = posX;
				}
				if (key_value[2].equals("AUTO"))
					posY = this.previousY + this.previousHeight + this.gap;
				else {
					posY = Integer.parseInt(key_value[2]);
					this.previousY = posY;
				}
				button.setBounds(posX, posY, width, height);
				this.previousHeight = height;
			}
			if (key_value[0].equals("FUNCTION")) {
				setFunction(button, key_value[1], key_value);
			}
			System.out.println(parameter);
		}
		this.frame.add(button);
		System.out.println("ADDBUTTON");
	}

	private void setFunction(JButton button, String option, final String[] key_value) {
		if (option.equals("newPlayer")) {
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					controller.new_player();
				}
			});
		} else if (option.equals("loadPlayer")) {
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					controller.load_player();
				}
			});
		} else if (option.equals("setPlayerString")) {
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					controller.model.set_player_string(key_value[2]);
				}
			});
		}
	}

	public void show() {
		frame.setVisible(true);
	}

	public void hide() {
		frame.setVisible(false);
	}
}