package com.example.complete_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.BilledProduct;
import model.BilledProductDao;

public class footerPanel extends JPanel{
	public static boolean clear = false;
	static JButton resetButton;
	public static int i;
	public static JLabel bptotalLabel;
	public static ProductCard pcard = new ProductCard();
	public static ArrayList<BilledProduct> bp = new ArrayList<>();
	public static BilledProductDao bpdao = new BilledProductDao();
	public static ArrayList<BilledProduct> bi = com.example.complete_project.ProductCard.billItems;
	public footerPanel() {
		
		setLayout(new GridLayout(0,3,20,20));
		
		setBackground(Color.PINK);
//		setSize(100,500);
		setPreferredSize(new Dimension(100,50));
//		setBounds(100,0,100,50);
		resetButton = new JButton();
		resetButton.setText("Reset");
		resetButton.setFont(new Font("Arial",1,18));
		resetButton.setBackground(Color.GREEN);
		JButton printButton = new JButton();
		printButton.setText("Daily Report");
		printButton.setFont(new Font("Arial",1,18));
		printButton.setBackground(Color.GREEN);
		JButton totalButton = new JButton();
		totalButton.setText("Total");
		totalButton.setFont(new Font("Arial",1,18));
		totalButton.setBackground(Color.GREEN);
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
				for(BilledProduct b : bp) {
					for(BilledProduct bpro : bi) {
						if(bpro.getName()==b.getName()) {
							try {
								i = bpdao.update(b,bpro.getQuantity());
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(i==0) {
								try {
									bpdao.save(bpro);
								} catch (ClassNotFoundException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				}
				MainFrame.billingPanel.invoicePane.removeAll();
				
				ProductCard.billItems.clear();
				
				MainFrame.billingPanel.revalidate();
				MainFrame.billingPanel.repaint();
				BillingPanel.billNo++;
				MainFrame.billingPanel.billTitle();
				pcard.total = 0;
				try {
					bp = bpdao.getAll();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
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
				com.example.discount.App app = new com.example.discount.App();
				try {
					app.main(null);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
//					com.example.invoicePDF.App app = new com.example.invoicePDF.App();
//					try {
//						app.main(null);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
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
		bpitemLabel.setBounds(40,470,200,20);
		BillingPanel.invoicePane.add(bpitemLabel);
		
		bptotalLabel = new JLabel();
		bptotalLabel.setText(String.valueOf(pcard.total));
		bptotalLabel.setFont(new Font("Arial",1,14));
		bptotalLabel.setBounds(410,470,200,20);
		BillingPanel.invoicePane.add(bptotalLabel);
//		clear = true;
		MainFrame.billingPanel.revalidate();
		MainFrame.billingPanel.repaint();
		MainFrame.billingPanel.setEnabled(false);
//		pcard.total = 0;
	}
	
}
