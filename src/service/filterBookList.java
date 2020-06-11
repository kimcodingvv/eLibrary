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
		dao.findAndSort("all", "", "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getRentalCntDesc(){
		dao.findAndSort("all", "", "rentCnt", false);
		return dao.getBookList();
	}
}
