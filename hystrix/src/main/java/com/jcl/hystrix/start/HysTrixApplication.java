package com.jcl.hystrix.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value="com.jcl.*")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = {"com.jcl.hystrix.facade.stub"})
//@EnableCircuitBreaker
public class HysTrixApplication {


    public static void main(String[] args) {

        SpringApplication.run(HysTrixApplication.class, args);

    }


    

}