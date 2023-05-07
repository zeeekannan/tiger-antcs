package com.tiger.db.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiger.db.operation.model.PriceDetail;
import com.tiger.db.operation.repo.DbRepository;

@Service
public class DbServiceImpl implements DbService {

	@Autowired
	DbRepository dbRepository;

	@Override
	public void writeAll(List<PriceDetail> priceDetails) {
		dbRepository.saveAll(priceDetails);
	}

	@Override
	public List<PriceDetail> readAll() {
		return dbRepository.findAll();
	}

}
