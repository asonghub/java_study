package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.PayRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DiscountByPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        System.out.println("DiscountByPayMethod.getDiscountedAmount");
        switch (payRequest.getPayMethodType()){

            case MONEY -> {
                return payRequest.getPayAmount() * 7 / 10 ;
            }
            case CARD -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
