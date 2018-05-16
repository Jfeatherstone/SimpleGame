package com.jfeather.Context;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ContextTerminal extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 174;
	public static final int HEIGHT = 190;
	
	private JLabel[] tabSelect;
	private boolean tab1, tab2, tab3;
	private ImageIcon[] selectedImages;
	private ImageIcon[] unselectedImages;
	private JPanel dialoguePanel, statsPanel, equipmentPanel;
	JTextField inputField;
	JLabel outputField;
	
	public ContextTerminal() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.GRAY);
		setOpaque(false);
		setFocusable(false);
		initDialoguePanel();
		initStatsPanel();
		initEquipmentPanel();
		
		tab1 = true;
		tab2 = false;
		tab3 = false;
		
		tabSelect = new JLabel[3];
				
		selectedImages = new ImageIcon[3];
		unselectedImages = new ImageIcon[3];
		
		selectedImages[0] = new ImageIcon("Sprites/Display/Tab1Selected.png"); 
		selectedImages[1] = new ImageIcon("Sprites/Display/Tab2Selected.png");
		selectedImages[2] = new ImageIcon("Sprites/Display/Tab3Selected.png");
		unselectedImages[0] = new ImageIcon("Sprites/Display/Tab1.png");
		unselectedImages[1] = new ImageIcon("Sprites/Display/Tab2.png");
		unselectedImages[2] = new ImageIcon("Sprites/Display/Tab3.png");
		
		for (int i = 0; i < tabSelect.length; i++) {
			tabSelect[i] = new JLabel(unselectedImages[i]);
			tabSelect[i].addMouseListener(this);
			//tabs[i].setVisible(false);
			add(tabSelect[i]);
		}
		
		tabSelect[0].setBounds(29, 155, selectedImages[0].getIconWidth() + 8, selectedImages[0].getIconHeight() + 8);
		tabSelect[1].setBounds(69, 155, selectedImages[1].getIconWidth() + 8, selectedImages[1].getIconHeight() + 8);
		tabSelect[2].setBounds(109, 155, selectedImages[2].getIconWidth() + 8, selectedImages[2].getIconHeight() + 8);
		
		tabSelect[0].setIcon(selectedImages[0]);
	}
	
	public void initDialoguePanel() {
		dialoguePanel = new JPanel();
		dialoguePanel.setLayout(null);
		add(dialoguePanel);
		dialoguePanel.setBounds(0, 0, WIDTH, HEIGHT);
		dialoguePanel.setOpaque(false);
		dialoguePanel.setFocusable(false);
		
		inputField = new JTextField();
		inputField.setBounds(10, 128, 153, 20);
		dialoguePanel.add(inputField);
		inputField.setBackground(new Color(150, 150, 150));
		
		outputField = new JLabel("<html><font color='green'>");
		outputField.setBounds(10, 20, 153, 103);
		dialoguePanel.add(outputField);
		outputField.setBackground(new Color(50, 50, 50));
		outputField.setVerticalAlignment(JLabel.BOTTOM);
		
		inputField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				// TODO Somehow prevent the String "</html>" from being registered, as it breaks the terminal (this way below doesn't quite work)
				if (!input.equals("") || !input.trim().equals("</html>")) {
					// TODO this spacing method here is kinda sketchy; it works for now, but I'm sure there is a much better way to do it
					if (input.length() > 16) {
						int count = 0, spaceIndex = 0;
						boolean firstLine = true;
						for (int i = 0; i < input.length(); i++) {
							int maxCharsPerLine = 21;
							if (firstLine) {
								maxCharsPerLine = 9;
								firstLine = false;
							}
							if (input.substring(i, i + 1).equals(" ") && count > maxCharsPerLine) {
								input = input.substring(spaceIndex, i) + "<br>" + input.substring(i, input.length());
								count = 0;
							}
							count++;
						}
					}

					String newText = "<html><font color='green'>" + outputField.getText().substring(26, outputField.getText().length()) + "<br><font color='black'>[User]<font color='green'> " + input;
					
					outputField.setText(newText);
					inputField.setText("");
					inputField.setEnabled(false);
					inputField.setEnabled(true);
				}
			}
		});
	}
	
	public void initStatsPanel() {
		statsPanel = new JPanel();
		add(statsPanel);
		dialoguePanel.setBounds(0, 0, WIDTH, HEIGHT);
		statsPanel.setOpaque(false);
		statsPanel.setVisible(false);
		statsPanel.setFocusable(false);
	}
	
	public void initEquipmentPanel() {
		equipmentPanel = new JPanel();
		add(equipmentPanel);
		equipmentPanel.setBounds(0, 0, WIDTH, HEIGHT);
		equipmentPanel.setOpaque(false);
		equipmentPanel.setVisible(false);
		equipmentPanel.setFocusable(false);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() == tabSelect[0] && !tab1) {
			tab1 = true;
			tab2 = false;
			tab3 = false;
			tabSelect[0].setIcon(selectedImages[0]);
			tabSelect[1].setIcon(unselectedImages[1]);
			tabSelect[2].setIcon(unselectedImages[2]);
			
			dialoguePanel.setVisible(true);
			statsPanel.setVisible(false);
			equipmentPanel.setVisible(false);
			
		}
		if (e.getComponent() == tabSelect[1] && !tab2) {
			tab1 = false;
			tab2 = true;
			tab3 = false;

			tabSelect[0].setIcon(unselectedImages[0]);
			tabSelect[1].setIcon(selectedImages[1]);
			tabSelect[2].setIcon(unselectedImages[2]);
			
			dialoguePanel.setVisible(false);
			statsPanel.setVisible(true);
			equipmentPanel.setVisible(false);

		}
		if (e.getComponent() == tabSelect[2] && !tab3) {
			tab1 = false;
			tab2 = false;
			tab3 = true;
			
			tabSelect[0].setIcon(unselectedImages[0]);
			tabSelect[1].setIcon(unselectedImages[1]);
			tabSelect[2].setIcon(selectedImages[2]);

			dialoguePanel.setVisible(false);
			statsPanel.setVisible(false);
			equipmentPanel.setVisible(true);

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
