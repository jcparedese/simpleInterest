package com.aplazo.interest.simple.repository.impl;

import com.aplazo.interest.simple.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositoryImpl extends JpaRepository<PaymentEntity, Long>{
}
