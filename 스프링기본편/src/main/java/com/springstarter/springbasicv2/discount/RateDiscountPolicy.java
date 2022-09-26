package com.springstarter.springbasicv2.discount;

import com.springstarter.springbasicv2.annotation.MainDiscountPolicy;
import com.springstarter.springbasicv2.member.Grade;
import com.springstarter.springbasicv2.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; //10프로 할인

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else{
            return 0;
        }
    }
}
