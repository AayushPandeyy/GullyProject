package com.example.complete_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class footerPanel extends JPanel{
	public static boolean clear = false;
	static JButton resetButton;
	public static ProductCard pcard = new ProductCard();
	public footerPanel() {
		
		setLayout(new GridLayout(0,3,20,20));
		
		setBackground(Color.PINK);
//		setSize(100,500);
		setPreferredSize(new Dimension(100,50));
//		setBounds(100,0,100,50);
		resetButton = new JButton("Reset");
		
		JButton printButton = new JButton("Print");
		JButton totalButton = new JButton("Total");
		resetButton.addMouseListener(new MouseListener() {
			
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
				MainFrame.billingPanel.invoicePanel.removeAll();
				
				MainFrame.billingPanel.revalidate();
				MainFrame.billingPanel.repaint();
				MainFrame.billingPanel.billTitle();
				ProductCard.billItems.clear();
				pcard.total = 0;
				
			}
		});
		totalButton.addMouseListener(new MouseListener() {
			
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
				
				if(pcard.billItems.size()==0) {
					items(100);
				}else {
					items(pcard.b);
				}
					
				}
				
				
			
			
		});{
			printButton.addMouseListener(new MouseListener() {
				
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
			});
		}
		add(resetButton);
		add(printButton);
		add(totalButton);
		
	}
	public static void items(int i) {
		JLabel bpitemLabel = new JLabel("Total");
		bpitemLabel.setFont(new Font("Arial",1,14));
		bpitemLabel.setBounds(40,490,200,20);
		BillingPanel.invoicePanel.add(bpitemLabel);
		
		JLabel bptotalLabel = new JLabel();
		bptotalLabel.setText(String.valueOf(pcard.total));
		bptotalLabel.setFont(new Font("Arial",1,14));
		bptotalLabel.setBounds(410,490,200,20);
		BillingPanel.invoicePanel.add(bptotalLabel);
//		clear = true;
		MainFrame.billingPanel.revalidate();
		MainFrame.billingPanel.repaint();
		MainFrame.billingPanel.setEnabled(false);
//		pcard.total = 0;
	}
	
}
