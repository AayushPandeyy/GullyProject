package com.example.edititemPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ProductDao;

public class editButton extends JPanel{
	public static JPanel mainpanel;
	ProductDao pdao = new ProductDao();
	public int i;
	public editButton() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200,30));
		setBackground(Color.LIGHT_GRAY);
		mainpanel = new JPanel();
		mainpanel.setPreferredSize(new Dimension(200,30));
		mainpanel.setBackground(Color.BLUE);
		mainpanel.setLayout(null);
		JButton jb = new JButton("Edit");
		jb.setBounds(0,0,200,20);
		
		jb.addMouseListener((MouseListener) new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
//				try {
//					i = pdao.delete(mainPanel.itemId,mainPanel.name);
////					mainPanel.showButton.doClick();
//				} catch (ClassNotFoundException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				if(i==0) {
//					JOptionPane.showMessageDialog(null, "Item Not deleted.");
//				}else {
//					JOptionPane.showMessageDialog(null, "Item deleted.");
//					
//				}
			}
		});
		
		mainpanel.add(jb);
		
		add(mainpanel);
	}
}
