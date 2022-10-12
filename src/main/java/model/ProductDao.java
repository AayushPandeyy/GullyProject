package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.additemPage.mainPanel;
import com.example.deletePage.*;

public class ProductDao extends AbstractDao<Product> {
	
	PreparedStatement pstm;
	ResultSet rs;
	String sql;
	int i;
	public int save(Product p,String name) throws ClassNotFoundException, SQLException {
		sql = "insert into "+name+" "
				+ "(name, price) "
				+ "values(?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());

		pstm.setFloat(2, p.getPrice());

		i = pstm.executeUpdate();
		disconnect();
		return i;
	}

	public Product getOne(Long id) throws ClassNotFoundException, SQLException {
		sql = "select * from product where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		rs = pstm.executeQuery();
		Product p = new Product();
		if(rs.next()) {
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));

			p.setPrice(rs.getFloat("price"));

		}
		disconnect();
		return p;
	}

	public ArrayList<Product> getAll(String name) throws ClassNotFoundException, SQLException {
		sql = "select * from "+name;
		connect();
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		ArrayList<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));

			p.setPrice(rs.getFloat("price"));

			products.add(p);
		}
		disconnect();
		
		return products;
		
	}

	public int update(Product p) throws ClassNotFoundException, SQLException {
		sql = "update product set name=?,  price=?, instock=? "
				+ " where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());

		pstm.setFloat(2, p.getPrice());

		pstm.setLong(3, p.getId());
		int i = pstm.executeUpdate();
		return i;
	}

	public int delete(long id,String name) throws ClassNotFoundException, SQLException {
		sql = "delete from "+name+" where name = ?";
		connect();
		pstm = con.prepareStatement(sql);
	
		pstm.setString(1 , "Hello");
		i = pstm.executeUpdate();
		disconnect();
		
		return i;
	}
	@Override
	public int save(Product t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Product> getAll1(String name) throws ClassNotFoundException, SQLException {
		sql = "select * from "+name;
		connect();
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		ArrayList<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("uname"));

			p.setPrice(rs.getFloat("pass"));

			products.add(p);
		}
		disconnect();
		
		return products;
		
	}

	@Override
	public int delete(long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
