package com.jfeather.Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {

	private int maxHealth, health, x, y;
	private Image sprite;
	
	public Enemy(int enemyHealth, String spritePath) {
		health = enemyHealth;
		maxHealth = enemyHealth;
		
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
	
}
