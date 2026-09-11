package com.msb.hjycommunity.log;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogDemo {
    private static final Logger log = LoggerFactory.getLogger(LogDemo.class);

    @Test
    public void test1(){
        Logger logger = LoggerFactory.getLogger(LogDemo.class);
        logger.trace("trace");
        logger.info("hello LogBack!!");
        logger.debug("debuggg");
        logger.warn("hhhhh");
        logger.error("程序中断了需要立即处理");

    }

    @Test
    public void test2(){
        log.trace("");
    }



}
