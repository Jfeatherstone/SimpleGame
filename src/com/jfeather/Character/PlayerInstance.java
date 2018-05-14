package com.jfeather.Character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

import com.jfeather.Game.GameTerminal;
import com.jfeather.Game.Level.LevelInstance;

public class PlayerInstance {

	private boolean right, left, up, down;
	private Image sprite;
	private int direction;
	private int x, y, dx, dy;
	private Player player;
	private double angle;
	private int imageCount;
	
	public static int DIR_LEFT = 0;
	public static int DIR_RIGHT = 1;
	public static int DIR_UP = 2;
	public static int DIR_DOWN = 3;

	public PlayerInstance(Player newPlayer) {
		imageCount = 0;
		angle = 0;
		player = newPlayer;
		right = false;
		left = false;
		up = false;
		down = false;
		direction = DIR_UP;
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
	
	public int getdX() {
		return dx;
	}
	
	public void setdX(int newdX) {
		dx = newdX;
	}

	public int getdY() {
		return dy;
	}
	
	public void setdY(int newdY) {
		dy = newdY;
	}
	
	public void move(LevelInstance level) {
		if (x+dx > 0 && x+dx+sprite.getWidth(null) < GameTerminal.WIDTH && /*!isObstacleInX(level.getObstacles(), level.getObstacleLocations())*/ !obstaclePointInX(level.getObstaclePointsX(), level.getObstaclePointsY()))
			x += dx;
		if (y+dy > 0 && y+dy+sprite.getHeight(null) < GameTerminal.HEIGHT && /*!isObstacleInY(level.getObstacles(), level.getObstacleLocations())*/ !obstaclePointInY(level.getObstaclePointsX(), level.getObstaclePointsY()))
			y += dy;
	}
	
    public void updateSprite(Graphics g, JPanel dialog) {
    	imageCount++;
    	//System.out.println(imageCount);
    	if (imageCount > 16)
    		imageCount = 0;
    	player.setSprite(player.getSpriteSheet()[imageCount / 2]);
		sprite = player.getSprite();
		
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
    	AffineTransform og = g2d.getTransform();
    	AffineTransform tr = AffineTransform.getRotateInstance(angle, x + sprite.getWidth(null) / 2, y + sprite.getHeight(null) / 2);
    	g2d.setTransform(tr);
    	g2d.drawImage(sprite, x, y, null);
    	g2d.setTransform(og);
    }
    
    public boolean isObstacleInX(HashMap<Integer, Image> obstacleMap, HashMap<Integer, ArrayList<Integer>> obstacleLocationMap) {
    	Iterator it = obstacleMap.entrySet().iterator();
    	Iterator it2 = obstacleLocationMap.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry<Integer, Image> nextImage = (Map.Entry<Integer, Image>) it.next();
    		Map.Entry<Integer, ArrayList<Integer>> nextPoint = (Map.Entry<Integer, ArrayList<Integer>>) it2.next();
    		int obsX = nextPoint.getValue().get(0);
    		int obsY = nextPoint.getValue().get(1);
    		Image image = nextImage.getValue();
    		
    		if ((x + dx + sprite.getWidth(null)) > obsX && (x + dx) < obsX + image.getWidth(null) && y + sprite.getHeight(null) > obsY && y < obsY + image.getHeight(null))
    			return true;
    		//if ( )
    			//return true;
    	}
    	return false;
    }
    
    public boolean isObstacleInY(HashMap<Integer, Image> obstacleMap, HashMap<Integer, ArrayList<Integer>> obstacleLocationMap) {
    	Iterator it = obstacleMap.entrySet().iterator();
    	Iterator it2 = obstacleLocationMap.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry<Integer, Image> nextImage = (Map.Entry<Integer, Image>) it.next();
    		Map.Entry<Integer, ArrayList<Integer>> nextPoint = (Map.Entry<Integer, ArrayList<Integer>>) it2.next();
    		int obsX = nextPoint.getValue().get(0);
    		int obsY = nextPoint.getValue().get(1);
    		Image image = nextImage.getValue();
    		if (x + sprite.getWidth(null) > obsX && x < obsX + image.getWidth(null) && (y + dy + sprite.getHeight(null)) > obsY && (y + dy) < obsY + image.getHeight(null))
    			return true;
    	}
    	return false;
    }
    
    public boolean obstaclePointInX(ArrayList<Integer> pointsX, ArrayList<Integer> pointsY) {
    	int newX = x + dx;
    	int newY = y + sprite.getHeight(null) / 2;
    	if (dx > 0) {
    		newX += sprite.getWidth(null);
    	}
    	for (int i = 0; i < pointsY.size(); i++) {
    		if (newX == pointsX.get(i) && newY == pointsY.get(i))
    			return true;
    	}
    	return false;
    }
    
    public boolean obstaclePointInY(ArrayList<Integer> pointsX, ArrayList<Integer> pointsY) {
    	int newX = x + sprite.getWidth(null) / 2;
    	int newY = y + dy;
    	if (dy > 0)
    		newY += sprite.getHeight(null);
    	for (int i = 0; i < pointsY.size(); i++) {
    		if (newX == pointsX.get(i) && newY == pointsY.get(i))
    			return true;
    	}
    	return false;
    }

}
