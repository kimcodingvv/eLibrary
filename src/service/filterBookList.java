package service;

import java.io.UnsupportedEncodingException;
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
	
	public Vector <BookInfo> getRentCntDesc(){
		dao.findAndSort("all", "", "rentCnt", false);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getYesRent(){
		dao.findAndSort("rent", "1", "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getNoRent(){
		dao.findAndSort("rent", "0", "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getSearch(String column, String value) throws UnsupportedEncodingException{
		dao.searchBook(column, value);
		return dao.getBookList();
	}
}
