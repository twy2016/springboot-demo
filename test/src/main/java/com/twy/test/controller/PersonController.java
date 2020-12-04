package com.twy.test.controller;

import com.twy.common.entity.R;
import com.twy.test.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gongpeng
 * @date 2020/12/4 15:02
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/test")
    public R test(@RequestBody Person person) {
        System.out.println(person);
        return R.ok();
    }

    @GetMapping("/test2")
    public R test2() {
        Person person = new Person(1,"测试", LocalDateTime.now());
        System.out.println(person);
        return R.ok(person);
    }

    @GetMapping("/test3")
    public R test3(Person person) {
        System.out.println(person);
        return R.ok(person);
    }

}
