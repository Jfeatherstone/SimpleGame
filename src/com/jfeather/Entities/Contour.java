package com.jfeather.Entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Contour {

	public static final int DOWN = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;
	public static final int DOWN_RIGHT = 4;
	public static final int UP_RIGHT = 5;
	public static final int DOWN_LEFT = 6;
	public static final int UP_LEFT = 7;
	
	private ArrayList<Point> coordinates;
	private int pointCount, imageCount;
	private ArrayList<Integer> dirFacing;
	
	public Contour(String imagePath) {
		coordinates = new ArrayList<>();
		dirFacing = new ArrayList<>();
		
		pointCount = 0;
		imageCount = 0;
		parseFromImage(imagePath);
	}
	
	public ArrayList<Point> getCoords() {
		return coordinates;
	}
	
	public void setCoords(ArrayList<Point> list) {
		coordinates = list;
	}
	
	public int getNumberOfPoint() {
		return pointCount;
	}
	
	public void parseFromImage(String imagePath) {
		// Initialize stuff
		Image image = new ImageIcon(imagePath).getImage();
    	BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2d = (Graphics2D) bi.createGraphics();
    	g2d.drawImage(image, 0, 0, null);
    	
    	// Find the upper left-most point of the path as the start point
    	Point startPoint = null;
    	
    	forLoops: {
	    	for (int i = 0; i < bi.getHeight(); i++) {
	    		for (int j = 0; j < bi.getWidth(); j++) {
	    	    	if (bi.getRGB(j, i) != 0) {
	    	    		startPoint = new Point(j, i);
	    	    		coordinates.add(startPoint);
	    	    		break forLoops;
	    	    	}
	    		}
	    	}
    	}
    	
    	Point currPoint = startPoint;
    	// The path will most likely always start facing right, because it searches from the top left
    	dirFacing.add(1);
    	
    	Point[] directionCheck = {new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0), new Point(1, 1), new Point(1, -1), new Point(-1, 1), new Point(-1, -1)};
    	
    	while (true) {    		
    		// Check in every direction around the current point, to find the next one
    		boolean foundNewPoint = false;
    		Point newPoint = null;
    		
    		for (int i = 0; i < directionCheck.length; i++) {
    			newPoint = new Point(addPoints(currPoint, directionCheck[i]));
    			boolean hasColor = bi.getRGB((int) newPoint.getX(), (int) newPoint.getY()) != 0;
    			
    			if (hasColor && !arrayContainsPoint(coordinates, newPoint)) {
    				coordinates.add(newPoint);
    				dirFacing.add(i);
    				pointCount++;
    				foundNewPoint = true;
    				break;
    			}
    		}
    		if (!foundNewPoint)
    			break;
    		else
    			currPoint = newPoint;
    	}
    	

	}
	
	public void animateAlongPath(Image image, Graphics2D g) {
		g.drawImage(image, (int)coordinates.get(imageCount).getX(), (int)coordinates.get(imageCount).getY(), null);
		//System.out.println((int)coordinates.get(imageCount).getX() + " " + (int)coordinates.get(imageCount).getY());
		//System.out.println(imageCount);
		//System.out.println(dirFacing.get(imageCount));
		imageCount += 5;
		if (imageCount >= pointCount)
			imageCount = 0;
	}
	
	public boolean arrayContainsPoint(ArrayList<Point> list, Point point) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getX() == point.getX() && list.get(i).getY() == point.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public Point addPoints(Point p1, Point p2) {
		Point newPoint = new Point((int) (p1.getX() + p2.getX()), (int) (p1.getY() + p2.getY()));
		return newPoint;
	}
	
    public void updateSprite(Image image, Graphics g, int speed) {
		// TODO: Fix rotating, it gets wonky with circle shaped stuff
    	Graphics2D g2d = (Graphics2D) g;
    	
    	int angle = 0;
    	
    	switch (dirFacing.get(imageCount)) {
	    	case 0:
	    		angle = 180;
	    		break;
	    	case 1:
	    		angle = 0;
	    		break;
	    	case 2:
	    		angle = 90;
	    		break;
	    	case 3:
	    		angle = -90;
	    		break;
	    	case 4:
	    		angle = 135;
	    		break;
	    	case 5:
	    		angle = 45;
	    		break;
	    	case 6:
	    		angle = -135;
	    		break;
	    	case 7:
	    		angle = -45;
	    		break;
    	}

    	AffineTransform og = g2d.getTransform();
    	AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(angle), coordinates.get(imageCount).getX() + image.getWidth(null) / 2, coordinates.get(imageCount).getY() + image.getHeight(null) / 2);
    	g2d.setTransform(tr);
    	g2d.drawImage(image, (int) coordinates.get(imageCount).getX(), (int) coordinates.get(imageCount).getY(), null);
    	g2d.setTransform(og);
    	
		imageCount += speed;
		if (imageCount >= pointCount)
			imageCount = 0;

    }
    
    public int getDirection() {
    	return dirFacing.get(imageCount);
    }
    
    public int getImageCount() {
    	return imageCount;
    }

}
