package dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import model.BookInfo;

public class BookInfoDao {
	private Vector <BookInfo> bookList;
	private Connection conn;

	public BookInfoDao() {
		this.bookList = new Vector <BookInfo> ();
		this.conn = null;
		try {
			Properties prop = new Properties();
			InputStream inputStream = BookInfoDao.class.getClassLoader().getResourceAsStream("/.properties");
			prop.load(inputStream);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (conn == null) {
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector <BookInfo> getBookList() {
		return this.bookList;
	}
	
	public void addElement(ResultSet rs) throws SQLException {
		BookInfo book = new BookInfo();
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getInt("price"));
		book.setRent(rs.getBoolean("Rent"));
		book.setRentCnt(rs.getInt("RentCnt"));
		this.bookList.addElement(book);
	}
	
	public void findAndSort(String action, String value, String order, boolean isAsc) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = null;
			String query = "select * from BookInfo";
			if(!action.equals("all"))
				query += " where " + action + "=" + value;
			query += " order by " + order + (isAsc ? " ASC" : " DESC") + ";";
			rs = stmt.executeQuery(query);
			while (rs.next())
				this.addElement(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			}
			catch (Exception ignored) {}
			try {
				conn.close();
			}
			catch (Exception ignored) {}
		}
	}
}