package com.example.adminPage;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class mainFrame {
	static JFrame frame;
	public mainFrame() {
		 frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		ImageIcon img = new ImageIcon("img/momo.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		adminpage apage = new adminpage();
		frame.add(apage,BorderLayout.CENTER);
		footerPanel fp = new footerPanel();
		frame.add(fp,BorderLayout.SOUTH);
		topPanel tp = new topPanel();
		frame.add(tp,BorderLayout.NORTH);
		frame.setVisible(true);
	}
	
}
