package com.jfeather.NPC;

import com.jfeather.Context.Text;

public class NPC {

	private String name;
	private String textColor;
	
	public NPC() {
		name = "Test";
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
		return "Hello there!";
	}
	
	public String getTextColor() {
		return textColor;
	}
	
	public void setTextColor(String newColor) {
		textColor = newColor;
	}
}
