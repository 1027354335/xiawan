package com.xtoken.gradetoken;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xtoken.gradetoken.mapper")
public class GradetokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradetokenApplication.class, args);
    }

}
