package com.example.discount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.complete_project.BillingPanel;
import com.example.complete_project.ProductCard;
import com.example.paymentMethod.App;

public class discountButtons extends JPanel{
	int i;
	static com.example.complete_project.ProductCard pc = new com.example.complete_project.ProductCard();
	public discountButtons() {
		setLayout(new BorderLayout());
		
		int per[] = {0,5,10,20,50,100};
		setPreferredSize(new Dimension(1000,300));
		setBackground(Color.LIGHT_GRAY);
		
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.BLACK);
		buttons.setLayout(new GridLayout(0,3,20,20));
		for(i=0;i<per.length;i++) {
			JButton jb = new JButton(String.valueOf(per[i]));
			
			jb.setFont(new Font("Arial",1,24));
			jb.setBackground(Color.red);
//			jb.setBounds(x,y,20,20);
//			x+=20;
			
			buttons.add(jb);
			jb.addMouseListener(new MouseListener() {
				
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
					com.example.paymentMethod.App app = new com.example.paymentMethod.App();
					try {
						App.main(null);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					float total = ProductCard.total;
					float dr = Float.parseFloat(jb.getText()); 
					float disAmount = dr/100*total;
					float disTotal = total - disAmount;
					String gTotal = String.valueOf(disTotal);
					com.example.complete_project.footerPanel.bptotalLabel.setText(gTotal);
					
					JLabel discountLabel = new JLabel("Discount");
					discountLabel.setFont(new Font("Arial",1,14));
					discountLabel.setBounds(40,450,200,20);
					BillingPanel.invoicePane.add(discountLabel);
					
					JLabel discountAmt = new JLabel();
					discountAmt.setText(String.valueOf(disAmount));
					discountAmt.setFont(new Font("Arial",1,14));
					discountAmt.setBounds(410,450,200,20);
					BillingPanel.invoicePane.add(discountAmt);
					BillingPanel.invoicePane.revalidate();
					BillingPanel.invoicePane.repaint();
					
					mainFrame.frame.dispose();
					
				}
			});
		}
		
		add(buttons);
	}
}
