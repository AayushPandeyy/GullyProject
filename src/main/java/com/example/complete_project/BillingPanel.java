package com.example.complete_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.BilledProduct;


public class BillingPanel extends JPanel{
	//static JScrollPane invoicePanel;
	static JScrollPane invoicePane;
	public BillingPanel() {
//		Calendar cal = new GregorianCalendar();
//        int  HH = cal.get(Calendar.HOUR_OF_DAY);
//        int  MIN = cal.get(Calendar.MINUTE);
//        int  DD = cal.get(Calendar.DAY_OF_MONTH);
//        int MXN= cal.get(Calendar.MONTH);	
//        int YY = cal.get(Calendar.YEAR);	
//        int MON = MXN+1;
        setLayout(new BorderLayout());
		setBackground(Color.PINK);
		//setMaximumSize(new Dimension(500, 500));
		
		
		setPreferredSize(new Dimension(500, 500));
		invoicePane = new JScrollPane();
		invoicePane.setBackground(Color.gray);
		invoicePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//invoicePane.setLayout(null);
		invoicePane.setPreferredSize(new Dimension(500,500));
//		invoicePanel.setBorder(new LineBorder(Color.BLACK));
		
		billTitle();
		
		
		
		
//		invoicePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		invoicePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(invoicePane);
	}
	public static void billTitle() {
		int tableHeaderFontSize=14;

		JLabel title = new JLabel("Gully Momo",SwingConstants.CENTER);
		title.setFont(new Font("Algerian",1,24));
		title.setBounds(0,20,500,30);
		invoicePane.add(title);
		
		JLabel snLabel = new JLabel("SN", SwingConstants.CENTER);
		snLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
		snLabel.setBounds(20,70,20,20);
		invoicePane.add(snLabel);
		

		JLabel itemLabel = new JLabel("Items", SwingConstants.CENTER);
		itemLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
		itemLabel.setBounds(40,70,200,20);
		invoicePane.add(itemLabel);
		
		JLabel rateLabel = new JLabel("Rate", SwingConstants.CENTER);
		rateLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
		rateLabel.setBounds(280,70,40,20);
		invoicePane.add(rateLabel);
		
		JLabel qtyLabel = new JLabel("Qty", SwingConstants.CENTER);
		qtyLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
		qtyLabel.setBounds(360,70,30,20);
		invoicePane.add(qtyLabel);
		
		JLabel amountLabel = new JLabel("Amount", SwingConstants.CENTER);
		amountLabel.setFont(new Font("Arial",1,tableHeaderFontSize));
		amountLabel.setBounds(410,70,70,20);
		invoicePane.add(amountLabel);
		
		
	}
	
}
