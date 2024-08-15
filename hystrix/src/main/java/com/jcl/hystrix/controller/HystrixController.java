package com.jcl.hystrix.controller;


import com.jcl.hystrix.facade.stub.TestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    private TestFacade testFacdeClient;



    @RequestMapping("/test/hello")
    public String test(String name) {
        return "hello world";
    }

    @RequestMapping("/test/hellohaha")
    public String error(String name) {
        return "you are error";
    }

    @RequestMapping("/test/getName")
    public String testGetName() {
        return testFacdeClient.getName();
    }

    @RequestMapping("/test/getNameTimeout")
    public String testGetNameTimeOut() {
        return testFacdeClient.getNameTimeOut();
    }


    

}