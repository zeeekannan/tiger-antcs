package com.csv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csv.model.PriceDetail;
import com.csv.repo.PricingRepository;
import com.csv.util.CsvUtil;

@Service
public class ParserServiceImpl implements ParserService{
  @Autowired
  PricingRepository repository;

@Override
 public void save(MultipartFile file) {
    try {
      List<PriceDetail> priceDetails = CsvUtil.csvToPriceDetails(file.getInputStream());
      repository.saveAll(priceDetails);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
}
