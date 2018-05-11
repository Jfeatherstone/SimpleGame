package com.jfeather.Game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jfeather.Character.PlayerInstance;

public class LevelInstance {

	private HashMap<Integer, Image> sprites;
	private HashMap<Integer, ArrayList<Integer>> spriteLocations;
	private HashMap<Integer, Image> obstacles;
	private HashMap<Integer, ArrayList<Integer>> obstacleLocations;
	private int spriteCount, obstacleCount;
	private int x, y, dx, dy;
	private PlayerInstance player;
	
	public LevelInstance(PlayerInstance newPlayer) {
		player = newPlayer;
		
		sprites = new HashMap<>();
		spriteLocations = new HashMap<>();
		obstacles = new HashMap<>();
		obstacleLocations = new HashMap<>();
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
	public PlayerInstance getPlayer() {
		return player;
	}
	
	public ArrayList<Integer> getCoords() {
		return new ArrayList<Integer> (Arrays.asList(x, y));
	}
	
	public void addImage(Image newSprite, int xCoord, int yCoord) {
		sprites.put(spriteCount, newSprite);
		spriteLocations.put(spriteCount, new ArrayList<Integer> (Arrays.asList(xCoord, yCoord)));
		spriteCount++;
	}
	
	public void addImage(Image newSprite, ArrayList<Integer> list) {
		sprites.put(spriteCount, newSprite);
		spriteLocations.put(spriteCount, list);
		spriteCount++;
	}
	
	public void addImage(Image newSprite) {
		sprites.put(spriteCount, newSprite);
		spriteLocations.put(spriteCount, getCoords());
		spriteCount++;
	}
	
	public int getMapCount() {
		return spriteCount;
	}
	
	public HashMap<Integer, Image> getSpriteMap() {
		return sprites;
	}
	
	public void setSpriteMap(HashMap<Integer, Image> map) {
		sprites = map;
	}
	
	public HashMap<Integer, ArrayList<Integer>> getSpriteLocations() {
		return spriteLocations;
	}
	
	public void setSpriteLocationMap(HashMap<Integer, ArrayList<Integer>> map) {
		spriteLocations = map;
	}
	
	public void addIncrementsToMap(int dx, int dy) {
		Iterator it = spriteLocations.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, ArrayList<Integer>> next = (Map.Entry<Integer, ArrayList<Integer>>) it.next();
			next.setValue(new ArrayList<Integer> (Arrays.asList(next.getValue().get(0) + dx, next.getValue().get(1) + dy)));
		}
	}
	
    public void repaintLevel(Graphics2D g2d) {
    	Iterator it = obstacles.entrySet().iterator();
    	Iterator it2 = obstacleLocations.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry<Integer, Image> nextImage = (Map.Entry<Integer, Image>) it.next();
    		Map.Entry<Integer, ArrayList<Integer>> nextPoint = (Map.Entry<Integer, ArrayList<Integer>>) it2.next();
    		int x = nextPoint.getValue().get(0);
    		int y = nextPoint.getValue().get(1);
    		Image image = nextImage.getValue();
    		g2d.drawImage(image, x, y, null);
    	}
    }
    
    public void addNewObstacle(Image obstacleSprite, int xPos, int yPos) {
    	obstacles.put(obstacleCount, obstacleSprite);
    	obstacleLocations.put(obstacleCount, new ArrayList<Integer>(Arrays.asList(xPos, yPos)));
    }

    public HashMap<Integer, Image> getObstacles() {
    	return obstacles;
    }
    
    public HashMap<Integer, ArrayList<Integer>> getObstacleLocations() {
    	return obstacleLocations;
    }


}
