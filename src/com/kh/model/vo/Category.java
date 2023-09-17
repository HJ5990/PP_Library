package com.kh.model.vo;

public class Category {
	
	private int cNo;
	private String cName;
	
	
	public Category() {
		super();
	}
	public Category(int cNo, String cName) {
		super();
		this.cNo = cNo;
		this.cName = cName;
	}
	
	
	
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	@Override
	public String toString() {
		return cNo + " : " + cName;
	}
	
	
	
	
	
	
	

}
