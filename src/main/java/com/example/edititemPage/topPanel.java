package com.example.edititemPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class topPanel extends JPanel{
public topPanel() {
	setLayout(null);
	setPreferredSize(new Dimension(1000,75));
	JLabel gullyLabel = new JLabel("Edit Items");
	setBackground(Color.PINK);
	gullyLabel.setFont(new Font("Algerian",0,36));
	gullyLabel.setForeground(Color.RED);
	gullyLabel.setBounds(450,10,300,30);
	gullyLabel.setHorizontalAlignment(JLabel.CENTER);
	JButton jb = new JButton("Back");
	jb.setBounds(10,20,100,30);
	jb.addMouseListener((MouseListener) new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			com.example.adminPage.App app = new com.example.adminPage.App();
			app.main(null);
			mainFrame.frame.dispose();
		}
	});
	add(jb);
	add(gullyLabel);
}
}
