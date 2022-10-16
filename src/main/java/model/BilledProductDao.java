package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BilledProductDao extends AbstractDao<BilledProduct>{

	String sql;
	PreparedStatement pstm;
	@Override
	public int save(BilledProduct t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i;
		sql = "insert into dailyreport"
				+ "(item, qty , price) "
				+ "values(?,?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, t.getName());

		pstm.setInt(2, t.getQuantity());
		pstm.setFloat(3, t.getPrice());

		i = pstm.executeUpdate();
		disconnect();
		return i;
	}

	@Override
	public BilledProduct getOne(Long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BilledProduct> getAll() throws ClassNotFoundException, SQLException {
		
			sql = "select * from dailyreport";
			connect();
			ResultSet rs;
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ArrayList<BilledProduct> products = new ArrayList<>();
			while(rs.next()) {
				BilledProduct p = new BilledProduct();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("item"));

				p.setPrice(rs.getFloat("price"));
				p.setQuantity(rs.getInt("qty"));
				products.add(p);
			}
			disconnect();
			
			return products;
			
		}
	

	@Override
	public int update(BilledProduct p,int qty) throws ClassNotFoundException, SQLException {
		sql = "update dailyreport set item=?,  qty =? , price=? "
				+ " where item = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());

		pstm.setInt(2, p.getQuantity()+qty);

		pstm.setFloat(3, p.getPrice());
		pstm.setString(4, p.getName());
		int i = pstm.executeUpdate();
		return i;
	}

	@Override
	public int delete(long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BilledProduct t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
