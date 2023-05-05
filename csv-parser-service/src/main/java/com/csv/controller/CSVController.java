package com.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csv.service.ParserServiceImpl;

@Controller
@RequestMapping("/api/csv")
public class CSVController {

	private static String TYPE = "text/csv";
	private String message = "";

	@Autowired
	ParserServiceImpl parserService;

	@Autowired
	Environment environment;

	@PostMapping("/parse")
	public String csvParse(@RequestParam("csvfile") MultipartFile file) {
		if (TYPE.equals(file.getContentType())) {
			String status = "";
			try {
				status = parserService.save(file);
				message = status + file.getOriginalFilename();
			} catch (Exception e) {
				e.printStackTrace();
				message = "parse failed please validate the file and retry: " + file.getOriginalFilename() + "!";
			}
		} else {
			message = "Please upload a csv file!";
		}
		return message;
	}
}