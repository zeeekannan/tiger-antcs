package com.tiger.db.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiger.db.operation.model.PriceDetail;
import com.tiger.db.operation.service.DbServiceImpl;

@Controller
@RequestMapping("/db/operation")
public class DbController {
	
	@Autowired
	DbServiceImpl dbService;
	
	/*
	 * @PostMapping("/write") public String savePrisingDetails(@RequestBody
	 * HttpEntity<List<PriceDetail>> detailsEntity) { return
	 * dbService.writeAll(detailsEntity.getBody()); }
	 */
	
	@PostMapping("/write")
	public String savePrisingDetails(@RequestBody List<PriceDetail> detailsEntity) {
		return dbService.writeAll(detailsEntity);
	}
}
