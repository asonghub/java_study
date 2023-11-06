package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest); //할인할 금액말고 할인된 금액으로 좀더 단순하게 전달하게
}
