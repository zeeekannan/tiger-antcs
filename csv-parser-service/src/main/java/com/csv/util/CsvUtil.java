package com.csv.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.csv.model.PriceDetail;

public class CsvUtil {
	
	public static List<PriceDetail> csvToPriceDetails(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	    		CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<PriceDetail> priceDetails = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	    	  PriceDetail PriceDetail = new PriceDetail(
	              Long.parseLong(csvRecord.get("store_id")),
	              csvRecord.get("sku"),
	              csvRecord.get("productName"),
	              Integer.parseInt(csvRecord.get("price")),
	              csvRecord.get("date")
	            );

	        priceDetails.add(PriceDetail);
	      }

	      return priceDetails;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
}
