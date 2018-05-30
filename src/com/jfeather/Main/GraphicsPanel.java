package com.jfeather.Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jfeather.Context.ContextTerminal;
import com.jfeather.Game.GameTerminal;

public class GraphicsPanel extends JPanel {

	/**
	 * Ideas:
	 * 	-Maybe have an old computer look
	 * 	-Similar to Fallout terminals
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JLabel graphicTerminalPanel;
	private JLabel graphicTerminalScreen;
	private JLabel contextTerminal;
	private JLabel contextBackground;
	private JLabel combatTerminal;
	private JLabel inventoryTerminal;
	
	private JPanel graphicFadePanel;
	private JPanel contextFadePanel;
	private JPanel combatFadePanel;
	private JPanel inventoryFadePanel;
	
	private JLabel contextWire;
	private JLabel combatWire;
	private JLabel inventoryWire;
	
	public GraphicsPanel() {
		setPreferredSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
		setLayout(null);
		setOpaque(false);
		
		graphicTerminalScreen = new JLabel(new ImageIcon("Sprites/Display/GraphicsFrameScreen.png"));
		graphicTerminalScreen.setBounds(35, 20, 450, 196);
		add(graphicTerminalScreen);
		
		graphicTerminalPanel = new JLabel(new ImageIcon("Sprites/Display/GraphicsFramePanel.gif"));
		graphicTerminalPanel.setBounds(35, 216, 450, 54);
		add(graphicTerminalPanel);
		
		contextTerminal = new JLabel(new ImageIcon("Sprites/Display/ContextFrame.png"));
		contextTerminal.setBounds(530, 20, 190, 200);
		add(contextTerminal);
		
		contextBackground = new JLabel(new ImageIcon("Sprites/Display/ContextBackground.png"));
		contextBackground.setBounds(538, 25, ContextTerminal.WIDTH, ContextTerminal.HEIGHT - 40);
		//add(contextBackground);
		
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
		
		//initFadePanels();
	}
	
	public void animateInventoryWire() {
		inventoryWire.setIcon(new ImageIcon("Sprites/Display/InventoryWire.gif"));
	}
	
	// TODO: major WIP here, because the graphic panel just updates over this panel
	public void initFadePanels() {
		graphicFadePanel = new JPanel();
		graphicFadePanel.setBounds(55, 36, GameTerminal.WIDTH, GameTerminal.HEIGHT);
		add(graphicFadePanel);
	}
}
