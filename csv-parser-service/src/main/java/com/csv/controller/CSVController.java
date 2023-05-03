package com.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csv.model.ServiceResponse;
import com.csv.service.ParserServiceImpl;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/csv")
public class CSVController {
	
	private static String TYPE = "text/csv";
	private String message ="";
	
	@Autowired
	ParserServiceImpl parserService;

	@PostMapping("/parse")
	public ResponseEntity<ServiceResponse> csvParse(@RequestParam("csvfile") MultipartFile file){
		if (TYPE.equals(file.getContentType())) {
			try {
		        parserService.save(file);
		        message = "csv parsing completed successfully: " + file.getOriginalFilename();
		        return ResponseEntity.status(HttpStatus.OK).body(new ServiceResponse(message));
		      } catch (Exception e) {
		    	  e.printStackTrace();
		        message = "parse failed please validate the file and retry: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ServiceResponse(message));
		      }
		    }
		    message = "Please upload a csv file!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceResponse(message));
		    }
	}