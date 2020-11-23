package com.twy.springbootjwt.controller;

import com.twy.springbootjwt.annotation.TokenRequired;
import com.twy.springbootjwt.entity.BaseResult;
import com.twy.springbootjwt.entity.User;
import com.twy.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongpeng
 * @date 2020/9/1 17:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public BaseResult login(User user) {
        String token = userService.login(user.getUserName(), user.getPassword());
        if (token == null) {
            return BaseResult.failed("登录失败");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return BaseResult.success(tokenMap, "登录成功");
    }

    @TokenRequired(required = true)
    @GetMapping("/hello")
    public String hello() {
        return "hello,JWT!";
    }
}
