package com.twy.test.controller;

import com.twy.test.entity.Page;
import com.twy.test.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author gongpeng
 * @date 2020/11/4 16:06
 */
@RestController
@RequestMapping("/test")
public class TestParamController {

    @GetMapping("/{id}")
    public String test1(@PathVariable String id) {
        return id;
    }

    @GetMapping("/test2")
    public String test2(@RequestParam String id) {
        return id;
    }

    @PostMapping("/test3")
    public String test3(@RequestParam String id) {
        return id;
    }

    @GetMapping("/test4")
    public String test4(@RequestBody User user) {
        return user.toString();
    }

    @PostMapping("/test5")
    public String test5(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping("/test6")
    public String test6(User user) {
        return user.toString();
    }

    @PostMapping("/test7")
    public String test7(User user) {
        return user.toString();
    }

    @GetMapping("/test8")
    public String test8(Page page, User user) {
        System.out.println(page);
        return user.toString();
    }

    @PostMapping("/test9")
    public String test9(Page page, User user) {
        System.out.println(page);
        return user.toString();
    }

}
