package service;

import java.util.Vector;

import dao.BookInfoDao;
import dao.UserInfoDao;

public class userManagement {
	private UserInfoDao dao;
	
	public userManagement() {
		dao = new UserInfoDao();
	}
	
	public int addUser(String id, String password, String confirmPw) {
		if(!password.equals(confirmPw)) return 2;
		return this.dao.addUser(id, password) ? 1 : 0;
	}
	
	public boolean login(String id, String password) {
		return this.dao.login(id, password);
	}
	
	public int changePw(String id, String pw, String newPw, String confirmNewPw) {
		if(!newPw.equals(confirmNewPw)) return 2;
		return this.dao.changePw(id, pw, newPw) ? 1 : 0;
	}
	
	public int deleteUser(String id, String pw) {
		BookInfoDao bd = new BookInfoDao();
		Vector <String> action = new Vector <String> ();
		action.add("rentUser"); 
		Vector <String> value = new Vector <String> ();
		value.add(id);
		bd.findAndSort(action, value, "id", true);
		if(bd.getBookList().size() > 0) return 2;
		return this.dao.deleteUser(id, pw) ? 1 : 0;
	}
}
