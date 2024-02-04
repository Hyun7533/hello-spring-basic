package com.hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SingletonTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance = " + instance);
        System.out.println("instance2 = " + instance2);

        assertThat(instance).isSameAs(instance2);

        // 스프링 컨테이너가 싱글톤으로 모두 만들어준다..... 와우
        // 스프링 컨테이너는 싱글톤패턴의 문제점을 해결해준다... 와와우
        // 스프링 빈이 바로 싱글톤으로 관리되는 빈(객체)이다.

        System.out.println("instance2 = " + instance2);
        System.out.println("instance = " + instance);
        instance.login();
        instance2.login();

    }
}
