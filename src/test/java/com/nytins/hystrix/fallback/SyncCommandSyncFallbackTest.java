package com.nytins.hystrix.fallback;

import static org.hamcrest.CoreMatchers.isA;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class SyncCommandSyncFallbackTest extends AbstractHystrixTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private Service service;

    @Test
    public void test() {
        thrown.expectCause(isA(CommandException.class));
        service.command();
    }

    public static class Service {

        @HystrixCommand(fallbackMethod = "fallback")
        public Object command() {
            throw new CommandException();
        }

        @HystrixCommand
        public Object fallback() {
            throw new FallbackException();
        }
    }
}
