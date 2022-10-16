package com.example.adminPage;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class mainFrame {
	static JFrame frame;
	public mainFrame() {
		 frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		adminpage apage = new adminpage();
		frame.add(apage,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}
