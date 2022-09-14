package com.springstarter.springbasicv2;

import com.springstarter.springbasicv2.member.Grade;
import com.springstarter.springbasicv2.member.MemberService;
import com.springstarter.springbasicv2.member.MemberServiceImpl;
import com.springstarter.springbasicv2.member.Member;


public class MemberApp {
    //단축키 psvm
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member mem = new Member(1L, "memberA", Grade.VIP);
        memberService.join(mem);

        Member findMember = memberService.findMember(1L);


    }
}
