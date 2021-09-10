package com.aplazo.interest.simple.service.impl;

import com.aplazo.interest.simple.controller.dto.SimpleInterestRequest;
import com.aplazo.interest.simple.controller.dto.PaymentResponse;
import com.aplazo.interest.simple.controller.mapper.PaymentMapper;
import com.aplazo.interest.simple.controller.mapper.SimpleInterestMapper;
import com.aplazo.interest.simple.entity.PaymentEntity;
import com.aplazo.interest.simple.entity.SimpleInterestEntity;
import com.aplazo.interest.simple.repository.impl.PaymentRepositoryImpl;
import com.aplazo.interest.simple.repository.impl.SimpleInterestRepositoryImpl;
import com.aplazo.interest.simple.service.InterestCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InterestCalculatorServiceImpl implements InterestCalculatorService {

    @Autowired
    private SimpleInterestRepositoryImpl simpleInterestRepository;

    @Autowired
    private PaymentRepositoryImpl paymentRepository;

    @Override
    public List<PaymentResponse> calculateInterest(SimpleInterestRequest calculateRequest) {
        List<PaymentResponse> response = new ArrayList<>();
        List<PaymentEntity> payments = calculatePayments(SimpleInterestMapper.toEntity(calculateRequest));
        for(PaymentEntity payment : payments){
            response.add(PaymentMapper.toResponse(payment));
        }
        return response;
    }


    private List<PaymentEntity> calculatePayments(SimpleInterestEntity simpleInterest){
        PaymentEntity payment = new PaymentEntity();
        Double amount = (simpleInterest.getAmount() + ((simpleInterest.getRate() * 0.01)*simpleInterest.getAmount())) / simpleInterest.getTerms();
        List<PaymentEntity> payments = new ArrayList<>();
        payments = generatePayments(amount, simpleInterest.getTerms());
        saveSimpleInterest(simpleInterest);
        savePayment(payments);
        return payments;
    }

    private List<PaymentEntity> generatePayments(Double amount, Integer terms){
        List<PaymentEntity> payments = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for(int paymentNumber = 1; paymentNumber <=terms; paymentNumber++ ){
            date = date.plusWeeks(1);
            PaymentEntity payment = new PaymentEntity();
            payment.setAmount(amount);
            payment.setPaymentNumber(paymentNumber);
            payment.setDate(date);
            payments.add(payment);

        }
        return payments;
    }

    private void saveSimpleInterest(SimpleInterestEntity simpleInterest){
        simpleInterestRepository.save(simpleInterest);
    }

    private void savePayment(List<PaymentEntity> payment){
        paymentRepository.saveAll(payment);
    }
}
