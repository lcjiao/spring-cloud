package com.jcl.mybatis.controller;


import com.jcl.mybatis.service.UserService;
import com.jcl.mybatis.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {

    @Autowired
    UserServiceImpl userService;

    @Value("${server.port}")
    String port;


    @RequestMapping("/hello")
    public String home(String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/test/hello")
    public String test(String name) {
        return "hello world";
    }

    @RequestMapping("/test")
    public String error(String name) {

        return userService.test();
    }



    

}