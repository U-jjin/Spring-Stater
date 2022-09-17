package com.springstarter.springbasicv2.order;

import com.springstarter.springbasicv2.discount.DiscountPolicy;
import com.springstarter.springbasicv2.discount.FixDiscountPolicy;
import com.springstarter.springbasicv2.discount.RateDiscountPolicy;
import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import com.springstarter.springbasicv2.member.Member;


public class OrderServiceImpl implements OrderService {
   private  final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.fondById(memberId);
        int discountPrice =discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName, itemPrice,discountPrice);
    }
}
