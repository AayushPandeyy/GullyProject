package com.example.userLogin;

import java.awt.BorderLayout;

import javax.swing.*;

public class mainFrame {
	public static JFrame frame;
	public mainFrame() {
		frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon img = new ImageIcon("img/momo.png");
		frame.setIconImage(img.getImage());
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		loginPanel lpanel = new loginPanel();
		frame.add(lpanel,BorderLayout.CENTER);
		
		footerPanel fp = new footerPanel();
		frame.add(fp,BorderLayout.SOUTH);
		frame.setVisible(true);
		
	}
	public void exit() {
		frame.dispose();
	}
	
}
