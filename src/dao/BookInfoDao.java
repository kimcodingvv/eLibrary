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

	public Vector <BookInfo> getBookList(String prop, String value) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = null;
			if(prop.equals("all"))
				rs = stmt.executeQuery("select * from BookInfo;");
			else
				rs = stmt.executeQuery("select * from BookInfo where '" + prop + "'='" + value + "';");
			while (rs.next()) {
				BookInfo book = new BookInfo();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setRental(rs.getBoolean("Rental"));
				book.setRentalCnt(rs.getInt("RentalCnt"));
				this.bookList.addElement(book);
			}
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
		return bookList;
	}
}