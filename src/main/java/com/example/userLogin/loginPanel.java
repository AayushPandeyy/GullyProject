package com.example.userLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Product;
import model.ProductDao;

public class loginPanel extends JPanel{
	ProductDao pdao = new ProductDao();
	PreparedStatement pstm ;
	public JTextField unameField;
	public JPasswordField pwField;
	public boolean exit;
	
	
	public loginPanel() {
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1000,750));
		setBackground(Color.BLUE);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.yellow);
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1000,750));
		JLabel unameLabel = new JLabel("UserName",SwingConstants.CENTER);
		unameLabel.setBounds(400,100,160,30);
		unameLabel.setFont(new Font("Arial",1,28));
		unameLabel.setForeground(Color.BLACK);
		mainPanel.add(unameLabel);
		unameField = new JTextField();
		unameField.setBounds(600,100,200,30);
		mainPanel.add(unameField);
		
		JLabel pwLabel = new JLabel("Password",SwingConstants.CENTER);
		pwLabel.setBounds(400,200,160,30);
		pwLabel.setFont(new Font("Arial",1,28));
		pwLabel.setForeground(Color.black);
		mainPanel.add(pwLabel);
		pwField = new JPasswordField();
		pwField.setBounds(600,200,200,30);
		mainPanel.add(pwField);
		
		JButton loginButton = new JButton();
		loginButton.setText("Login");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setBounds(400,300,400,30);
		mainPanel.add(loginButton);
		
		
		
		loginButton.addMouseListener(new MouseListener() {
			
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
				
				loginButton.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				loginButton.setBackground(Color.cyan);
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e){
				// TODO Auto-generated method stub
				String uname = unameField.getText();
				String pass = pwField.getText();
				try {
					loginDo(uname,pass);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});{
			
		}
		
		add(mainPanel,BorderLayout.CENTER);
	}
	public void loginDo(String uname , String pw) throws SQLException,ClassNotFoundException, IOException{
		pdao.connect();
		
		String sql = "select * from userlogin";
		
        int i=0;
        
        pstm = pdao.con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            if(rs.getString(2).equals(uname) && rs.getString(3).equals(pw)){
                i=1;
                com.example.complete_project.App app = new com.example.complete_project.App();
                		app.main(null);
                
                		mainFrame.frame.dispose();
//                		mframe.setVisible(false);
//                		mframe.dispose();
//                		mframe = null;
            }        
            
        }
        if(i==0){
                JOptionPane.showMessageDialog(null, "Wrong Username or Password.");
                unameField.setText(null);
                pwField.setText("");
            }

        pdao.disconnect();
	}
}
