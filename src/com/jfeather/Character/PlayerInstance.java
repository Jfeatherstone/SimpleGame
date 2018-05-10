package com.jfeather.Character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import com.jfeather.Game.GameTerminal;

public class PlayerInstance {

	private boolean right, left, up, down;
	private Image sprite;
	private int direction;
	private int x, y;
	private Player player;
	private double angle;
	
	public static int DIR_LEFT = 0;
	public static int DIR_RIGHT = 1;
	public static int DIR_UP = 2;
	public static int DIR_DOWN = 3;

	public PlayerInstance(Player newPlayer) {
		angle = 0;
		player = newPlayer;
		right = false;
		left = false;
		up = false;
		down = false;
		direction = DIR_UP;
		player.setSprite("Sprites/Player/Player.png");
		sprite = player.getSprite();
		
		x = GameTerminal.WIDTH / 2 - sprite.getWidth(null) / 2;
		y = GameTerminal.HEIGHT / 2 - sprite.getHeight(null) / 2;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int newDirection) {
		direction = newDirection;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	
	public boolean getUp() {
		return up;
	}
	
	public boolean getDown() {
		return down;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public void setUp(boolean newUp) {
		up = newUp;
	}
	
	public void setDown(boolean newDown) {
		down = newDown;
	}
	
	public void setLeft(boolean newLeft) {
		left = newLeft;
	}
	
	public void setRight(boolean newRight) {
		right = newRight;
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public void setSprite(Image newSprite) {
		sprite = newSprite;
	}
	
    public void updateSprite(Graphics g, JPanel dialog) {
    	
    	Graphics2D g2d = (Graphics2D) g;
    	
    	if (left && !right && !down && !up) {
    		direction = DIR_LEFT;
    		angle = Math.toRadians(-90);
    	} else {
    		if (!left && right && !down && !up) {
    			direction = DIR_RIGHT;
        		angle = Math.toRadians(90);
    		} else {
    			if (!left && !right && down && !up) {
    				direction = DIR_DOWN;
    	    		angle = Math.toRadians(180);
    			} else {
    				if (!left && !right && !down && up) {
    					direction = DIR_UP;
    		    		angle = Math.toRadians(0);
    				} else {
    					if (left && !right && down && !up) {
    						// Down Left
    						angle = Math.toRadians(-135);
    					} else {
    						if (left && !right && !down && up) {
    							// Up Left
    							angle = Math.toRadians(-45);
    						} else {
    							if (!left && right && down && !up) {
    								// Down Left
    								angle = Math.toRadians(135);
    							} else {
    								if (!left && right && !down && up) {
    									// Up Right
    									angle = Math.toRadians(45);
    								} else {
    									// Do nothing here, because this runs whenever nothing else changes
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	AffineTransform tr = AffineTransform.getRotateInstance(angle, x + sprite.getWidth(null) / 2, y + sprite.getHeight(null) / 2);
    	g2d.setTransform(tr);
    	g2d.drawImage(sprite, x, y, null);
    }

}
