package com.jozefiak.exchange.repository;

import com.jozefiak.exchange.domain.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepo extends JpaRepository<Info,Long> {

}