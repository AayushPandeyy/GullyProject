package com.example.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao extends AbstractDao<Product>{
	
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
		Product p =new Product();
		sql = "select * from product where id=?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));

			p.setPrice(rs.getFloat("price"));

		}
		disconnect();
		return p;
	}

	@Override
	public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
		ArrayList<Product> products = new ArrayList<>();
		connect();
		sql = "select * from momo";
		pstm = con.prepareCall(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
                        
			p.setPrice(rs.getFloat("price"));

			products.add(p);
		}
		disconnect();
		return products;
	}

	@Override
	public int update(Product p) throws ClassNotFoundException, SQLException {
		sql = "update product set name=?,manufacturer=?,description=?,price=?,inStock=? where id=?";
				
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());


		pstm.setFloat(4, p.getPrice());

		pstm.setLong(6, p.getId());
		i = pstm.executeUpdate();
		disconnect();
		
		return i;
	}

	@Override
	public int delete(long id) throws ClassNotFoundException, SQLException {
		sql = "delete from product where id=?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		i = pstm.executeUpdate();
		return i;
	}
	
}
