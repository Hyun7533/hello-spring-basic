package com.hello.core.autowired;

import com.hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    @Component
    static class TestBean {
        @Autowired(required = false) // false 옵션을 주면 메서드가 호출이 안된다.
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired // 호출은 된다 하지만 null로 들어옴
        public void setNoBean2(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member3 = " + member3);
        }

    }


}
