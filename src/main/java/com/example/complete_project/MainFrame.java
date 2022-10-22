package com.example.complete_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.Product;
import model.ProductDao;

public class MainFrame{
	public static JFrame frame;
	
	static BillingPanel billingPanel;
	ArrayList<Product> products = null;
	static String title;
	public MainFrame() throws IOException {
		
    	 
    	ImageIcon img = new ImageIcon("img/momo.png");
		frame = new JFrame("The Gully Momo");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {	
				
			}
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					frame.dispose();
					
//					frame.setUndecorated(false);
//					frame.setVisible(true);

				}
			}
		});
		JTabbedPane productsPane = new JTabbedPane();
		
		productReturn("momo");
		ProductsPanel momoPanel = new ProductsPanel(products);
		
		productsPane.add("Momo",new JScrollPane(momoPanel));
		
		productReturn("noodles");
		ProductsPanel noodlesPanel = new ProductsPanel(products);
		productsPane.add("Noodles",new JScrollPane(noodlesPanel));
		
		productReturn("stickfood");
		ProductsPanel stickfoodPanel = new ProductsPanel(products);
		productsPane.add("Stick Food",new JScrollPane(stickfoodPanel));
		
		productReturn("vegdelights");
		ProductsPanel vegDelPanel = new ProductsPanel(products);
		productsPane.add("Veg Delights",new JScrollPane(vegDelPanel));
		
		productReturn("nonvegDelights");
		ProductsPanel nonvegDelPanel = new ProductsPanel(products);
		productsPane.add("Non-Veg Delights",new JScrollPane(nonvegDelPanel));
		
		productReturn("bubbletea");
		ProductsPanel bubbleteaPanel = new ProductsPanel(products);
		productsPane.add("Bubble Tea",new JScrollPane(bubbleteaPanel));
		
		productReturn("drinks");
		ProductsPanel drinksPanel = new ProductsPanel(products);
		productsPane.add("Drinks",new JScrollPane(drinksPanel));
		
		int index = productsPane.getSelectedIndex();
		title = productsPane.getTitleAt(index);
		
    	frame.add(productsPane, BorderLayout.CENTER);
    	billingPanel = new BillingPanel();
    	frame.add(billingPanel, BorderLayout.EAST);
    	footerPanel fpanel = new footerPanel();
    	frame.add(fpanel,BorderLayout.SOUTH);
    	topPanel tpanel = new topPanel();
    	frame.add(tpanel,BorderLayout.NORTH);
    	if(footerPanel.clear==true) {
    		frame.addMouseListener(new MouseListener() {
				
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
					if (e.getButton() == MouseEvent.BUTTON1){
						footerPanel.resetButton.doClick();
						footerPanel.clear = false;
					}
					
				}
			});
    	}
    	frame.setVisible(true);
	}
	public void productReturn(String name) {
		try {
			products = new ProductDao().getAll(name);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
		
	
}
