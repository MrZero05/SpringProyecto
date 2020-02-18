package com.ecommerce.main.dao;

public class PdfBillDetail {
	
	private String prodId;
	private String prodName;
	private String prodQty;
	private String unitPrice;
	private String TotalPrice;
	
	
	public PdfBillDetail(String prodId, String prodName, String prodQty, String unitPrice, String totalPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodQty = prodQty;
		this.unitPrice = unitPrice;
		TotalPrice = totalPrice;
	}
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdQty() {
		return prodQty;
	}
	public void setProdQty(String prodQty) {
		this.prodQty = prodQty;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	
	

}
