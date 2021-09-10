package com.aplazo.interest.simple.service;

import com.aplazo.interest.simple.controller.dto.SimpleInterestRequest;
import com.aplazo.interest.simple.controller.dto.PaymentResponse;

import java.util.List;

public interface InterestCalculatorService {

    public List<PaymentResponse> calculateInterest(SimpleInterestRequest calculateRequest);
}
