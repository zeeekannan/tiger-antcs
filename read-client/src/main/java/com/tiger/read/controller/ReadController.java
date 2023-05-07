package com.tiger.read.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.read.model.ReadResponse;
import com.tiger.read.service.ReadService;

@RestController
@RequestMapping("/api/read/")
public class ReadController {
	
	@Autowired
	ReadService readService;
	
	@GetMapping("/fetch-all")
	public ReadResponse readAll() throws Exception {
		return readService.readAll();
	}
	
}
