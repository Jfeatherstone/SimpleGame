package com.jfeather.Character;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {

	private int health, maxHealth, stamina, maxStamina;
	private int level;
	private String name;
	private Image sprite;
	
	// TODO find out what stats will be in the game
	
	public Player(String playerName) {
		name = playerName;
		level = 1;
		
		maxHealth = 100;
		health = maxHealth;
		maxStamina = 100;
		stamina = maxStamina;
		setSprite("Sprites/Player/Player.png");
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public void setSprite(Image newSprite) {
		sprite = newSprite;
	}
	
	public void setSprite(String path) {
		sprite = (new ImageIcon(path)).getImage();
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int newLevel) {
		if (level < newLevel) {
			for (int i = level; i < newLevel; i++) {
				levelUp();
			}
		} else {
			level = 0;
			for (int i = 0; i < newLevel; i++) {
				levelUp();
			}
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int newMaxHealth) {
		maxHealth = newMaxHealth;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int newStamina) {
		stamina = newStamina;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	} 
	
	public void setMaxStamina(int newMaxStamina) {
		maxStamina = newMaxStamina;
	}
	
	public void levelUp() {
		// TODO get the math for the level up stat increases
	}
	
}
