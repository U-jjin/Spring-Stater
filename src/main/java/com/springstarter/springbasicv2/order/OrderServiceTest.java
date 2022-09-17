package com.springstarter.springbasicv2.order;

import com.springstarter.springbasicv2.AppConfig;
import com.springstarter.springbasicv2.member.Grade;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.springstarter.springbasicv2.member.Member;
import org.junit.jupiter.api.BeforeEach;


public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig =new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);

        Order order =orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
