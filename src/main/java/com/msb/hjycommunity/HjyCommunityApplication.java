package com.msb.hjycommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.msb.hjycommunity.**.mapper")
public class HjyCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjyCommunityApplication.class, args);
        System.out.println("何家云后台系统启动成功");
    }

}
