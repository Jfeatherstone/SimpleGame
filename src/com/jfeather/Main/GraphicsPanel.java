package com.jfeather.Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
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
	private JLabel graphicTerminalPanel;
	private JLabel graphicTerminalScreen;
	private JLabel contextTerminal;
	private JLabel combatTerminal;
	private JLabel inventoryTerminal;
	
	private JLabel contextWire;
	private JLabel combatWire;
	private JLabel inventoryWire;
	
	public GraphicsPanel() {
		setPreferredSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
		setLayout(null);
		//setBackground(Color.GRAY);
		setOpaque(false);
		/*
		graphicTerminal = new JLabel(new ImageIcon("Sprites/Display/GraphicsFrame.png"));
		graphicTerminal.setBounds(35, 20, 450, 250);
		add(graphicTerminal);
		*/
		graphicTerminalScreen = new JLabel(new ImageIcon("Sprites/Display/GraphicsFrameScreen.png"));
		graphicTerminalScreen.setBounds(35, 20, 450, 196);
		add(graphicTerminalScreen);
		
		graphicTerminalPanel = new JLabel(new ImageIcon("Sprites/Display/GraphicsFramePanel.gif"));
		graphicTerminalPanel.setBounds(35, 216, 450, 54);
		add(graphicTerminalPanel);
		
		contextTerminal = new JLabel(new ImageIcon("Sprites/Display/ContextFrame.png"));
		contextTerminal.setBounds(530, 20, 190, 200);
		add(contextTerminal);
		
		contextWire = new JLabel(new ImageIcon("Sprites/Display/ContextWire.png"));
		contextWire.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
		add(contextWire);
		
		combatTerminal = new JLabel(new ImageIcon("Sprites/Display/CombatFrame.png"));
		combatTerminal.setBounds(530, 245, 190, 140);
		add(combatTerminal);
		
		combatWire = new JLabel(new ImageIcon("Sprites/Display/CombatWire.png"));
		combatWire.setBounds(0,  0,  GameFrame.WIDTH, GameFrame.HEIGHT);
		add(combatWire);
		
		inventoryTerminal = new JLabel(new ImageIcon("Sprites/Display/InventoryFrame.png"));
		inventoryTerminal.setBounds(35, 305, 450, 80);
		add(inventoryTerminal);
		
		inventoryWire = new JLabel(new ImageIcon("Sprites/Display/InventoryWire.png"));
		inventoryWire.setBounds(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
		add(inventoryWire);
		
	}
	
	public void animateInventoryWire() {
		inventoryWire.setIcon(new ImageIcon("Sprites/Display/InventoryWire.gif"));
	}
}
