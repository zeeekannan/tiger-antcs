package com.tiger.db.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.db.operation.model.PriceDetail;
import com.tiger.db.operation.repo.DbRepository;

@Service
public class DbServiceImpl implements DbService {

	@Autowired
	DbRepository dbRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void writeAll(List<PriceDetail> priceDetails) {
		dbRepository.saveAll(priceDetails);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<PriceDetail> readAll() {
		return dbRepository.findAll();
	}

}
