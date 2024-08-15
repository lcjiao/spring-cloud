package com.jcl.fegin.controller;


import com.jcl.fegin.facade.stub.TestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeginController {

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


    

}