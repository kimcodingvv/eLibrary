package model;

public class BookInfo {
	private int id;
	private String title;
	private String author;
	private int price;
	private boolean rent;
	private int rentCnt;
	private String rentUser;
	
	public String getRentUser() {
		return rentUser;
	}
	public void setRentUser(String rentUser) {
		this.rentUser = rentUser;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int x) {
		this.id = x;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String x) {
		this.title = x;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String x) {
		this.author = x;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int x) {
		this.price = x;
	}
	public boolean getRent() {
		return this.rent;
	}
	public void setRent(boolean x) {
		this.rent = x;
	}
	public int getRentCnt() {
		return this.rentCnt;
	}
	public void setRentCnt(int x) {
		this.rentCnt = x;
	}
}
