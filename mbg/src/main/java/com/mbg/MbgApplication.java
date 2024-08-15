package com.mbg;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(value = "com.mbg.mapper")
@ComponentScan(value="com.mbg")
public class MbgApplication {
    public static void main(String[] args) {
        SpringApplication.run(MbgApplication.class, args);
    }
}
