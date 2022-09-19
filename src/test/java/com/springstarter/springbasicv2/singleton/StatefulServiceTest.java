package com.springstarter.springbasicv2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 =ac.getBean(StatefulService.class);
        StatefulService statefulService2 =ac.getBean(StatefulService.class);


        //ThreadA : A 사용자 10000원 주문
        statefulService1.order("userA",10000);
        //ThreadA : B 사용자 10000원 주문
        statefulService1.order("userB",20000);

        //ThreadA: 사용자A  주믄 금액 조회
        int price = statefulService1.getPrice();
        Assertions.assertThat(price).isEqualTo(10000); //실패

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}