package com.jfeather.Game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.jfeather.Character.PlayerInstance;

public class Movement extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int DIR_UP_RELEASE = 6;
	public static final int DIR_DOWN_RELEASE = 7;
	public static final int DIR_LEFT_RELEASE = 4;
	public static final int DIR_RIGHT_RELEASE = 5;
	
	private int direction;
	private int d;
	private PlayerInstance player;
	private LevelInstance level;
	
	public Movement(LevelInstance newLevel, int moveDirection) {
		direction = moveDirection;
		level = newLevel;
		player = level.getPlayer();
		d = 5;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Direction variables are found in PlayerInstance
		switch (direction) {
		case 0:
			// Pressed Left
			//System.out.println("Pressed Left");
			player.setdX(-d);
			player.setLeft(true);
			player.setDirection(PlayerInstance.DIR_LEFT);
			break;
		case 1:
			// Pressed Right
			//System.out.println("Pressed Right");
			player.setdX(d);
			player.setRight(true);
			player.setDirection(PlayerInstance.DIR_RIGHT);
			break;
		case 2:
			// Pressed Up
			//System.out.println("Pressed Up");
			player.setdY(-d);
			player.setUp(true);
			player.setDirection(PlayerInstance.DIR_UP);
			break;
		case 3:
			// Pressed Down
			//System.out.println("Pressed Down");
			player.setdY(d);
			player.setDown(true);
			player.setDirection(PlayerInstance.DIR_DOWN);
			break;
		case 4:
			// Released Left
			//System.out.println("Released Left");
			if (!player.getRight())
				player.setdX(0);
			player.setLeft(false);
			break;
		case 5:
			// Released Right
			//System.out.println("Released Right");
			if (!player.getLeft())
				player.setdX(0);
			player.setRight(false);
			break;
		case 6:
			// Released Up
			//System.out.println("Released Up");
			if (!player.getDown())
				player.setdY(0);
			player.setUp(false);
			break;
		case 7:
			// Released Down
			//System.out.println("Released Down");
			//System.out.println(level.getDown());
			if (!player.getUp())
				player.setdY(0);
			player.setDown(false);
			break;
		}
	
	}
}
