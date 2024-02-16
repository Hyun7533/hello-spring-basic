package com.hello.core.web;

import com.hello.core.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLogger;

    @Autowired
    public LogDemoService(ObjectProvider<MyLogger> myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String testId) {
        myLogger.getObject("service id = " + testId);
    }
}
