package model;

public class BookInfo {
	private int id;
	private String title;
	private String author;
	private int price;
	private boolean rental;
	private int rentalCnt;
	
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
	public boolean getRental() {
		return this.rental;
	}
	public void setRental(boolean x) {
		this.rental = x;
	}
	public int getRentalCnt() {
		return this.rentalCnt;
	}
	public void setRentalCnt(int x) {
		this.rentalCnt = x;
	}
}
