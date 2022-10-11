package com.example.adminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import com.example.additemPage.*;
import com.example.showitemPage.*;

public class adminpage extends JPanel{
	public adminpage() {
		setLayout(new GridLayout(0,1));
		setPreferredSize(new Dimension(1000,750));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1000,750));
		mainPanel.setBackground(Color.PINK);
		
		JButton addButton = new JButton();
//				addButton.setSize(new Dimension(150,150));
		addButton.setText("Add Item");
		addButton.setBounds(450,100,400,80);
		mainPanel.add(addButton);
		
		addButton.addMouseListener(new MouseListener() {
			
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
				
				com.example.additemPage.App app = new com.example.additemPage.App();
				app.main(null);
				
			}
		});{
			
		}
		
		
		
		JButton delButton = new JButton();
		delButton.setText("Delete Item");
		delButton.setBounds(450,200,400,80);
//		delButton.setSize(new Dimension(150,150));
		mainPanel.add(delButton);
		
		delButton.addMouseListener(new MouseListener() {
			
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
				
			}
		});{
			
		}
		
		JButton editButton = new JButton();
		editButton.setText("Edit Item");
//		editButton.setSize(new Dimension(150,450));
		editButton.setBounds(450,300,400,80);
		mainPanel.add(editButton);
		
		JButton showButton = new JButton();
		showButton.setText("Show Item");
//		editButton.setSize(new Dimension(150,450));
		showButton.setBounds(450,400,400,80);
		mainPanel.add(showButton);
		
		showButton.addMouseListener(new MouseListener() {
			
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
				com.example.showitemPage.App app = new com.example.showitemPage.App();
				app.main(null);
				
			}
		});{
			
		}
		
		add(mainPanel);
	}
}
