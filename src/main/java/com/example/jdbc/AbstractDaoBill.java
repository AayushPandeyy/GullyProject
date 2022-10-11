package com.example.jdbc;
import java.sql.*;

public abstract class AbstractDaoBill<T> implements DataAccessObject<T> {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/bill";
	String user = "root";
	String pass = "Iamaprogram";
	Connection con;
	@Override
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,pass);
		
		
	}
	@Override
	public void disconnect() throws SQLException {
		con.close();
		
	}
}
