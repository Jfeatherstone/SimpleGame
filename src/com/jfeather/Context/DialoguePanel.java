package com.jfeather.Context;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jfeather.NPC.NPC;

public class DialoguePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JTextField inputField;
	JLabel outputField;
	private ArrayList<NPC> activeNPC;
	
	public DialoguePanel() {
		activeNPC = new ArrayList<>();
		
		setLayout(null);
		setBounds(0, 0, ContextTerminal.WIDTH, ContextTerminal.HEIGHT);
		setOpaque(false);
		setFocusable(false);
		
		inputField = new JTextField();
		inputField.setBounds(10, 128, 153, 20);
		add(inputField);
		inputField.setBackground(new Color(150, 150, 150));
		
		outputField = new JLabel("<html><font color='green'>");
		outputField.setBounds(10, 20, 153, 103);
		add(outputField);
		outputField.setBackground(new Color(50, 50, 50));
		outputField.setVerticalAlignment(JLabel.BOTTOM);
		
		inputField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				// TODO Somehow prevent the String "</html>" from being registered, as it breaks the terminal (this way below doesn't quite work)
				if (!input.equals("") || !input.trim().equals("</html>")) {
					writeTextToTerminal(input, "User", Text.HTML_LIGHT_GREEN);
					inputField.setText("");
					inputField.setEnabled(false);
					inputField.setEnabled(true);
					if (activeNPC.size() > 0) {
						for (int i = 0; i < activeNPC.size(); i++) {
							String output = activeNPC.get(i).reply(input);
							if (output.length() > 0)
								writeTextToTerminal(output, activeNPC.get(i).getName(), activeNPC.get(i).getTextColor());
						}
					}
				}
			}
		});
	}
	
	public void writeTextToTerminal(String text, String speaker, String htmlColor) {
		if (text.length() > 16) {
			int count = 0, spaceIndex = 0;
			boolean firstLine = true;
			// TODO this spacing method here is kinda sketchy; it works for now, but I'm sure there is a much better way to do it
			for (int i = 0; i < text.length(); i++) {
				int maxCharsPerLine = 21;
				if (firstLine) {
					maxCharsPerLine = 9;
					firstLine = false;
				}
				if (text.substring(i, i + 1).equals(" ") && count > maxCharsPerLine) {
					text = text.substring(spaceIndex, i) + "<br>" + text.substring(i, text.length());
					count = 0;
				}
				count++;
			}
		}

		String newText = "<html><font color='green'>" + outputField.getText().substring(26, outputField.getText().length()) + "<br><font color='"+htmlColor+"'>[" + speaker + "]<font color='green'> " + text;
		
		outputField.setText(newText);

	}
	
	public void addNPC(NPC npc) {
		activeNPC.add(npc);
		writeTextToTerminal(npc.genIntroduction(), npc.getName(), npc.getTextColor());
	}
	
	public void removeNPC(NPC npc) {
		activeNPC.remove(npc);
	}

}
