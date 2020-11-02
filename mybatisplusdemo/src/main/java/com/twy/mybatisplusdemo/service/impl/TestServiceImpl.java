package com.twy.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.mybatisplusdemo.entity.Test;
import com.twy.mybatisplusdemo.mapper.TestMapper;
import com.twy.mybatisplusdemo.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author gongpeng
 * @date 2020/10/13 21:12
 */
@Service("testServiceImpl")
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Resource
    private TestMapper testMapper;
    @Resource(name = "newTestServiceImpl")
    private NewTestServiceImpl testService;

    @Transactional
    @Override
    public boolean test(Test test) {
        testMapper.save(test);
        testService.testSub();
        int i = 1/0;
        return true;
    }

    public static void main(String[] args) {
        Double a = 1.0d;
        Double b = 20.2d;
        Double c = 300.02d;
        System.out.println(a+b+c);
    }

}
