package com.aplazo.interest.simple.repository.impl;

import com.aplazo.interest.simple.entity.SimpleInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleInterestRepositoryImpl extends JpaRepository<SimpleInterestEntity, Long> {
}
