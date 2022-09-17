package com.springstarter.springbasicv2;

import com.springstarter.springbasicv2.discount.DiscountPolicy;
import com.springstarter.springbasicv2.discount.FixDiscountPolicy;
import com.springstarter.springbasicv2.discount.RateDiscountPolicy;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import com.springstarter.springbasicv2.order.OrderService;
import com.springstarter.springbasicv2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return  new MemberServiceImpl(memberRepository());
    }

    //해당 메소드 ctrl + alt + m
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
