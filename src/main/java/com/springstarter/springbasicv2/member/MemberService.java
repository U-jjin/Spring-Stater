package com.springstarter.springbasicv2.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}

