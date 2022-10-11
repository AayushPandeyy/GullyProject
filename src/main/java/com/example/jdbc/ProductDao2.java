/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class ProductDao2 extends AbstractDao<Product>{

    PreparedStatement pstm;
    String sql;
    int i;
    @Override
    public int save(Product p) throws ClassNotFoundException, SQLException {
        		sql = "insert into menu "
				+ "(name,price,quantity) "
				+ "values(?,?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());

		pstm.setFloat(2, p.getPrice());
                pstm.setInt(3, p.getQuantity());

		i = pstm.executeUpdate();
		disconnect();
		return i;
    }

    @Override
    public Product getOne(long id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
        		ArrayList<Product> products = new ArrayList<>();
		connect();
		sql = "select * from menu";
		pstm = con.prepareCall(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
                        p.setQuantity(rs.getInt("quantity"));
			p.setPrice(rs.getFloat("price"));

			products.add(p);
		}
		disconnect();
		return products;
    }

    @Override
    public int update(Product p) throws ClassNotFoundException, SQLException {
                sql = "update product set name=?,price=?,quantity=? where id=?";
				
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());
	
		pstm.setFloat(2, p.getPrice());
                pstm.setInt(3,p.getQuantity());
		pstm.setLong(4, p.getId());
		i = pstm.executeUpdate();
		disconnect();
		
		return i;
    }

    @Override
    public int delete(long id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
