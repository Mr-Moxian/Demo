package com.sts.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorldTest {

    public static void main(String[] args) {
        String str = "成都市(成华区)(武侯区)(高新区)";
        System.out.println();
        Pattern p = Pattern.compile("\\((.*)\\)");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
