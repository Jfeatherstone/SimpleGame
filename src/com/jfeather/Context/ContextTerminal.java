package com.jfeather.Context;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContextTerminal extends JPanel implements MouseListener {

	public static final int WIDTH = 174;
	public static final int HEIGHT = 190;
	
	private JLabel[] tabs;
	private JLabel[] tabSelect;
	private boolean tab1, tab2, tab3;
	private ImageIcon[] selectedImages;
	private ImageIcon[] unselectedImages;
	public ContextTerminal() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.CYAN);
		//addMouseListener(this);
		
		tab1 = true;
		tab2 = false;
		tab3 = false;
		
		tabs = new JLabel[3];
		tabSelect = new JLabel[3];
		
		ImageIcon[] images = {new ImageIcon("Sprites/Display/ContextTab1.png"), new ImageIcon("Sprites/Display/ContextTab2.png"), new ImageIcon("Sprites/Display/ContextTab3.png")};
		tabs[0] = new JLabel(images[0]);
		tabs[1] = new JLabel(images[1]);
		tabs[2] = new JLabel(images[2]);
		
		selectedImages = new ImageIcon[3];
		unselectedImages = new ImageIcon[3];
		
		selectedImages[0] = new ImageIcon("Sprites/Display/Tab1Selected.png"); 
		selectedImages[1] = new ImageIcon("Sprites/Display/Tab2Selected.png");
		selectedImages[2] = new ImageIcon("Sprites/Display/Tab3Selected.png");
		unselectedImages[0] = new ImageIcon("Sprites/Display/Tab1.png");
		unselectedImages[1] = new ImageIcon("Sprites/Display/Tab2.png");
		unselectedImages[2] = new ImageIcon("Sprites/Display/Tab3.png");
		
		tabs[0].setBounds(37, 162, images[0].getIconWidth(), images[0].getIconHeight());
		tabs[1].setBounds(77, 162, images[1].getIconWidth(), images[1].getIconHeight());
		tabs[2].setBounds(117, 162, images[2].getIconWidth(), images[2].getIconHeight());
		
		for (int i = 0; i < tabs.length; i++) {
			tabSelect[i] = new JLabel(unselectedImages[i]);
			//tabSelect[i].setVisible(false);
			tabs[i].addMouseListener(this);
			add(tabs[i]);
			add(tabSelect[i]);
		}
		
		tabSelect[0].setBounds(33, 159, images[0].getIconWidth() + 8, images[0].getIconHeight() + 8);
		tabSelect[1].setBounds(73, 159, images[1].getIconWidth() + 8, images[1].getIconHeight() + 8);
		tabSelect[2].setBounds(113, 159, images[2].getIconWidth() + 8, images[2].getIconHeight() + 8);
		
		tabSelect[0].setIcon(selectedImages[0]);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() == tabs[0] && !tab1) {
			tab1 = true;
			tab2 = false;
			tab3 = false;
			
			tabSelect[0].setIcon(selectedImages[0]);
			tabSelect[1].setIcon(unselectedImages[1]);
			tabSelect[2].setIcon(unselectedImages[2]);

		}
		if (e.getComponent() == tabs[1] && !tab2) {
			tab1 = false;
			tab2 = true;
			tab3 = false;
			
			tabSelect[0].setIcon(unselectedImages[0]);
			tabSelect[1].setIcon(selectedImages[1]);
			tabSelect[2].setIcon(unselectedImages[2]);
			

		}
		if (e.getComponent() == tabs[2] && !tab3) {
			tab1 = false;
			tab2 = false;
			tab3 = true;
			
			tabSelect[0].setIcon(unselectedImages[0]);
			tabSelect[1].setIcon(unselectedImages[1]);
			tabSelect[2].setIcon(selectedImages[2]);

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
