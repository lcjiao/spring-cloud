package com.jcl.eureka.server.start;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//https://blog.csdn.net/2401_83916241/article/details/137759293
@SpringCloudApplication
@EnableEurekaServer
public class ApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }
}