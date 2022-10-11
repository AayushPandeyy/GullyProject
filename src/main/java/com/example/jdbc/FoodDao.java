/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class FoodDao extends AbstractDaoBill<Food>{
    	PreparedStatement pstm;
	String sql;
	int i;
    @Override
    public int save(Food f) throws ClassNotFoundException, SQLException {
        		
		sql = "insert into bills "
				+ "(item,quan,price) "
				+ "values(?,?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, f.getName());
                pstm.setInt(2,f.getQuantity());
		pstm.setFloat(3, f.getPrice());

		i = pstm.executeUpdate();
		disconnect();
		return i;
    }

    @Override
    public Food getOne(long id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Food> getAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Food t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(long id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
