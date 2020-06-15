package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	
	public boolean login(String id, String password) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "select * from UserInfo where id='" + id + "' and password='" +password + "';";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				this.user.setId(rs.getString("id"));
				this.user.setPassword(rs.getString("password"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { stmt.close();}
			catch (Exception ignored) {}
		}
		return false;
	}
	
	public boolean changePw(String id, String pw, String newPw) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "update UserInfo set password = '" + newPw + "' where id='" + id + "' and password = '" + pw + "';";
			return stmt.executeUpdate(query) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { stmt.close();}
			catch (Exception ignored) {}
		}
		return false;
	}
	
	public boolean deleteUser(String id, String pw) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			String query = "delete from UserInfo where id = '" + id + "' and password = '" + pw + "';";
			return stmt.executeUpdate(query) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
