package com.example.editPage;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class mainFrame {
	public mainFrame() {
		JFrame frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		frame.setVisible(true);
	}
}
