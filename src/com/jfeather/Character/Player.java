package com.jfeather.Character;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player {

	private int health, maxHealth, stamina, maxStamina;
	private String name;
	private Image sprite;
	private Image[] spriteSheet;
	// TODO find out what stats will be in the game
	
	public Player(String playerName) {
		name = playerName;
		
		maxHealth = 100;
		health = maxHealth;
		maxStamina = 100;
		stamina = maxStamina;
		setSprite("Sprites/Player/Player.gif");
		setSpriteSheet();
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public void setSprite(Image newSprite) {
		sprite = newSprite;
	}
	
	public Image[] getSpriteSheet() {
		return spriteSheet;
	}
	
	public void setSpriteSheet() {
		try {
			BufferedImage bf = ImageIO.read(new File("Sprites/Player/PlayerSheet.png"));
			int width = bf.getWidth();
			int height  = 13;
			spriteSheet = new Image[9];
			for (int i = 0; i < 9; i++) {
				spriteSheet[i] = (Image) bf.getSubimage(0, height * i, width, height);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSprite(String path) {
		sprite = (new ImageIcon(path)).getImage();
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
	
}
