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
		Vector <String> action = new Vector <String> ();
		action.add("all");
		Vector <String> value = new Vector <String> ();
		dao.findAndSort(action, value, "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getRentCntDesc(){
		Vector <String> action = new Vector <String> ();
		action.add("all");
		Vector <String> value = new Vector <String> ();
		dao.findAndSort(action, value, "rentCnt", false);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getYesRent(String user){
		Vector <String> action = new Vector <String> ();
		action.add("rent"); 
		Vector <String> value = new Vector <String> ();
		value.add("1");
		if(user != null) {
			action.add("rentUser");
			value.add(user);
		}
		dao.findAndSort(action, value, "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getNoRent(){
		Vector <String> action = new Vector <String> ();
		action.add("rent");
		Vector <String> value = new Vector <String> ();
		value.add("0");
		dao.findAndSort(action, value, "id", true);
		return dao.getBookList();
	}
	
	public Vector <BookInfo> getSearch(String column, String value) throws UnsupportedEncodingException{
		dao.searchBook(column, value);
		return dao.getBookList();
	}
}
