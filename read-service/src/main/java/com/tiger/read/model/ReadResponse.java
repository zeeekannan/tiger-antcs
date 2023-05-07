package com.tiger.read.model;

import java.util.List;

public class ReadResponse {
	
	private String readStatus;
	private List<PriceDetail> priceDetails;
	
	public ReadResponse(String readStatus, List<PriceDetail> priceDetails) {
		this.readStatus = readStatus;
		this.priceDetails = priceDetails;
	}
	public String getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	public List<PriceDetail> getPriceDetails() {
		return priceDetails;
	}
	public void setPriceDetails(List<PriceDetail> priceDetails) {
		this.priceDetails = priceDetails;
	}
}
