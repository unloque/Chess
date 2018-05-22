package lviv.chess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonFrame extends JFrame {
	JPanel buttonPanel;
	static final int DEFAULT_WIDTH = 300;
	static final int DEFAULT_HEIGHT = 200;

	public ButtonFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JButton yellowButton = new JButton("Yellow");
		JButton redButton = new JButton("Red");
		buttonPanel = new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
	}
}
