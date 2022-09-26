package com.springstarter.springbasicv2.singleton;

import com.springstarter.springbasicv2.AppConfig;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1= appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //참조 값이 다르다
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest(){
        //private으로 생성자를 막아두어서,
        //new SingletoneService(); 불가능

        //1. 조회 : 호출할 떄 마다 같은 객체를 반환
        SingletonService singletonService1 =SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조 값이 같은 것을 확인
        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회: 호출할 때 마다 같은 객체를 반환.
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //참조 값이 같은지 확인
        assertThat(memberService1).isSameAs(memberService2);
    }
}

