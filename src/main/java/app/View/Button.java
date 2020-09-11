package view;

import javax.swing.*;

public class Button {
	private JFrame	frame;
	private JButton	button;

	public Button() {
		frame = new JFrame();

		button = new JButton("click");
		button.setBounds(100, 100, 100, 40);

		frame.add(button);

		frame.setSize(300, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}