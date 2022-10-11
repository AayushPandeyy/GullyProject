package com.example.additemPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Product;
import model.ProductDao;

public class mainPanel extends JPanel{
	static JButton submitButton;
	public mainPanel() {
		ProductDao pdao = new ProductDao();
		String[] cat = {"Momo","Noodles","StickFood","VegDelights","NonVegDelights","BubbleTea","Drinks"};
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1000,750));
		setBackground(Color.LIGHT_GRAY);
		JPanel mainpanel = new JPanel();
		mainpanel.setPreferredSize(new Dimension(1000,750));
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.LIGHT_GRAY);
		JComboBox categoryBox = new JComboBox(cat);
		mainpanel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 10) {
					submitButton.doClick();
				}
				
			}
		});
		categoryBox.setBounds(250,200,150,30);
		
		mainpanel.add(categoryBox);
		
		JLabel nameLabel = new JLabel("Name : ");
		nameLabel.setBounds(450,200,100,20);
		nameLabel.setFont(new Font("Arial",0,24));
		mainpanel.add(nameLabel);
		JTextField nameField = new JTextField();
		nameField.setBounds(550,200,200,30);
		mainpanel.add(nameField);
		add(mainpanel,BorderLayout.CENTER);	
		
		JLabel priceLabel = new JLabel("Price : ");
		priceLabel.setBounds(450,300,100,20);
		priceLabel.setFont(new Font("Arial",0,24));
		mainpanel.add(priceLabel);
		JTextField priceField = new JTextField();
		priceField.setBounds(550,300,200,30);
		mainpanel.add(priceField);
		
		submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.setBounds(450,400,300,30);
		mainpanel.add(submitButton);
		
		submitButton.addMouseListener(new MouseListener() {
			
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
			public void mouseClicked(MouseEvent e){
				// TODO Auto-generated method stub
				String category = (String)categoryBox.getSelectedItem();
				category.toLowerCase();
				Product p =new Product();
				p.setName(nameField.getText());
				p.setPrice(Float.parseFloat(priceField.getText()));
				try {
					pdao.save(p,category);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nameField.setText(null);
				priceField.setText(null);
				JOptionPane.showMessageDialog(null,"The item has been added.");
			}
		});{
			
		}
		
		add(mainpanel,BorderLayout.CENTER);
		
	}
}
