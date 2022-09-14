package com.springstarter.springbasicv2.order;

import com.springstarter.springbasicv2.discount.DiscountPolicy;
import com.springstarter.springbasicv2.discount.FixDiscountPolicy;
import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import com.springstarter.springbasicv2.member.Member;


public class OrderServiceImpl implements OrderService {
   private final MemberRepository memberRepository = new MemoryMemberRepository();
   private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.fondById(memberId);
        int discountPrice =discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName, itemPrice,discountPrice);
    }
}
