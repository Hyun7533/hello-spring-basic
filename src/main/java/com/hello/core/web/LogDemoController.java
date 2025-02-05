package com.hello.core.web;

import com.hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogDemoController {

    private final LogDemoService logDemoService;

    private final ObjectProvider<MyLogger> myLoggerProvider;

    @Autowired
    public LogDemoController(LogDemoService logDemoService, ObjectProvider<MyLogger> myLoggerProvider) {
        this.logDemoService = logDemoService;
        this.myLoggerProvider = myLoggerProvider;
    }

    @RequestMapping("/log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogg = myLoggerProvider.getObject(requestURL);
        myLogg.setRequestURL(requestURL);

        myLogg.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
