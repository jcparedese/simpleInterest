package com.aplazo.interest.simple.controller.impl;

import com.aplazo.interest.simple.controller.SimpleInterest;
import com.aplazo.interest.simple.controller.dto.SimpleInterestRequest;
import com.aplazo.interest.simple.controller.dto.PaymentResponse;
import com.aplazo.interest.simple.controller.payload.BaseEntityResponse;
import com.aplazo.interest.simple.service.InterestCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interest")
public class SimpleInterestImpl implements SimpleInterest {

    @Autowired
    private InterestCalculatorService interestCalculatorService;

    @PostMapping("")
    public BaseEntityResponse<List<PaymentResponse>> calculatePayments(@RequestBody SimpleInterestRequest calculateRequest) {
        List<PaymentResponse> payments = interestCalculatorService.calculateInterest(calculateRequest);
        return new BaseEntityResponse<>(payments);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<String>(
                "I'm Alive! ",
                HttpStatus.OK);
    }
}
