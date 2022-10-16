package com.example.showitemPage;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.example.adminPage.adminpage;

public class mainFrame {
	static JFrame frame;
	static showitemPanel sPanel;
	public mainFrame() {
		 frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		mainPanel mpanel = new mainPanel();
		frame.add(mpanel,BorderLayout.CENTER);
		sPanel = new showitemPanel();
		frame.add(sPanel,BorderLayout.EAST);
		frame.setVisible(true);
	}
}
