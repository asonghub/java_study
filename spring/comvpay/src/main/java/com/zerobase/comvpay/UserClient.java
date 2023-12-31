package com.zerobase.comvpay;

import com.zerobase.comvpay.config.ApplicationConfig;
import com.zerobase.comvpay.dto.PayCancelRequest;
import com.zerobase.comvpay.dto.PayCancelResponse;
import com.zerobase.comvpay.dto.PayRequest;
import com.zerobase.comvpay.dto.PayResponse;
import com.zerobase.comvpay.service.ConveniencePayService;
import com.zerobase.comvpay.type.ConvenienceType;
import com.zerobase.comvpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // `사용자` -> 편결이 -> 머니

//        ApplicationConfig applicationConfig = new ApplicationConfig();
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
//                new ClassPathXmlApplicationContext("spring-config.xml");

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService", ConveniencePayService.class);

        // ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountPayMethod();

        // G25, 결제 1000원
        PayRequest payRequest =new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // G25, 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.CARD, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);


    }
}
