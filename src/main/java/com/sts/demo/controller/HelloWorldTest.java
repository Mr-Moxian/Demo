package com.sts.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldTest {

    @RequestMapping("/hello")
    public String printHello(){
        return "hello springboot!";
    }
}
