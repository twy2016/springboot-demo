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
@Service("newTestServiceImpl")
public class NewTestServiceImpl {

    @Resource
    private TestMapper testMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean testSub() {
        Test test = new Test(25, "测试", "地址");
        testMapper.save(test);
        return true;
    }
}
