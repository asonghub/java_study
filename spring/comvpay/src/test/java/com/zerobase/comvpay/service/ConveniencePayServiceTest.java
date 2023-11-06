package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.PayCancelRequest;
import com.zerobase.comvpay.dto.PayCancelResponse;
import com.zerobase.comvpay.type.ConvenienceType;
import com.zerobase.comvpay.dto.PayRequest;
import com.zerobase.comvpay.dto.PayResponse;
import com.zerobase.comvpay.type.PayCancelResult;
import com.zerobase.comvpay.type.PayMethodType;
import com.zerobase.comvpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();
    @Test
    void pay_success(){
        //given 어떤 데이터가 있을때
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25, 1000);
        //when 어떤 동작을 하면
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        //option cmd v

        //then 결과
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(1000, payResponse.getPaidAmount());

    }

    @Test
    void pay_fail(){
        //given 어떤 데이터가 있을때
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25, 1000_001);
        //when 어떤 동작을 하면
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        //option cmd v

        //then 결과
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());

    }

    @Test
    void pay_cancel_success(){
        //given 어떤 데이터가 있을때
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        //when 어떤 동작을 하면
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        //option cmd v

        //then 결과
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000, payCancelResponse.getPayCanceledAmount());

    }

    @Test
    void pay_cancel_fail(){
        //given 어떤 데이터가 있을때
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,ConvenienceType.G25, 99);

        //when 어떤 동작을 하면
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        //option cmd v

        //then 결과
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayCanceledAmount());

    }


}