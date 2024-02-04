package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 오류 테스트")
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService se = ac.getBean(StatefulService.class);
        StatefulService se2 = ac.getBean(StatefulService.class);

        // A사용자 10000원 주문
        se.order("userA", 10000);
        // B사용자 20000원 주문
        se2.order("userB", 20000);

        // A사용자 주문 금액 조회
        int price = se.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(se.getPrice()).isEqualTo(20000);

    }

    private static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}