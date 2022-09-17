package com.springstarter.springbasicv2;

import com.springstarter.springbasicv2.member.Grade;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import com.springstarter.springbasicv2.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    //단축키 psvm
    public static void main(String[] args) {
//        MemberService memberService = new AppConfig().memberService();

        //AppConfig에 있는 환경설정 가지고, 스프링 컨테이너가 생성된다.
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member mem = new Member(1L, "memberA", Grade.VIP);
        memberService.join(mem);

        Member findMember = memberService.findMember(1L);


    }
}
