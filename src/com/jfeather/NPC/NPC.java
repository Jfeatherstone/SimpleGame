package com.jfeather.NPC;

import java.util.Random;

import com.jfeather.Context.Text;

public class NPC {

	private String name;
	private String textColor;
	private boolean hasMetPlayer;
	//public static final String[] specialNameList = {"Donkey Kang", "Cozy Oz", "Spoingo", "Scooter", "Hina", "Mama June", "???", "Ultra Chad"};
	
	public String[] nameList = {"Keith", "Jack", "Spencer", "Cameron", "John", "Vance", "Valerie", "Mike", "Ian", "Erin", "Will", "Amy",
			"Andrew", "Lucy", "Sam", "Tony", "Lili", "Gabe", "Jim", "Stanley", "Kevin", "Timothy", "Chad", "Colin", "Stacy", "Brad", "Norm", "Craig", "Wade", "Wilson",
			"Strange", "Gamorah", "Nebula", "Quill", "Pete", "Lautrec", "Luke", "Leela", "Meg", "Rey", "Chris", "Bart", "Montague", "Mephistopheles", "Roscoe", "Rex",
			"Marmaduke", "Lassie", "Fido", "Kazoo Kid", "Riley", "Harvey", "Dib", "Korg", "Hela", "Cap'n", "The Rock", "Nikki", "Chilli", "Roon", "Han", "Spork",
			"Kiki", "Chance", "Gambino", "Rick", "Mortimer", "Richard", "Milo", "Trey", "Brayden", "Bucky", "Sally", "Michael", "David", "AJ", "Rocket", "Draxx",
			"Handsy", "Snake Eyes", "Crunchinator", "Jay", "Mecha Hitler", "Buck", "Eunes", "Forest", "Nova", "Primus", "Davey", "Jones", "Neil", "Kneecap", "Brock",
			"Custom Grow 420", "Oryx", "Esben", "Shoto", "Daito", "Art3mis", "Cornbread"};
	
	public String[] introductions = {"Hello there!", "Howdy!", "What's up?", "Funny seeing you here.", "Hey big man!", "What can I do ya for?", "How's it going?",
			"Are you new around here?", "What's your name, friend?", "Greetings.", "How ya doin'?", "Got any news?"};
	
	public NPC() {
		name = genRandomName();
		textColor = Text.HTML_BLACK;
		hasMetPlayer = false;
	}
	
	public NPC(String npcName) {
		name = npcName;
		textColor = Text.HTML_BLACK;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String reply(String inputString) {
		return "";
	}
	
	public String genIntroduction() {
		Random rng = new Random();
		hasMetPlayer = true;
		return introductions[rng.nextInt(introductions.length)];
	}
	
	public String getTextColor() {
		return textColor;
	}
	
	public void setTextColor(String newColor) {
		textColor = newColor;
	}
	
	public String genRandomName() {
		Random rng = new Random();
		return nameList[rng.nextInt(nameList.length)];
	}
	
	public boolean hasNPCMetPlayer() {
		return hasMetPlayer;
	}
	
	public static boolean contains(String sentence, String str) {
		for (int i = 0; i < sentence.length() - str.length(); i++)	{
			if (sentence.substring(i, i + str.length()).toLowerCase().equals(str.toLowerCase()))
				return true;
		}
		return false;
	}
	
	public static boolean contains(String sentence, String[] str) {
		for (int j = 0; j < str.length; j++) {
			for (int i = 0; i < sentence.length() - str[j].length(); i++)	{
				if (sentence.substring(i, i + str[j].length()).toLowerCase().equals(str[j].toLowerCase()))
					return true;
			}
		}
		return false;
	}

}
