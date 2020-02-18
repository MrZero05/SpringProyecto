package com.ecommerce.main.dao;

import java.util.List;

public class PdfBillData {
	
	private String id;
	private String date;
	private String state;
	private String userName;
	private String total;
	private List<PdfBillDetail> det;
	
	public PdfBillData(String id, String date, String state, String userName, String total) {
		super();
		this.id = id;
		this.date = date;
		this.state = state;
		this.userName = userName;
		this.total = total;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public List<PdfBillDetail> getDet() {
		return det;
	}

	public void setDet(List<PdfBillDetail> det) {
		this.det = det;
	}
	
}
