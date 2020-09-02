package com.twy.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongpeng
 * @date 2020-09-03 00:28
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello springboot!";
    }
}
