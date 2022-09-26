package com.springstarter.springbasicv2.discount;

import com.springstarter.springbasicv2.member.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.springstarter.springbasicv2.member.Member;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy =new RateDiscountPolicy();


    //성공테스트
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount() {

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    //실패테스트
    @Test
    @DisplayName("VIP는 10% 할인이 적용되지 않아야 한다.")
    void discountFail() {

        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

}