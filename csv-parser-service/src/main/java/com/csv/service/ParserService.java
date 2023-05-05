package com.csv.service;

import org.springframework.web.multipart.MultipartFile;

public interface ParserService {
	String save(MultipartFile file);
}
