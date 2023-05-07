package com.tiger.read.model;

public class PriceDetail {
	
	private Long store_id;
	private String sKU;
	private String productName;
	private Integer price;
	private String date;
	
	public PriceDetail() {
	}

	public PriceDetail(Long store_id, String sKU, String productName, Integer price, String date) {
		this.store_id = store_id;
		this.sKU = sKU;
		this.productName = productName;
		this.price = price;
		this.date = date;
	}
	
	public Long getStore_id() {
		return store_id;
	}
	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}
	public String getSKU() {
		return sKU;
	}
	public void setSKU(String sKU) {
		this.sKU = sKU;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
