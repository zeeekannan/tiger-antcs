package com.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.service.ParserServiceImpl;

@RestController
@RequestMapping("/api/csv")
public class CSVController {

	private static String TYPE = "text/csv";

	@Autowired
	ParserServiceImpl parserService;

	@Autowired
	Environment environment;

	@PostMapping("/parse")
	public String csvParse(@RequestParam("csvfile") MultipartFile file) {
		String message ="";
		if (TYPE.equals(file.getContentType())) {
			try {
				message = parserService.save(file);
			} catch (Exception e) {
				message = "Parsing failed! please validate the file and retry: " + file.getOriginalFilename() + "!";
			}
		} else {
			message = "Please upload a proper csv file!";
		}
		return message;
	}
}