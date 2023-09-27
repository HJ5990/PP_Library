package com.kh.model.vo;

import java.sql.Date;

public class Book {
	
	private int bNo;
	private String cName;
	private String bName;
	private String author;
	private Date publishdate;
	private int quantity;
	
	
	public Book() {
		super();
	}

	public Book(int bNo, String cName, String bName, String author, Date publishdate, int quantity) {
		super();
		this.bNo = bNo;
		this.cName = cName;
		this.bName = bName;
		this.author = author;
		this.publishdate = publishdate;
		this.quantity = quantity;
	}

	
	
	public Book(int bNo, String cName, String bName, String author, Date publishdate) {
		super();
		this.bNo = bNo;
		this.cName = cName;
		this.bName = bName;
		this.author = author;
		this.publishdate = publishdate;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getcNo() {
		return cName;
	}

	public void setcNo(String cName) {
		this.cName = cName;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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
		return bNo + "\t" + cName + "\t" + String.format("%-15s", bName) + "\t" + 
				String.format("%-10s", author) + "\t" + publishdate + "\t" + quantity;
	}
	
	
	
	
	
	
	
	
	
	
	

}
