package com.aplazo.interest.simple.controller.mapper;

import com.aplazo.interest.simple.controller.dto.SimpleInterestRequest;
import com.aplazo.interest.simple.entity.SimpleInterestEntity;

public class SimpleInterestMapper {

    public static SimpleInterestRequest toRequest(SimpleInterestEntity simpleInterestEntity){
        SimpleInterestRequest response = new SimpleInterestRequest();
        response.setAmount(simpleInterestEntity.getAmount());
        response.setRate(simpleInterestEntity.getAmount());
        response.setTerms(simpleInterestEntity.getTerms());
        return response;
    }

    public static SimpleInterestEntity toEntity(SimpleInterestRequest simpleInterestRequest){
        SimpleInterestEntity response = new SimpleInterestEntity();
        response.setAmount(simpleInterestRequest.getAmount());
        response.setRate(simpleInterestRequest.getRate());
        response.setTerms(simpleInterestRequest.getTerms());
        return response;
    }

}
