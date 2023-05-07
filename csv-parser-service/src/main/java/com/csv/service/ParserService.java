package com.csv.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ParserService {
	String save(MultipartFile file) throws IOException;
}
