package com.hello.core;

import com.hello.core.member.Member;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BasicTest {

    @Test
    void test() {
        Member member = new Member();
        member.getMember();
    }
    
    static class Member {
        
        private String id;
        private String pw;
        
        public void getMember() {
            System.out.println(this); // Member class 의 인스턴스가 찍힌다.
            System.out.println(this);
        }
        
    }

}
