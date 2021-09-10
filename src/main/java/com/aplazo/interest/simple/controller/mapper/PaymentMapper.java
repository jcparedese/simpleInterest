package com.aplazo.interest.simple.controller.mapper;

import com.aplazo.interest.simple.controller.dto.PaymentResponse;
import com.aplazo.interest.simple.entity.PaymentEntity;

public class PaymentMapper {

    public static PaymentResponse toResponse(PaymentEntity paymentEntity){
        PaymentResponse response = new PaymentResponse();
        response.setAmount(paymentEntity.getAmount());
        response.setPaymentNumber(paymentEntity.getPaymentNumber());
        response.setDate(paymentEntity.getDate());
        return response;
    }

    public static PaymentEntity toEntity(PaymentResponse paymentResponse){
        PaymentEntity response = new PaymentEntity();
        response.setAmount(paymentResponse.getAmount());
        response.setPaymentNumber(paymentResponse.getPaymentNumber());
        response.setDate(paymentResponse.getDate());
        return response;
    }
}
