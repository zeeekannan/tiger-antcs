package com.tiger.db.operation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiger.db.operation.model.PriceDetail;

public interface DbRepository extends JpaRepository<PriceDetail, Long>{}