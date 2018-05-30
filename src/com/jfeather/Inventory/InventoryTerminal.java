package com.jfeather.Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InventoryTerminal extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 426;
	public static final int HEIGHT = 56;
	public static final int SLOTS = 8;
	private JButton[] buttons;
	private int slotPress, slotRelease;
	
	public InventoryTerminal() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.GRAY);
		
		// Initialize the buttons as slots
		int currX = 10;
		
		buttons = new JButton[SLOTS];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			add(buttons[i]);
			buttons[i].setBounds(currX, 7, 42, 42);
			buttons[i].setEnabled(false);
			buttons[i].setText("" + (i + 1));
			buttons[i].addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// Detect which inventory slot is being clicked
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == e.getComponent())
				System.out.println("Clicked " + (i + 1));
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		slotPress = -1;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == e.getComponent()) {
				System.out.println(i + 1);
				slotPress = i;
			}
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO This detection method doesn't quite work
		slotRelease = -1;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == e.getComponent()) {
				System.out.println(i + 1);
				slotRelease = i;
			}
		}

	}
	
	public void switchButtons(JButton btn1, JButton btn2) {
		// Flip the icons
		ImageIcon temp = (ImageIcon) btn1.getIcon();
		btn1.setIcon(btn2.getIcon());
		btn2.setIcon(temp);
		
		// TODO: Find out a good way to store items, maybe as a generic item class, like in Dungeon-Crawler
	}

}
