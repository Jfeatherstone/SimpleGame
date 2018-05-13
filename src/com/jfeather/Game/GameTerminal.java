package com.jfeather.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import com.jfeather.Character.PlayerInstance;
import com.jfeather.Game.Level.LevelInstance;


public class GameTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 411;
	public static final int HEIGHT = 178;
	
	public static final int UPDATE_RATE = 50;
	
	public static final String MOVE_LEFT = "left";
	public static final String MOVE_RIGHT = "right";
	public static final String MOVE_UP = "up";
	public static final String MOVE_DOWN = "down";
	public static final String ROLL = "roll";
	
	public static final String RELEASE_UP = "r_up";
	public static final String RELEASE_DOWN = "r_down";
	public static final String RELEASE_LEFT = "r_left";
	public static final String RELEASE_RIGHT = "r_right";
	
	private LevelInstance level;
	private PlayerInstance player;
	
	public GameTerminal(LevelInstance newLevel) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.BLACK);
		level = newLevel;
		player = level.getPlayer();
		initializeKeys();
		
		Timer gameLoop = new Timer(UPDATE_RATE, new Listener());
		gameLoop.start();
	}
	
	public void initializeKeys() {
		getInputMap().put(KeyStroke.getKeyStroke("pressed W"), MOVE_UP);	
		getActionMap().put(MOVE_UP, new Movement(level, PlayerInstance.DIR_UP));
		
		getInputMap().put(KeyStroke.getKeyStroke("pressed S"), MOVE_DOWN);	
		getActionMap().put(MOVE_DOWN, new Movement(level, PlayerInstance.DIR_DOWN));

		getInputMap().put(KeyStroke.getKeyStroke("pressed A"), MOVE_LEFT);	
		getActionMap().put(MOVE_LEFT, new Movement(level, PlayerInstance.DIR_LEFT));

		getInputMap().put(KeyStroke.getKeyStroke("pressed D"), MOVE_RIGHT);	
		getActionMap().put(MOVE_RIGHT, new Movement(level, PlayerInstance.DIR_RIGHT));

		// The release actions
		getInputMap().put(KeyStroke.getKeyStroke("released W"), RELEASE_UP);	
		getActionMap().put(RELEASE_UP, new Movement(level, Movement.DIR_UP_RELEASE));
		
		getInputMap().put(KeyStroke.getKeyStroke("released S"), RELEASE_DOWN);	
		getActionMap().put(RELEASE_DOWN, new Movement(level, Movement.DIR_DOWN_RELEASE));

		getInputMap().put(KeyStroke.getKeyStroke("released A"), RELEASE_LEFT);	
		getActionMap().put(RELEASE_LEFT, new Movement(level, Movement.DIR_LEFT_RELEASE));

		getInputMap().put(KeyStroke.getKeyStroke("released D"), RELEASE_RIGHT);	
		getActionMap().put(RELEASE_RIGHT, new Movement(level, Movement.DIR_RIGHT_RELEASE));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		level.repaintLevel(g2d);
		//g2d.drawImage(player.getSprite(), player.getX(), player.getY(), null);
		player.move(level);
		player.updateSprite(g, this);
	}
	
	private class Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// This method is run continuously on the timer made above
			//level.move(getGraphics());
			repaint();
			//System.out.println(System.currentTimeMillis());
		}
		
	}	

}
