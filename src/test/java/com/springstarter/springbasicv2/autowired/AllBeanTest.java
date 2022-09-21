package com.springstarter.springbasicv2.autowired;

import com.springstarter.springbasicv2.AutoAppConfig;
import com.springstarter.springbasicv2.discount.DiscountPolicy;
import com.springstarter.springbasicv2.member.Grade;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.springstarter.springbasicv2.member.Member;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {


    @Test
    public void findAllBean(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService =  ac.getBean(DiscountService.class);

        Member member =new Member(1L, "userA", Grade.VIP);
        int discountPrice =discountService.discount(member,1000,"fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

    }
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        public final List<DiscountPolicy> policyList;


        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap ="+policyMap);
            System.out.println("policyList ="+policyList);
        }
        public int discount(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy =policyMap.get(discountCode);


            System.out.println("discountCode ="+discountCode);
            System.out.println("discountPolicy ="+discountPolicy);

            return discountPolicy.discount(member,price);
        }
    }
}


