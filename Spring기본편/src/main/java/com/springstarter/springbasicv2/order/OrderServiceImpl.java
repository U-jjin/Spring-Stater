package com.springstarter.springbasicv2.order;

import com.springstarter.springbasicv2.annotation.MainDiscountPolicy;
import com.springstarter.springbasicv2.discount.DiscountPolicy;
import com.springstarter.springbasicv2.discount.FixDiscountPolicy;
import com.springstarter.springbasicv2.discount.RateDiscountPolicy;
import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import com.springstarter.springbasicv2.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
   private  final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy){
        this.memberRepository =memberRepository;
        this.discountPolicy =discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.fondById(memberId);
        int discountPrice =discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName, itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
