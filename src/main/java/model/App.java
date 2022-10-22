package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BilledProductDao pdao = new BilledProductDao();
		ResultSet rs = pdao.count();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getInt(2));
			System.out.println(pdao.getprice(String.valueOf(rs.getString(1))));
		}
	}
}
