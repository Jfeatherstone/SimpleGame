package com.jfeather.Game.Level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.jfeather.Character.PlayerInstance;

public class LevelParse {

	public static LevelInstance parseLevelFromFile(String filePath, PlayerInstance player) {
		FileReader fr = null;
		LevelInstance instance = new LevelInstance(player);
		try {
			fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while ((line = br.readLine()) != null) {
				// Whether the first non-space character is a #, denoting a comment line
				int index = 0;
				for (int i = 0; i < line.length(); i++) {
					if (!line.substring(i, i+1).equals(" ")) {
						index = i;
						break;
					}

				}
				// Ignore the line if its a comment
				if (!line.substring(index, index + 1).equals("#")) {
					String word = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i+1).equals("=")) {
							word = line.substring(index, i).trim();
							index = i;
							break;
						}
					}
					int index2 = line.length();
					for (int i = index + 1; i < line.length(); i++) {
						if (line.substring(i, i+1).equals("#")) {
							index2 = i;
							break;
						}
					}
					String value = line.substring(index + 1, index2).trim();

					switch (word) {
					case "set_background_tile":
						if (!value.toLowerCase().equals("random"))
							instance.setBackgroundTile(value);
						else
							instance.genRandomBackgroundTile();
						break;
					case "create_new_obstacle":
						// Find where the commas are to separate the variables
						int commaIndex1 = 0, commaIndex2 = 0;
						for (int i = 0; i < value.length(); i++) {
							if (value.substring(i, i+1).equals(",")) {
								commaIndex1 = i;
								break;
							}
						}
						
						for (int i = commaIndex1 + 1; i < value.length(); i++) {
							if (value.substring(i, i+1).equals(",")) {
								commaIndex2 = i;
								break;
							}
						}
						
						String tileName = value.substring(0, commaIndex1).trim();
						int x = Integer.parseInt(value.substring(commaIndex1 + 1, commaIndex2).trim());
						int y = Integer.parseInt(value.substring(commaIndex2 + 1, value.length()).trim());
						instance.addNewObstacle(new ImageIcon(tileName).getImage(), x, y);
						break;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "<html>Level txt file not found! <br>Check your path and try again.", "Invalid file", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return instance;
	}
}
