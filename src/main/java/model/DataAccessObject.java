package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataAccessObject<T> {
	public void connect() throws ClassNotFoundException, SQLException;
	public void disconnect() throws ClassNotFoundException, SQLException;
	public int save(T t) throws ClassNotFoundException, SQLException;
	public T getOne(Long id) throws ClassNotFoundException, SQLException;
	public ArrayList<T> getAll() throws ClassNotFoundException, SQLException;
	public int update(T t) throws ClassNotFoundException, SQLException;
	public int delete(long id) throws ClassNotFoundException, SQLException;
	int update(BilledProduct p, int qty) throws ClassNotFoundException, SQLException;
}
