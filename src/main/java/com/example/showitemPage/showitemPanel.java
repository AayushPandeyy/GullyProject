package com.example.showitemPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class showitemPanel extends JPanel{
	static JPanel itemsPanel;
	public showitemPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(700,750));
		setBackground(Color.LIGHT_GRAY);
		itemsPanel = new JPanel();
		itemsPanel.setLayout(null);
		itemsPanel.setPreferredSize(new Dimension(700,750));
		itemsPanel.setBackground(Color.CYAN);
		itemsPanel.setForeground(Color.BLACK);
		
		
		
		title();
		
		
		add(itemsPanel);
	}
	public static void title() {
JLabel snLabel = new JLabel("SN",SwingConstants.CENTER);
		
		snLabel.setBounds(20,100,50,20);
		
		itemsPanel.add(snLabel);
		
		JLabel nameLabel = new JLabel("Name",SwingConstants.CENTER);
		
		nameLabel.setBounds(100,100,200,20);
		itemsPanel.add(nameLabel);
		
		JLabel priceLabel = new JLabel("Price",SwingConstants.CENTER);
		
		priceLabel.setBounds(380,100,50,20);
		itemsPanel.add(priceLabel);
	}
}
