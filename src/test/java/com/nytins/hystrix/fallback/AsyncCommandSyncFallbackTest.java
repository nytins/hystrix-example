package com.nytins.hystrix.fallback;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

public class AsyncCommandSyncFallbackTest extends AbstractHystrixTest {

    @Autowired
    private Service service;

    @Test
    public void test() throws Throwable {
        try {
            service.command().get();
            fail();
        } catch (Throwable e) {
            assertThat(e.getCause().getCause(), is(instanceOf(CommandException.class)));
        }
    }

    public static class Service {
        
        @HystrixCommand(fallbackMethod = "fallback")
        public Future<Object> command() {
            return new AsyncResult<Object>() {

                @Override
                public Object invoke() {
                    throw new CommandException();
                }
            };
        }

        @HystrixCommand
        public Object fallback() {
            throw new FallbackException();
        }
    }
}
