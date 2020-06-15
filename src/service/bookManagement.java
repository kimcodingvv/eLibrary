package service;

import java.util.Vector;

import dao.BookInfoDao;
import model.BookInfo;

public class bookManagement {
	
	BookInfoDao dao;
	
	public bookManagement() {
		dao = new BookInfoDao();
	}
	
	public boolean rentBook(String id, String user) {
		Vector <String> action = new Vector <String> ();
		action.add("id"); 
		Vector <String> value = new Vector <String> ();
		value.add(id);
		dao.findAndSort(action, value, "id", true);
		if(dao.getBookList().size() == 0) return false;
		BookInfo book = dao.getBookList().get(0);
		if(book.getRent()) return false;
		return dao.rentToggle(id, user);
	}
	
	public void returnBook(String id) {
		Vector <String> action = new Vector <String> ();
		action.add("id"); 
		Vector <String> value = new Vector <String> ();
		value.add(id);
		dao.findAndSort(action, value, "id", true);
		dao.rentToggle(id, "");
	}
	
	public boolean addBook(String id, String title, String author, String price) {
		return dao.addBook(id, title, author, price);
	}
	
	public boolean deleteBook(String id) {
		return dao.deleteBook(id);
	}
}