package com.kh.model.vo;

import java.sql.Date;


public class RentalLog {
	
	private int rNo;
	private Date renDate; 
	private int mNo;
	private int bNo;
	private String rrCheck;
	private Date retDate; 
	private String bName;
	
	public RentalLog() {
		super();
	}

	public RentalLog(int rNo, Date renDate, int mNo, int bNo, String rrCheck) {
		super();
		this.rNo = rNo;
		this.renDate = renDate;
		this.mNo = mNo;
		this.bNo = bNo;
		this.rrCheck = rrCheck;
	}
	
	public RentalLog(int mNo, int bNo) {
		super();
		this.mNo = mNo;
		this.bNo = bNo;
	};
	

	public RentalLog(int rNo, Date renDate, String bName) {
		super();
		this.rNo = rNo;
		this.renDate = renDate;
		this.bName = bName;
	}
	
	

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public Date getRenDate() {
		return renDate;
	}

	public void setRrDate(Date renDate) {
		this.renDate = renDate;
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
	
	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}
	
	public Date getRetDate() {
		return retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}



	@Override
	public String toString() {
		return rNo + "\t" + renDate + "\t" + mNo + "\t" + bNo + "\t" + rrCheck + "\t" + retDate;
	}
	
	
	

}
