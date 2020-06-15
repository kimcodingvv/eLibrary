package service;

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
}
