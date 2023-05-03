package com.csv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.model.PriceDetail;

public interface PricingRepository extends JpaRepository<PriceDetail, Long> {

}
