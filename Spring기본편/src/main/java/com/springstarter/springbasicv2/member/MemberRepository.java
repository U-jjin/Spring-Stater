package com.springstarter.springbasicv2.member;

public interface MemberRepository {
        void save(Member member);
        Member fondById(Long memberId);

}

