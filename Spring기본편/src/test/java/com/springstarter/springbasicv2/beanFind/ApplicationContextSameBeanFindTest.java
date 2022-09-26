package com.springstarter.springbasicv2.beanFind;

import com.springstarter.springbasicv2.AppConfig;
import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이면, 중복 오류가 발생")
    public void findBeanByTypeDuplicate(){

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class ,()-> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    public void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);

    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    public void findAllbeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String s : beansOfType.keySet()) {

            System.out.println("key = "+s+" value="+beansOfType.get(s));

        }
        System.out.println("beansOftype="+beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);

    }

    @Configuration
    static  class SameBeanCOnfig{
        @Bean
        public MemberRepository memberRepositroy1(){
            return  new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepositroy2(){
            return  new MemoryMemberRepository();
        }
    }


}
