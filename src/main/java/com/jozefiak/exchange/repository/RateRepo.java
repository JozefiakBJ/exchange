package com.jozefiak.exchange.repository;

import com.jozefiak.exchange.domain.model.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepo extends JpaRepository<Rate,Long> {
    Rate findByCode(String Code);


}