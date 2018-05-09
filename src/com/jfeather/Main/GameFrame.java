package com.jfeather.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

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
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(740, 410));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		pack();
		
		JButton test = new JButton();
		test.setBounds(20, 20, 450, 210);
		add(test);
		
		JButton test2 = new JButton();
		test2.setBounds(510, 20, 190, 140);
		add(test2);
		
		JButton test3 = new JButton();
		test3.setBounds(510, 185, 190, 150);
		add(test3);
		
		JButton test4 = new JButton();
		test4.setBounds(70, 255, 400, 80);
		add(test4);
	}

}
