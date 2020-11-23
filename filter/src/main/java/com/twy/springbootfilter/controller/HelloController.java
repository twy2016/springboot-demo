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
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/count")
    public String count(HttpServletRequest request) {
        return "在线人数：" + request.getSession().getServletContext().getAttribute("count");
    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "注销成功";
    }
}
