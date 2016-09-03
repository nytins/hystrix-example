package com.nytins.hystrix.fallback;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.nytins.hystrix.fallback.SyncCommandSyncFallbackTest.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SuppressWarnings("serial")
public abstract class AbstractHystrixTest {

    static class CommandException extends RuntimeException {}
    static class FallbackException extends RuntimeException {}

    @Configuration
    @EnableAspectJAutoProxy
    static class Config {

        @Bean
        public HystrixCommandAspect hystrixAspect() {
            return new HystrixCommandAspect();
        }

        @Bean
        public Service service() {
            return new Service();
        }
    }

}
