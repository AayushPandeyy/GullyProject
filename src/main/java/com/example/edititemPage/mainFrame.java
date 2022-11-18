package com.example.edititemPage;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ProductDao;

public class mainFrame {
	static itemsPanel ipanel;
	public int i;
	static JFrame frame;
	ProductDao pdao = new ProductDao();
	public mainFrame() throws ClassNotFoundException, SQLException {
		 frame = new JFrame("Main Frame");
		 ImageIcon img = new ImageIcon("img/momo.png");
			frame.setIconImage(img.getImage());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		topPanel tpanel = new topPanel();
		frame.add(tpanel,BorderLayout.NORTH);
		mainPanel mpanel = new mainPanel();
		frame.add(mpanel,BorderLayout.WEST);
		ipanel = new itemsPanel();
		frame.add(ipanel,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
