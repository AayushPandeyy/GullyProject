package com.example.deletePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Product;
import model.ProductDao;

public class itemsPanel extends JPanel{
	String selectedCat;
	public static JPanel mainpanel;
	
	public itemsPanel() throws ClassNotFoundException, SQLException {

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,750));
		setBackground(Color.LIGHT_GRAY);
		mainpanel = new JPanel();
		mainpanel.setPreferredSize(new Dimension(800,750));
		mainpanel.setBackground(Color.GREEN);
		mainpanel.setLayout(null);
		
		title();
		
		
		add(mainpanel);
	}
	public static void title() {
		JLabel snLabel = new JLabel("SN",SwingConstants.CENTER);
				
				snLabel.setBounds(20,100,50,20);
				
				mainpanel.add(snLabel);
				
				JLabel nameLabel = new JLabel("Name",SwingConstants.CENTER);
				
				nameLabel.setBounds(100,100,200,20);
				mainpanel.add(nameLabel);
				
				JLabel priceLabel = new JLabel("Price",SwingConstants.CENTER);
				
				priceLabel.setBounds(380,100,50,20);
				mainpanel.add(priceLabel);
				
				
				
			}
}
