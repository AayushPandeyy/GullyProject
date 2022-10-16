package com.example.complete_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class topPanel extends JPanel{
	public topPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(1000,75));
		setBackground(Color.red);
		JLabel gullyLabel = new JLabel("Gully Momo");
		
		gullyLabel.setFont(new Font("Algerian",0,36));
		gullyLabel.setHorizontalAlignment(JLabel.CENTER);
		gullyLabel.setBounds(300,35,300,30);
		add(gullyLabel);
		JButton logoutButton = new JButton("LogOut");
		logoutButton.setBounds(1100,30,100,30);
		logoutButton.setFont(new Font("Arial",1,17));
		logoutButton.setBackground(Color.cyan);
		add(logoutButton);
		logoutButton.addMouseListener(new MouseListener() {
			
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
				com.example.jdbc.AdminUser au = new com.example.jdbc.AdminUser();
						au.main(null);
				MainFrame.frame.dispose();
			}
		});
		
	}
}
