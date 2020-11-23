package com.twy.springbootfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gongpeng
 * @date 2020/8/12 11:13
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String result = (String) request.getAttribute("word");
        return "hello" + result;
    }
}
