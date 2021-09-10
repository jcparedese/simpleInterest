package com.aplazo.interest.simple.controller;

import com.aplazo.interest.simple.controller.dto.SimpleInterestRequest;
import com.aplazo.interest.simple.controller.dto.PaymentResponse;
import com.aplazo.interest.simple.controller.payload.BaseEntityResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SimpleInterest {

    public BaseEntityResponse<List<PaymentResponse>> calculatePayments(SimpleInterestRequest calculateRequest);

    public ResponseEntity<String> healthCheck();
}
