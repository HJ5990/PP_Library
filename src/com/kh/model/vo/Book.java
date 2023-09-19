package com.kh.model.vo;

import java.sql.Date;

public class Book {
	
	private int bNo;
	private int cNo;
	private String bName;
	private String author;
	private Date publishdate;
	private int quantity;
	
	
	public Book() {
		super();
	}

	public Book(int bNo, int cNo, String bName, String author, Date publishdate, int quantity) {
		super();
		this.bNo = bNo;
		this.cNo = cNo;
		this.bName = bName;
		this.author = author;
		this.publishdate = publishdate;
		this.quantity = quantity;
	}

	
	
	
	
	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public String toString() {
		return bNo + "\t" + cNo + "\t" + bName + "\t\t" + author + "\t\t"
				+ publishdate + "\t" + quantity;
	}
	
	
	
	
	
	
	
	
	
	
	

}
