package com.example.complete_project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class topPanel extends JPanel{
	public topPanel() {
		setLayout(new GridLayout(0,1));
		setPreferredSize(new Dimension(1000,75));
		JLabel gullyLabel = new JLabel("Gully Momo");
		
		gullyLabel.setFont(new Font("Algerian",0,36));
		gullyLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gullyLabel);
		
	}
}
