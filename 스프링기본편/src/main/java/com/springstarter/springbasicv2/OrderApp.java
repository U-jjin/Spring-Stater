package com.springstarter.springbasicv2;

import com.springstarter.springbasicv2.member.Grade;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import com.springstarter.springbasicv2.order.Order;
import com.springstarter.springbasicv2.order.OrderService;
import com.springstarter.springbasicv2.order.OrderServiceImpl;

import com.springstarter.springbasicv2.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig =new AppConfig();
//        MemberService memberService =appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order =orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order="+order.toString());
    }
}
