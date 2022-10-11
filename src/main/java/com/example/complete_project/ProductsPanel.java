package com.example.complete_project;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;

import model.Product;

public class ProductsPanel extends JPanel {

	public ProductsPanel(ArrayList<Product> products) throws IOException {
		GridBagConstraints gbc = new GridBagConstraints();  
        
         
        GridBagLayout layout = new GridBagLayout();  
		setLayout(layout);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = 0;  
		gbc.gridy = 0;  

		
		for(Product p:products) {
			
			ProductCard pCard = new ProductCard(p);
			
			
			add(pCard,gbc);
			if(gbc.gridx<3) {
				gbc.gridx++;
			}else {
				gbc.gridy++;
				gbc.gridx=0;
			}
			
		}
		
	}
	
}
