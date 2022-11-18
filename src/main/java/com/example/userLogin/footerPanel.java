package com.example.userLogin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class footerPanel extends JPanel{

	public footerPanel() {
		setLayout(new GridLayout(0,1));
		setPreferredSize(new Dimension(1000,40));
		JLabel address = new JLabel("Developed By : SAN Enterprises");
		address.setFont(new Font("Arial",1,14));
		address.setForeground(Color.gray);
		JLabel contact = new JLabel("Contact : 9829071968 Email : sanenterprise@gmail.com");
		contact.setFont(new Font("Arial",1,14));
		contact.setForeground(Color.gray);
		setBackground(Color.black);
		
		add(address);
		add(contact);
	}

}
