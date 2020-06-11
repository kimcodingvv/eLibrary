package service;

import java.util.Vector;
import dao.BookInfoDao;
import model.BookInfo;

public class filterBookList {
	private BookInfoDao dao;
	
	public filterBookList() {
		dao = new BookInfoDao();
	}
	
	public Vector <BookInfo> getAll(){
		return dao.getBookList("all", "");
	}
}
