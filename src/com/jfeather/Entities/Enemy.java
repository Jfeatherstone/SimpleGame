package com.jfeather.Entities;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {

	private int maxHealth, health, x, y;
	private Image sprite;
	private Contour path;
	private int facing;
	private int speed;
	
	public Enemy(int enemySpeed, String spritePath, Contour movementPath) {
		//health = enemyHealth;
		//maxHealth = enemyHealth;
		path = movementPath;
		facing = 1;
		speed = enemySpeed;
		
		sprite = new ImageIcon(spritePath).getImage();
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int newHealth) {
		maxHealth = newHealth;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public void incrementHealth(int increment) {
		health = health + increment;
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public void setSprite(String newPath) {
		sprite = new ImageIcon(newPath).getImage();
	}
	
	public Contour getPath() {
		return path;
	}
	
	public void moveEnemy(Graphics g) {
		path.updateSprite(sprite, g, speed);
		facing = path.getDirection();
		x = (int) path.getCoords().get(path.getImageCount()).getX();
		y = (int) path.getCoords().get(path.getImageCount()).getY();
	}
	
	public int getDirection() {
		return facing;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
}
