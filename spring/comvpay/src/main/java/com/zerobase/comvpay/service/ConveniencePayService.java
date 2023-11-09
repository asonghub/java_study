package com.zerobase.comvpay.service;

import com.zerobase.comvpay.dto.*;
import com.zerobase.comvpay.type.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ConveniencePayService {
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap  =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 @Qualifier("discountByConvenience")
                                 DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(), //키
                        paymentInterface //밸류
                )
        );
        this.discountInterface = discountInterface;
    }

    //    private  final MoneyAdapter moneyAdapter = new MoneyAdapter(); //바꿀 일이 없기 때문에
//    private  final CardAdapter cardAdapter = new CardAdapter();
//    private final  DiscountInterface discountInterface = new DiscountByPayMethod();
//    private final  DiscountInterface discountInterface = new DiscountByConvenience();


    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());
//        if(payRequest.getPayMethodType() == PayMethodType.CARD){
//            paymentInterface = cardAdapter;
//        }else {
//            paymentInterface = moneyAdapter;
//        }

        /*
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;


        //서비스에 이렇게 구체적인 단이 필요하지 않음
        if(payRequest.getPayMethodType() == PayMethodType.CARD){
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());

        }else{
            moneyUseResult =
                    moneyAdapter.use(payRequest.getPayAmount());

        }

        if(cardUseResult == CardUseResult.USE_FAIL ||
                moneyUseResult == MoneyUseResult.USE_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

    */
        // fail fast

        // Exception case1
        // Exception case2
        // Exception case3

        // Success Case(Only one) >>헷갈리지 않게 성공 케이스를 마지막에

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        if(payment == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);


    }

    //결제 취소 요청 -> 응답 반환 타입: 결제 취소 응답으로 받기
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

//        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD){
//            paymentInterface = cardAdapter;
//        }else {
//            paymentInterface = moneyAdapter;
//        }


        //머니어댑터에 요청
//        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());
//
//        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL){
//            return  new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
//        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());
        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
