package com.tiger.db.operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiger.db.operation.model.PriceDetail;
import com.tiger.db.operation.repo.DbRepository;


@Service
public class DbServiceImpl implements DbService{
	
	@Autowired
	DbRepository dbRepository;
	
	@Override
	public String writeAll(List<PriceDetail> priceDetails) {
		
		String status = "";
	    try {
	    	dbRepository.saveAll(priceDetails);
	      status = "save completed successfully : ";
	    } catch (Exception e) {
	      status = "exception while saving, fail to store data: " + e.getMessage();
	    }
	    return status;
	  }
		
	}
