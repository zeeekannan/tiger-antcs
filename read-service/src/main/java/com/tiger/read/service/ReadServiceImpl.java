package com.tiger.read.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tiger.read.model.PriceDetail;
import com.tiger.read.model.ReadResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ReadServiceImpl implements ReadService {

	
	@Autowired
	  RestTemplate restTemplate;
	  
	  @Override
	  @CircuitBreaker(name = "dbOperationRemoteCall", fallbackMethod = "dbOpApiFallback")
	  public ReadResponse readAll() throws Exception{
		  ResponseEntity<PriceDetail[]> response =  restTemplate.getForEntity("http://DB-SERVICE/api/db/read-all",PriceDetail[].class);
	      return new ReadResponse("success",Arrays.asList(response.getBody()) );
	  }
	  
	  public ReadResponse dbOpApiFallback(Exception e) {
	      return new ReadResponse("Target db Read Operation Server Looks Down now! , Please try after somtimes", null);
	  }
	  
}
