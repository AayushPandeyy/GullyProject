package com.example.additemPage;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.adminPage.adminpage;

public class mainFrame {
	static JFrame frame;
	public mainFrame() {
		
		 frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainPanel mpanel = new mainPanel();
		ImageIcon img = new ImageIcon("img/momo.png");
		frame.setIconImage(img.getImage());
		
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		frame.add(mpanel,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
