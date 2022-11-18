package com.example.adminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

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
		mainPanel.setBackground(Color.decode("#bfbd32"));
		
		JButton addButton = new JButton();
//				addButton.setSize(new Dimension(150,150));
		addButton.setText("Add Item");
		addButton.setBounds(450,50,400,120);
		addButton.setBackground(Color.cyan);
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
				mainFrame.frame.dispose();
				
			}
		});{
			
		}
		
		
		
		
		
		
		
		JButton showButton = new JButton();
		showButton.setText("Show Item");
		showButton.setBackground(Color.cyan);
//		editButton.setSize(new Dimension(150,450));
		showButton.setBounds(450,200,400,120);
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
				mainFrame.frame.dispose();
				
			}
		});{
			JButton backButton = new JButton();
			backButton.setText("HOME");
//			editButton.setSize(new Dimension(150,450));
			backButton.setBackground(Color.cyan);
			backButton.setBounds(450,350,400,120);
			backButton.addMouseListener(new MouseListener() {
				
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
					com.example.jdbc.AdminUser.main(null);
					mainFrame.frame.dispose();
				}
			});
			mainPanel.add(backButton);
			
		}
		
		add(mainPanel);
	}
}
