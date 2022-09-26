package com.springstarter.springbasicv2.scan;

import com.springstarter.springbasicv2.AutoAppConfig;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    public void  basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService orderService =ac.getBean(OrderService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);

    }
}
