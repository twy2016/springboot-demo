package com.twy.springbootlistener.controller;

import com.twy.springbootlistener.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author gongpeng
 * @date 2020/8/11 16:17
 */
@RestController
@RequestMapping("/listener")
public class TestController {

    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (User) application.getAttribute("user");
    }

    @GetMapping("/total")
    public String total(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数" + count;
    }

    @GetMapping("/total2")
    public String total2(HttpServletRequest request, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            cookie.setMaxAge(48 * 60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数" + count;
    }
}
