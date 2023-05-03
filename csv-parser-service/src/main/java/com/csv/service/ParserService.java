package com.csv.service;

import org.springframework.web.multipart.MultipartFile;

public interface ParserService {
	void save(MultipartFile file);
}
