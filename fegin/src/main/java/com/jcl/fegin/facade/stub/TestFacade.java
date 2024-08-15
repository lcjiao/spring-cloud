package com.jcl.fegin.facade.stub;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-client-demo")
public interface TestFacade {

    @RequestMapping(value = "/getName")
    public String getName();
}
