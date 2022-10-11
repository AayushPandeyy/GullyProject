package com.example.adminLogin;

import java.awt.BorderLayout;

import javax.swing.*;

public class mainFrame {
	public JFrame frame;
	public mainFrame() {
		frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		loginPanel lpanel = new loginPanel();
		frame.add(lpanel,BorderLayout.CENTER);
		frame.setVisible(true);
		loginPanel lp = new loginPanel();
		
	}
	public void exit() {
		frame.dispose();
	}
	
}
