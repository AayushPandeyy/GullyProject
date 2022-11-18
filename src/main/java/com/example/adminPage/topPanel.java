package com.example.adminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class topPanel extends JPanel{
	public topPanel() {
		setLayout(new GridLayout(0,1));
		setPreferredSize(new Dimension(1000,75));
		JLabel gullyLabel = new JLabel("Admin Page");
		setBackground(Color.BLACK);
		gullyLabel.setFont(new Font("Algerian",0,36));
		gullyLabel.setForeground(Color.RED);
		gullyLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gullyLabel);
	}
}
