package com.springstarter.springbasicv2.beanFind;

import com.springstarter.springbasicv2.AppConfig;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름으로 조회")
    public void findApplicationBean() {
        MemberService memberService =ac.getBean("memberService",MemberService.class);
        System.out.println("memberService = "+ memberService);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름없이 타입으로 조회")
    public void findApplicationBean2() {
        MemberService memberService =ac.getBean(MemberService.class);
        System.out.println("memberService = "+ memberService);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findApplicationBean3() {
        MemberService memberService =ac.getBean("memberService",MemberServiceImpl.class);
        System.out.println("memberService = "+ memberService);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    public void findApplicationBean4() {
        //ac.getBean("xxxx", MemberService.class);
        //예외 터질 때 테스트 코드 검증은, 해당 함수 사용
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxx",MemberService.class));
    }
}
