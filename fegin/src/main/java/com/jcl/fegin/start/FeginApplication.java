package com.jcl.fegin.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value="com.jcl.*")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = {"com.jcl.fegin.facade.stub"})
public class FeginApplication {


    public static void main(String[] args) {

        SpringApplication.run(FeginApplication.class, args);

    }


    

}