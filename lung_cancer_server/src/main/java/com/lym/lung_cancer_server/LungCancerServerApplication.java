package com.lym.lung_cancer_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.lym.lung_cancer_server.mapper")
@SpringBootApplication
public class LungCancerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LungCancerServerApplication.class, args);
    }

}
