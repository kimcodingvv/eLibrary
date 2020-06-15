package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import model.UserInfo;

public class UserInfoDao {
	private UserInfo user;
	private Connection conn;
	
	public UserInfoDao(){
		this.user = new UserInfo();
		this.conn = null;
		try {
			Properties prop = new Properties();
			InputStream inputStream = UserInfoDao.class.getClassLoader().getResourceAsStream("/.properties");
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
	
	public UserInfo getUser() {
		return this.user;
	}
	
	public boolean addUser(String id, String password) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "insert into UserInfo " + "(id, password) value ('" +
					id + "', '" + password + "');";
			System.out.println(query);
			return stmt.executeUpdate(query) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
