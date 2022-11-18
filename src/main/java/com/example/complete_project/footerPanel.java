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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.BilledProduct;
import model.BilledProductDao;
import model.Product;
import model.ProductDao;

public class footerPanel extends JPanel{
	public static boolean clear = false;
	static JButton resetButton;
	public static int i;
	public static JLabel bptotalLabel;
	public static Calendar cal = new GregorianCalendar();
    public static int  HH = cal.get(Calendar.HOUR_OF_DAY);
    public static int  MIN = cal.get(Calendar.MINUTE);
    public static int  DD = cal.get(Calendar.DAY_OF_MONTH);
    public static int MXN= cal.get(Calendar.MONTH);	
    public static int YY = cal.get(Calendar.YEAR);	
    public static int MON = MXN+1;
    public static int lastDay = DD;
    public static int lastMonth = MON;
    public static int lastYear  = YY;
	public static ProductCard pcard = new ProductCard();
	public static ArrayList<BilledProduct> bp = new ArrayList<>();
	public static BilledProductDao pdao = new BilledProductDao();
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
//		resetButton.setOpaque(false);
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
				 Calendar cal = new GregorianCalendar();
			     int  HH = cal.get(Calendar.HOUR_OF_DAY);
			     int  MIN = cal.get(Calendar.MINUTE);
			     int  DD = cal.get(Calendar.DAY_OF_MONTH);
			     int MXN= cal.get(Calendar.MONTH);	
			     int YY = cal.get(Calendar.YEAR);	
			     int MON = MXN+1;
				for(BilledProduct bi : bi) {
					if(bi.getQuantity()==1) {
						try {
							if(lastMonth==MON) {
								pdao.save(bi);
							}else {
								pdao.drop();
								pdao.save(bi);
								lastDay = DD;
							}
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						for(int i=0;i<bi.getQuantity();i++) {
							try {
								if(MON==lastMonth) {
									pdao.save(bi);
								}else {
									pdao.drop();
//									pdao.create();
									pdao.save(bi);
									lastDay = DD;
								}
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
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
					JOptionPane.showMessageDialog(null, "No Item has been ordered.");
				}else {
					items(pcard.b);
					com.example.discount.App app = new com.example.discount.App();
					try {
						app.main(null);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					
					try {
						com.example.invoicePDF.dailyReport.main(null);
					} catch (ClassNotFoundException | IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
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
