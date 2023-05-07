package com.tiger.db.operation.service;

import java.util.List;

import com.tiger.db.operation.model.PriceDetail;

public interface DbService {
	public void writeAll(List<PriceDetail> priceDetails);
	public List<PriceDetail> readAll();
}
