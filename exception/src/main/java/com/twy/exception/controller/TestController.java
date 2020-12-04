package com.twy.exception.controller;

import com.twy.common.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongpeng
 * @date 2020/12/4 9:47
 */
@RestController
@RequestMapping("/exception")
public class TestController {

    @GetMapping("/test1")
    public R test1(){
        int i = 1/0;
        return R.ok();
    }

    @GetMapping("/test2")
    public R test2(){
        String s = null;
        s.toString();
        return R.ok();
    }
}
