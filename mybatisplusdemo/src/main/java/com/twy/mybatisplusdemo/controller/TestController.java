package com.twy.mybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("/page")
    public Page<Test> list(Page page) {
        return testService.page(page);
    }

    @PostMapping("/save")
    public boolean save(Test test) {
        return testService.saveOrUpdate(test);
    }

    /**
     * 乐观锁更新
     * 需要先查询再更新，否则不会生效
     * @param id
     * @return
     */
    @PostMapping("/update")
    public boolean update(Integer id) {
        Test test = testService.getById(id);
        return testService.updateById(test);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return testService.removeById(id);
    }

    @PostMapping("/test")
    public boolean test(Test test) {
        return testService.test(test);
    }

}
