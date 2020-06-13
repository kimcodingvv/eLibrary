package service;

import dao.BookInfoDao;
import model.BookInfo;

public class bookManagement {
	
	BookInfoDao dao;
	
	public bookManagement() {
		dao = new BookInfoDao();
	}
	
	public boolean rentBook(String id) {
		dao.findAndSort("id", id, "id", true);
		if(dao.getBookList().size() == 0) return false;
		BookInfo book = dao.getBookList().get(0);
		if(book.getRent()) return false;
		book.setRentCnt(book.getRentCnt() + 1);
		return dao.rentToggle(id);
	}
	
	public void returnBook(String id) {
		dao.findAndSort("id", id, "id", true);
		dao.rentToggle(id);
	}
}