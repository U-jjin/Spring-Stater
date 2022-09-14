package com.springstarter.springbasicv2.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);

    }

    @Override
    public Member fondById(Long memberId) {
        return store.get(memberId);
    }
}
