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
	
	private void addElement(ResultSet rs) throws SQLException {
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
			String query = "select * from BookInfo";
			if(!action.equals("all"))
				query += " where " + action + "=" + value;
			query += " order by " + order + (isAsc ? " ASC" : " DESC") + ";";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				this.addElement(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { stmt.close();}
			catch (Exception ignored) {}
		}
	}
	
	public boolean rentToggle(String id) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "update BookInfo set rentCnt = rentCnt + 1 where id=" + id + " and rent = 0;";
			stmt.executeUpdate(query);
			query = "update BookInfo set rent = rent XOR 1 where id=" + id + ";";
			return stmt.executeUpdate(query) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addBook(String id, String title, String author, String price) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "insert into BookInfo " + "(id, title, author, price) value (" +
					id + "," + title + "," + author + "," + price + ");";
			return stmt.executeUpdate(query) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}