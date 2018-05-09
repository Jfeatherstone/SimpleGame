package com.jfeather.Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {

	/**
	 * Ideas:
	 * 	-Maybe have an old computer look
	 * 	-Similar to Fallout terminals
	 */
	
	private static final long serialVersionUID = 1L;

	private JLabel graphicTerminal;
	private JLabel dialogueTerminal;
	private JLabel infoTerminal;
	private JLabel inventoryTerminal;
	
	private JLabel dialogWire;
	private JLabel infoWire;
	private JLabel inventoryWire;
	
	public GraphicsPanel() {
		setPreferredSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
		setLayout(null);
		setBackground(Color.BLACK);
		
		graphicTerminal = new JLabel(new ImageIcon("Sprites/Display/GraphicsFrame.gif"));
		graphicTerminal.setBounds(35, 20, 450, 250);
		add(graphicTerminal);
		
		dialogueTerminal = new JLabel(new ImageIcon("Sprites/Display/DialogueFrame.png"));
		dialogueTerminal.setBounds(530, 20, 190, 140);
		add(dialogueTerminal);
		
		infoTerminal = new JLabel(new ImageIcon("Sprites/Display/InfoFrame.png"));
		infoTerminal.setBounds(530, 185, 190, 150);
		add(infoTerminal);
		
		JButton test4 = new JButton();
		test4.setBounds(35, 305, 450, 80);
		add(test4);

	}
}
