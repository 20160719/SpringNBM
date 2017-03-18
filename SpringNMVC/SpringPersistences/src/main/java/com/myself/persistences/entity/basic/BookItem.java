package com.myself.persistences.entity.basic;

public class BookItem extends Book {

	private String bookItemId;
	
	private String bookItemIsBorrow;

	public String getBookItemId() {
		return bookItemId;
	}

	public void setBookItemId(String bookItemId) {
		this.bookItemId = bookItemId;
	}

	public String getBookItemIsBorrow() {
		return bookItemIsBorrow;
	}

}
