package com.example.complete_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.BilledProduct;
import model.Product;

public class ProductCard extends JPanel {
	static Product p;
	static int a;
	static int b;
	public static ArrayList<BilledProduct> billItems = new ArrayList<BilledProduct>();
	public static float total;
	public static ArrayList<Product> proItems = new ArrayList<>();
	public ProductCard(Product p) throws IOException{
		this.p=p;
		setBackground(Color.MAGENTA);
		BufferedImage myPicture=null;
		myPicture = ImageIO.read(new File("img/momo.png"));
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
		/*
		picLabel.setPreferredSize(new Dimension(150,150));
		picLabel.setMaximumSize(new Dimension(150,150));
		*/
		
		picLabel.setSize(new Dimension(150, 150));
		picLabel.setText(p.getName());
		picLabel.setIconTextGap(-148);
		picLabel.setFont(new Font("Arial", 1, 12));
		picLabel.setForeground(Color.CYAN);
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		picLabel.addMouseListener(new MouseListener() {
			
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
			}		
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BilledProduct bproduct = new BilledProduct(p,0);
				total+=bproduct.getPrice();
				System.out.println(billItems);
//				MainFrame.billingPanel.removeAll();
				
				int tableHeaderFontSize = 14;
				int i=1;
				boolean exists=false;
//				if(billItems.contains(bproduct)) {
//					billItems.get(billItems.indexOf(bproduct)).setQuantity(billItems.get(billItems.indexOf(bproduct)).getQuantity()+1);
//					
//				}else {
//					billItems.add(bproduct);
//				}
				int flag=0;
				for(BilledProduct billItem: billItems) {
					if(billItem.getName()==bproduct.getName()) {
						billItem.setQuantity(billItem.getQuantity()+1);
						flag=1;
					}
				}
				
				
				if(flag==0) {
					bproduct.setQuantity(1);
					billItems.add(bproduct);
					
				}
				
				JPanel productTablePanel = new JPanel();
				productTablePanel.setBackground(Color.yellow);
				productTablePanel.setLayout(null);
				productTablePanel.setBounds(0, 100, 500, 350);
//				productTablePanel.setBorder(new LineBorder(Color.BLACK));
				JScrollPane productTablePane = new JScrollPane(productTablePanel);
				b=0;
				for(BilledProduct bp : billItems) {
					a=i*20;
					
					JLabel bpsnLabel = new JLabel("\n"+(i++)+"", SwingConstants.CENTER);
					bpsnLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
					bpsnLabel.setBounds(20,b,20,20);
					productTablePanel.add(bpsnLabel);
					

					JLabel bpitemLabel = new JLabel(bp.getName(), SwingConstants.CENTER);
					bpitemLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
					bpitemLabel.setBounds(40,b,200,20);
					productTablePanel.add(bpitemLabel);
					
					JLabel bprateLabel = new JLabel(bp.getPrice()+"", SwingConstants.CENTER);
					bprateLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
					bprateLabel.setBounds(280,b,40,20);
					productTablePanel.add(bprateLabel);
				
					
					JLabel bpqtyLabel = new JLabel(bp.getQuantity()+"", SwingConstants.CENTER);
				    bpqtyLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
					bpqtyLabel.setBounds(360,b,30,20);
					productTablePanel.add(bpqtyLabel);
					
					JLabel bpamountLabel = new JLabel((bp.getQuantity()*bp.getPrice())+"\n", SwingConstants.CENTER);
					bpamountLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
					bpamountLabel.setBounds(410,b,70,20);
					productTablePanel.add(bpamountLabel);
//					
					b+=20;
					
				}
				
				
//				JScrollPane jpane = new JScrollPane(MainFrame.billingPanel);
				MainFrame.billingPanel.invoicePane.removeAll();
				MainFrame.billingPanel.invoicePane.add(productTablePanel);
				MainFrame.billingPanel.invoicePane.revalidate();
				MainFrame.billingPanel.invoicePane.repaint();
				MainFrame.billingPanel.billTitle();
//				MainFrame.billingPanel.invoicePane.setLayout(new ScrollPaneLayout());
				
				
			}
		});
		
		add(picLabel);
		
		
		
		
	}
	public ProductCard() {
		// TODO Auto-generated constructor stub
	}

}