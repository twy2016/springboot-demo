package com.twy.mybatisplusdemo.controller;

import com.twy.mybatisplusdemo.entity.Test;
import com.twy.mybatisplusdemo.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gongpeng
 * @date 2020/10/13 13:40
 */
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/list")
    public List<Test> list() {
        List<Test> list = testService.list();
        return list;
    }

    @PostMapping("/save")
    public boolean save(Test test) {
        return testService.saveOrUpdate(test);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return testService.removeById(id);
    }

}
