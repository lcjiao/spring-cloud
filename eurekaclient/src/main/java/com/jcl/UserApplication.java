package com.jcl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@ComponentScan(value="com.jcl.*")
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {


    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);

    }


    

}