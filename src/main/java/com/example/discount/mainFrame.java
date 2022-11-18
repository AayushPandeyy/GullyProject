package com.example.discount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class mainFrame {
public static JFrame frame;
		public mainFrame() throws ClassNotFoundException, SQLException {
			frame = new JFrame("Main Frame");
//			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			ImageIcon img = new ImageIcon("img/momo.png");
			frame.setIconImage(img.getImage());
			//frame.setUndecorated(true);
			frame.setDefaultCloseOperation(3);
			frame.setResizable(false);
			frame.setSize(new Dimension(1000,300));
			frame.setLocationRelativeTo(null);
			frame.setUndecorated(true);
//			frame.setPreferredSize(new Dimension(1000,100));
			frame.setLayout(new BorderLayout());
//			frame.setBackground(Color.BLUE);
			discountButtons db = new discountButtons();
			frame.add(db,BorderLayout.CENTER);
			frame.setVisible(true);
	}
}
