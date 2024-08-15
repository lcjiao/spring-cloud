package com.jcl.zuul.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

//https://www.jianshu.com/p/9c104186572d

@ComponentScan(value="com.jcl.*")
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    //默认的zuul结合eureka会将注册到eureka的服务名作为访问的ContextPath
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
