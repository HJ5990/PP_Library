package com.kh.model.vo;

import java.sql.Date;


public class RentalLog {
	
	private int rNo;
	private Date rrDate; 
	private int mNo;
	private int bNo;
	private String rrCheck;
	
	public RentalLog() {
		super();
	}

	public RentalLog(int rNo, Date rrDate, int mNo, int bNo, String rrCheck) {
		super();
		this.rNo = rNo;
		this.rrDate = rrDate;
		this.mNo = mNo;
		this.bNo = bNo;
		this.rrCheck = rrCheck;
	}
	
	public RentalLog(int mNo, int bNo) {
		super();
		this.mNo = mNo;
		this.bNo = bNo;
	};

	
	
	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public Date getRrDate() {
		return rrDate;
	}

	public void setRrDate(Date rrDate) {
		this.rrDate = rrDate;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getRrCheck() {
		return rrCheck;
	}

	public void setRrCheck(String rrCheck) {
		this.rrCheck = rrCheck;
	}

	@Override
	public String toString() {
		return rNo + "\t" + rrDate + "\t" + mNo + "\t" + bNo + "\t" + rrCheck;
	}
	
	
	

}
