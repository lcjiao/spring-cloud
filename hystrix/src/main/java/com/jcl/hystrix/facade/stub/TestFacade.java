package com.jcl.hystrix.facade.stub;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-client-demo", fallback = ExampleServiceFallback.class)
public interface TestFacade {

    @RequestMapping(value = "/getName")
    public String getName();

    @RequestMapping(value = "/getName/timeout")
    public String getNameTimeOut();
}
