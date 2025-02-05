package com.hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈떄문에 ConcurrentHashMap을 사용해야한다.
//    private static Map<Long, Member> store2 = new ConcurrentHashMap<>(); // 동시성 이슈떄문에 ConcurrentHashMap을 사용해야한다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
