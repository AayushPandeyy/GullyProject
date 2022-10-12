package com.example.deletePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import model.Product;
import model.ProductDao;

public class mainPanel extends JPanel{
	static JComboBox categoryBox;
	ProductDao pdao = new ProductDao();
	public int i;
	static String Itemname;
	static long itemId;
	static String name;
	static int b;
	static long id;
	static JButton showButton;
	
	ArrayList<Product> pro = new ArrayList<>();
	static JButton delButton;
	public mainPanel() {
		String[] cat = {"Momo","Noodles","StickFood","VegDelights","NonVegDelights","BubbleTea","Drinks"};
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400,750));
		setBackground(Color.LIGHT_GRAY);
		JPanel mainpanel = new JPanel();
		mainpanel.setPreferredSize(new Dimension(400,750));
		mainpanel.setBackground(Color.BLUE);
		mainpanel.setLayout(null);
		
		categoryBox = new JComboBox<>(cat);
		categoryBox.setBounds(100,100,200,30);
		mainpanel.add(categoryBox);
		
		showButton = new JButton("Show Items");
		showButton.setBounds(100,300,200,30);
		mainpanel.add(showButton);
		
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
				name = (String)categoryBox.getSelectedItem();
				mainFrame.ipanel.mainpanel.removeAll();
				itemsPanel.title();
				int sn=1;
				String cat = (String)categoryBox.getSelectedItem();
				try {
					pro = pdao.getAll(cat);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Product p : pro) {
					int a = sn*20;
					b = a+100;
					id = p.getId();
					
					JLabel sLabel = new JLabel((sn++)+"",SwingConstants.CENTER);
					sLabel.setFont(new Font("Arial",1,14));
					sLabel.setBounds(20,b,50,20);
					itemsPanel.mainpanel.add(sLabel);	
					
					JLabel nLabel = new JLabel(p.getName(),SwingConstants.CENTER);
					nLabel.setFont(new Font("Arial",1,14));
					nLabel.setBounds(100,b,200,20);
					itemsPanel.mainpanel.add(nLabel);	
					
					JLabel pLabel = new JLabel(String.valueOf(p.getPrice()),SwingConstants.CENTER);
					pLabel.setFont(new Font("Arial",1,14));
					pLabel.setBounds(380,b,50,20);
					itemsPanel.mainpanel.add(pLabel);	
					
					delButton db= new delButton();
					db.mainpanel.setBounds(450,b,200,20);
					itemsPanel.mainpanel.add(db.mainpanel);
					Itemname = p.getName();
					itemId = p.getId();
					
					
				}
				mainFrame.ipanel.mainpanel.revalidate();
				mainFrame.ipanel.mainpanel.repaint();
			}
		});
		
		
		
		add(mainpanel);
		
	}
}
