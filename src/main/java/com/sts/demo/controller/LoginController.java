package com.sts.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/view")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
