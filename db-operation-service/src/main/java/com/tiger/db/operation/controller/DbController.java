package com.tiger.db.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.db.operation.model.PriceDetail;
import com.tiger.db.operation.service.DbServiceImpl;

@RestController
@RequestMapping("/api/db")
public class DbController {
	
	@Autowired
	DbServiceImpl dbService;
	
	@PostMapping(value = "/write")
	public void savePrisingDetails(@RequestBody List<PriceDetail> detailsEntity) {
		dbService.writeAll(detailsEntity);
	}
	
	@GetMapping(value = "/read-all")
	public List<PriceDetail> readAllPrisingDetails() {
		List<PriceDetail> resList = dbService.readAll();
		return resList;
	}
}
