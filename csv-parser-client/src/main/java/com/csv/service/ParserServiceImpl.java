package com.csv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.csv.model.PriceDetail;
import com.csv.util.CsvUtil;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ParserServiceImpl implements ParserService{
  
  
  @Autowired
  RestTemplate restTemplate;
  
  @Override
  @CircuitBreaker(name = "dbOperationRemoteCall", fallbackMethod = "dbOpApiFallback")
  public String save(MultipartFile file) throws IOException {
	  List<PriceDetail> priceDetails = CsvUtil.csvToPriceDetails(file.getInputStream());
      HttpEntity<List<PriceDetail>> entity = new HttpEntity<List<PriceDetail>>(priceDetails);
      restTemplate.postForEntity("http://DB-SERVICE/api/db/write", entity, String.class);
      return "DB insert operation success for the file : " + file.getOriginalFilename();

  }
  
  public String dbOpApiFallback(Exception e) {
	return "Target db Write Operation Server Looks Down now! , Please try after somtimes";
  }
}
