package com.springstarter.springbasicv2.singleton;

import com.springstarter.springbasicv2.AppConfig;
import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import com.springstarter.springbasicv2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {


    @Test
    void configurationTest(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

        //모두 같은 인스턴스를 참고 하고 있나
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    public void configurationDeep(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

        //AppConfig도 스프링 빈으로 등록된다.
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean ="+bean.getClass());
    }


}

