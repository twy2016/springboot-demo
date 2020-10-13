package com.twy.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.mybatisplusdemo.entity.Test;
import com.twy.mybatisplusdemo.mapper.TestMapper;
import com.twy.mybatisplusdemo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author gongpeng
 * @date 2020/10/13 21:12
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
}
