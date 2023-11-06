package com.zerobase.comvpay.service;

import com.zerobase.comvpay.type.CancelPaymentResult;
import com.zerobase.comvpay.type.PayMethodType;
import com.zerobase.comvpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
     PaymentResult payment(Integer payAmount);
     CancelPaymentResult cancelPayment(Integer cancelAmount);
}

//머니어뎁터와 카드어뎁터가 이것을 참조하도록!
