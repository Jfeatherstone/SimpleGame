package com.jfeather.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jfeather.Character.Player;
import com.jfeather.Character.PlayerInstance;
import com.jfeather.Context.ContextTerminal;
import com.jfeather.Context.Text;
import com.jfeather.Entities.Contour;
import com.jfeather.Entities.Enemy;
import com.jfeather.Game.GameTerminal;
import com.jfeather.Game.Level.LevelInstance;
import com.jfeather.Game.Level.LevelParse;
import com.jfeather.Inventory.InventoryTerminal;
import com.jfeather.NPC.GenericTrader;
import com.jfeather.NPC.NPC;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 760;
	public static final int HEIGHT = 430;
	public static final String TITLE = "Title";
	private JLayeredPane contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 **/
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle(TITLE);
		pack();
		setBackground(Color.GRAY);
		setResizable(false);
		Image icon = new ImageIcon("Sprites/Display/GameIcon.png").getImage();
		setIconImage(icon);
		
		// Add the gameplay terminal instance
		GameTerminal gt = new GameTerminal(new LevelInstance(new PlayerInstance(new Player("Jack"))));
		//GameTerminal gt = new GameTerminal(LevelParse.parseLevelFromFile("TestLevel.txt", new PlayerInstance(new Player("Jack"))));
		gt.setBounds(55, 36, GameTerminal.WIDTH, GameTerminal.HEIGHT);
		add(gt, 1);
		
		// Add the inventory terminal instance
		InventoryTerminal it = new InventoryTerminal();
		it.setBounds(47, 317, InventoryTerminal.WIDTH, InventoryTerminal.HEIGHT);
		
		ContextTerminal ct = new ContextTerminal();
		ct.setBounds(538, 25, ContextTerminal.WIDTH, ContextTerminal.HEIGHT);
		
		// Add the terminal panels that constitute the game GUI
		GraphicsPanel gp = new GraphicsPanel();
		gp.setBounds(0, 0, getWidth(), getHeight());
		add(gp, 2);
		add(it, 1);
		add(ct, 1);
		ct.getDialoguePanel().addNPC(new NPC());
		
	}
}