package com.jcl.hystrix.facade.stub;

import org.springframework.stereotype.Component;

@Component
public class ExampleServiceFallback implements TestFacade{
    @Override
    public String getName() {
        return "backup-name";
    }

    @Override
    public String getNameTimeOut() {
        return "backup-name-timeout";
    }
}
