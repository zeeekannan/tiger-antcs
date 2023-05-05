package com.csv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.csv.model.PriceDetail;
import com.csv.repo.PricingRepository;
import com.csv.util.CsvUtil;

@Service
public class ParserServiceImpl implements ParserService{
  
  @Autowired
  PricingRepository repository;
  
  @Autowired
  RestTemplate restTemplate;
  
  @Override
  public String save(MultipartFile file) {
	String status ="";
    try {
      List<PriceDetail> priceDetails = CsvUtil.csvToPriceDetails(file.getInputStream());
      //repository.saveAll(priceDetails);
      
     // RestTemplate restTemplate = new RestTemplate();
	//	HttpEntity<List<PriceDetail>> entity = new HttpEntity<List<PriceDetail>>(priceDetails);
		
     // resEntity = restTemplate.postForEntity("http://localhost:9090/db/operation/write", entity, String.class);
		
		String rara = restTemplate.postForObject("http://DB-SERVICE/db/operation/write".trim(), priceDetails, String.class);
   //   status = "opration status" + resEntity.getStatusCode();
    } catch (Exception e) {
    	e.printStackTrace();
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
    return status;
  }
}
