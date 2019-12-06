package com.cts.Entity;

import javax.persistence.Entity;

@Entity
public class Book {
	
	private String bookCode;
	private String bookName;
	private String bookType;
	private String price; 
	private String description;
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Book() {
		super();
	}
	public Book(String bookCode, String bookName, String bookType, String price, String description) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookType = bookType;
		this.price = price;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", bookType=" + bookType + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
	

}
