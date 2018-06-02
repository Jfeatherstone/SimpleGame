package com.jfeather.Game.Level;

import java.util.Random;

public class FloorMap {

	private int numberOfRooms;
	
	public FloorMap() {
		numberOfRooms = genNumberOfRooms();
	}
	
	public int genNumberOfRooms() {
		// TODO: make the number of rooms actually scale off of something, idk what yet
		Random rng = new Random();
		return rng.nextInt(10) + 5;
	}
	
	public void genFloorMap() {
		
		// Generate the starting room
		
	}
	
	public int genRoomExits() {
		Random rng = new Random();
		int random = rng.nextInt(10);
		
		if (random <= 5)
			return 1;
		if (random <= 7)
			return 2;
		if (random <= 9)
			return 3;
		return 4;
	}
}
