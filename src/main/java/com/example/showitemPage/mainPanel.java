package com.example.showitemPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.example.complete_project.BillingPanel;

import model.Product;
import model.ProductDao;

public class mainPanel extends JPanel{
	showitemPanel sPanel = new showitemPanel();
	ProductDao pdao = new ProductDao();
	ArrayList<Product> pro = new ArrayList<>();
	
	String[] cat = {"Momo","Noodles","StickFood","VegDelights","NonVegDelights","BubbleTea","Drinks"};
	public mainPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300,750));
		setBackground(Color.LIGHT_GRAY);
		JPanel mPanel = new JPanel();
		mPanel.setLayout(null);
		mPanel.setPreferredSize(new Dimension(300,500));
		mPanel.setBackground(Color.GREEN);
		JComboBox categoryBox = new JComboBox(cat);
		categoryBox.setBounds(100,100,200,30);
		mPanel.add(categoryBox);
		JButton showButton = new JButton("Show Items");
		showButton.setBounds(300,100,150,30);
		mPanel.add(showButton);
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
				sPanel.itemsPanel.removeAll();
				sPanel.title();
				
				int sn=1;
				// TODO Auto-generated method stub
				String cat = (String)categoryBox.getSelectedItem();
				try {
					pro = pdao.getAll(cat);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Product p : pro) {
					int a = sn*20;
					int b = a+100;
					
					JLabel sLabel = new JLabel((sn++)+"",SwingConstants.CENTER);
					sLabel.setFont(new Font("Arial",1,14));
					sLabel.setBounds(20,b,50,20);
					sPanel.itemsPanel.add(sLabel);	
					
					JLabel nLabel = new JLabel(p.getName(),SwingConstants.CENTER);
					nLabel.setFont(new Font("Arial",1,14));
					nLabel.setBounds(100,b,200,20);
					sPanel.itemsPanel.add(nLabel);	
					
					JLabel pLabel = new JLabel(String.valueOf(p.getPrice()),SwingConstants.CENTER);
					pLabel.setFont(new Font("Arial",1,14));
					pLabel.setBounds(380,b,50,20);
					sPanel.itemsPanel.add(pLabel);	
				}
				mainFrame.sPanel.revalidate();
				mainFrame.sPanel.repaint();
			}
		});{
			
		}
		
		
		
		
		add(mPanel);
		
	}
	
	
}
