package com.twy.springbootvalidation.controller;

import com.twy.springbootvalidation.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author gongpeng
 * @date 2020/8/6 14:42
 */
@RestController
public class UserController {

    @GetMapping("/test")
    public String test(@Valid @RequestBody User user){
        System.out.println(user);
        return "test";
    }
}
