package com.example.paymentMethod;

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

import com.example.complete_project.BillingPanel;

public class paymentPanel extends JPanel{
	int i=0;
	String meth[] = {"Cash","Khalti","Fonepay","Esewa"};
	public paymentPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1000,300));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,2,20,20));
		for(i=0;i<meth.length;i++) {
			JButton jb = new JButton(String.valueOf(meth[i]));
			
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
					JLabel paymentLabel = new JLabel("Payment Method : "+meth[i],SwingConstants.CENTER);
					paymentLabel.setFont(new Font("Arial",1,14));
					paymentLabel.setBounds(170,490,200,20);
					BillingPanel.invoicePane.add(paymentLabel);
					
					
					
					BillingPanel.invoicePane.revalidate();
					BillingPanel.invoicePane.repaint();
					mainFrame.frame.dispose();
					
					
					
				}
			});
		}
		
		add(buttons);
		
	}
}
