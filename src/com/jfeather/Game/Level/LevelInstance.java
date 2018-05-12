package com.jfeather.Game.Level;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

import com.jfeather.Character.PlayerInstance;
import com.jfeather.Game.GameTerminal;

public class LevelInstance {

	private HashMap<Integer, Image> sprites;
	private HashMap<Integer, ArrayList<Integer>> spriteLocations;
	private HashMap<Integer, Image> obstacles;
	private HashMap<Integer, ArrayList<Integer>> obstacleLocations;
	private ArrayList<Integer> obstaclePointsX;
	private ArrayList<Integer> obstaclePointsY;
	private int spriteCount, obstacleCount, pointCount;
	private int x, y, dx, dy;
	private PlayerInstance player;
	
	public LevelInstance(PlayerInstance newPlayer) {
		player = newPlayer;
		sprites = new HashMap<>();
		spriteLocations = new HashMap<>();
		obstacles = new HashMap<>();
		obstacleLocations = new HashMap<>();
		obstaclePointsX = new ArrayList<>();
		obstaclePointsY = new ArrayList<>();
		pointCount = 0;
		//setBackgroundTile(new ImageIcon("Sprites/Level/tile.png").getImage());
		setTerrain(new ImageIcon("Sprites/New Piskel.png").getImage());
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
    	Iterator it3 = sprites.entrySet().iterator();
    	Iterator it4 = spriteLocations.entrySet().iterator();
	    	while (it3.hasNext()) {
	    		Map.Entry<Integer, Image> nextImage = (Map.Entry<Integer, Image>) it3.next();
	    		Map.Entry<Integer, ArrayList<Integer>> nextPoint = (Map.Entry<Integer, ArrayList<Integer>>) it4.next();
	
	    		int x = nextPoint.getValue().get(0);
	    		int y = nextPoint.getValue().get(1);
	    		Image image = nextImage.getValue();
	    		g2d.drawImage(image, x,  y, null);
	    	}
    	
    	while (it.hasNext()) {
    		Map.Entry<Integer, Image> nextObstacle = (Map.Entry<Integer, Image>) it.next();
    		Map.Entry<Integer, ArrayList<Integer>> nextPoint = (Map.Entry<Integer, ArrayList<Integer>>) it2.next();
    		
    		int x = nextPoint.getValue().get(0);
    		int y = nextPoint.getValue().get(1);
    		Image image = nextObstacle.getValue();
    		g2d.drawImage(image, x, y, null);
    	}

    }
    
    public void addNewObstacle(Image obstacleSprite, int xPos, int yPos) {
    	obstacles.put(obstacleCount, obstacleSprite);
    	obstacleLocations.put(obstacleCount, new ArrayList<Integer>(Arrays.asList(xPos, yPos)));
    	obstacleCount++;
    }

    public HashMap<Integer, Image> getObstacles() {
    	return obstacles;
    }
    
    public HashMap<Integer, ArrayList<Integer>> getObstacleLocations() {
    	return obstacleLocations;
    }
    
    public void setBackgroundTile(Image tile) {
    	int tilesAcross = (int) Math.round((double) GameTerminal.WIDTH / (double) tile.getWidth(null) + 1);
    	int tilesDown = (int) Math.round((double) GameTerminal.HEIGHT / (double) tile.getHeight(null) + 1);
    	int currX = 0, currY = 0;
    	System.out.println(tile.getWidth(null));
    	for (int i = 0; i < tilesDown; i++) {
    		for (int j = 0; j < tilesAcross; j++) {
    			addImage(tile, currX, currY);
    			currX += tile.getWidth(null);
    		}
    		currX = 0;
    		currY += tile.getHeight(null);
    	}
    }
    
    public void setBackgroundTile(String path) {
    	Image tile = new ImageIcon(path).getImage();
    	int tilesAcross = (int) Math.round((double) GameTerminal.WIDTH / (double) tile.getWidth(null) + 1);
    	int tilesDown = (int) Math.round((double) GameTerminal.HEIGHT / (double) tile.getHeight(null) + 1);
    	int currX = 0, currY = 0;
    	for (int i = 0; i < tilesDown; i++) {
    		for (int j = 0; j < tilesAcross; j++) {
    			addImage(tile, currX, currY);
    			currX += tile.getWidth(null);
    		}
    		currX = 0;
    		currY += tile.getHeight(null);
    	}
    }
    
    public void genRandomBackgroundTile() {
    	 String folderPath = "Sprites/Level/BackgroundTiles/";
    	 Random rng = new Random();
    	 File folder = new File(folderPath);
    	 File[] arr = folder.listFiles();
    	 File tile = null;
    	 while (true) {
    		 tile = arr[rng.nextInt(arr.length)];
    		 if (!tile.getName().substring(0, 1).equals("."))
    			 break;
    	 }
    	 setBackgroundTile(tile.getAbsolutePath());
    }
    
    public void setTerrain(Image image) {
    	BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2d = (Graphics2D) bi.createGraphics();
    	g2d.drawImage(image, 0, 0, null);
    	addImage(image, 0, 0);
    	for (int i = 0; i < bi.getHeight(); i++) {
    		for (int j = 0; j < bi.getWidth(); j++) {
    	    	if (bi.getRGB(j, i) != 0) {
    	    		obstaclePointsX.add(j);
    	    		obstaclePointsY.add(i);
    	    		pointCount++;
    	    	}
    		}
    	}

    }
    
    public ArrayList<Integer> getObstaclePointsX() {
    	return obstaclePointsX;
    }
    
    public ArrayList<Integer> getObstaclePointsY() {
    	return obstaclePointsY;
    }

}
