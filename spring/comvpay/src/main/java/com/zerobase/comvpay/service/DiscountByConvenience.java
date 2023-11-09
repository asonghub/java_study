package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.PayRequest;
import org.springframework.stereotype.Component;

@Component
public class DiscountByConvenience implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        System.out.println("DiscountByConvenience.getDiscountedAmount");
        switch (payRequest.getConvenienceType()){

            case G25 -> {
                return payRequest.getPayAmount() * 8 / 10;
            }
            case GU -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
            case SEVEN -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }

}
