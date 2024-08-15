package com.jcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jcl.service.UserBiz;
import com.jcl.repository.UserRepository;
import com.jcl.entity.UserEntity;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBiz userbiz;



    @Value("${server.port}")
    String port;

    @RequestMapping("/getName")
    public String getName(){
        return userbiz.getUserName();
    }
    
    @RequestMapping("/hello")
    public String home(String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/test/hello")
    public String test(String name) {
        return "hello world";
    }

    @RequestMapping("/test/hellohaha")
    public String error(String name) {
        return "you are error";
    }


    @RequestMapping(value = "/list")
    public List<UserEntity> getUserList(){
        return userRepository.findAll();
    }


    @RequestMapping("/getName/timeout")
    public String getNameTimeOut(){
        try {
            Thread.sleep(1500);
        }catch(Exception exception) {
            exception.printStackTrace();
        }



        return userbiz.getUserName();
    }
    

}