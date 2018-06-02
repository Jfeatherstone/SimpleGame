package com.jfeather.NPC;

import java.util.Random;

import com.jfeather.Context.Text;

public class GenericTrader extends NPC {

	public static String[] introductions = {"Hey there stranger, you lookin' to trade?", "Nice to meet you, what can I do ya for?"};

	public static String[] tradeWords = {"buy", "trade", "sell", "wares", "market", "merchant", "store", "shop"};
	public static String[] tradeReplies = {"How'd ya like to see my wares?", "Ya lookin' to buy somethin'?", "Trader has wares if you have coin."};
	
	public GenericTrader() {
		setName("Trader");
		setTextColor(Text.HTML_GOLD);
	}
	
	@Override
	public String reply(String userInput) {
		Random rng = new Random();
		
		// Test for trading options
		if (contains(userInput, tradeWords)) {
			// Talk about trading
			return tradeReplies[rng.nextInt(tradeReplies.length)];
		}
		
		return "";
	}
	
	@Override
	public String genIntroduction() {
		Random rng = new Random();
		return introductions[rng.nextInt(introductions.length)];
	}

}
