package com.jfeather.Inventory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InventoryTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 426;
	public static final int HEIGHT = 56;
	public static final int SLOTS = 8;
	private JButton[] buttons;
	
	public InventoryTerminal() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.BLUE);
		
		// Initialize the buttons as slots
		int currX = 10;
		
		buttons = new JButton[SLOTS];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			add(buttons[i]);
			buttons[i].setBounds(currX, 7, 42, 42);
			buttons[i].setEnabled(false);
			buttons[i].setText("" + (i + 1));
			currX += 46;
		}
		
	}
	
	public void fadeButtonsUp() {
		new Thread() {
			public void run() {
				int currY = buttons[SLOTS - 1].getY();
				while (buttons[SLOTS - 1].getY() + buttons[SLOTS - 1].getHeight() > 0) {
					for (int i = 0; i < SLOTS; i++) {
						buttons[i].setBounds(buttons[i].getX(), currY, 42, 42);
					}
					currY -= 2;
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void fadeButtonsDown() {
		new Thread() {
			public void run() {
				int currY = buttons[SLOTS - 1].getY();
				while (buttons[SLOTS - 1].getY() < HEIGHT) {
					for (int i = 0; i < SLOTS; i++) {
						buttons[i].setBounds(buttons[i].getX(), currY, 42, 42);
					}
					currY += 2;
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public void restoreButtons() {
		new Thread() {
			public void run() {
				int currY = buttons[SLOTS - 1].getY();
				int finalY = 7;
				if (currY > finalY) {
					while (buttons[SLOTS - 1].getY() > finalY) {
						for (int i = 0; i < SLOTS; i++) {
							buttons[i].setBounds(buttons[i].getX(), currY, 42, 42);
						}
						currY -= 2;
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} else {
					while (buttons[SLOTS - 1].getY() < finalY) {
						for (int i = 0; i < SLOTS; i++) {
							buttons[i].setBounds(buttons[i].getX(), currY, 42, 42);
						}
						currY += 2;
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}.start();

	}

}
